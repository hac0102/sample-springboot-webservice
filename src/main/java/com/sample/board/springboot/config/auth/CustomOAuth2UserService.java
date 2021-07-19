package com.sample.board.springboot.config.auth;

import com.sample.board.springboot.config.auth.dto.OAuthAttributes;
import com.sample.board.springboot.config.auth.dto.SessionUser;
import com.sample.board.springboot.mapper.user.UserMapper;
import com.sample.board.springboot.web.dto.user.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.Collections;

@RequiredArgsConstructor
@Service
@Slf4j
@Transactional
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    private final UserMapper userMapper;
    private final HttpSession httpSession;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        OAuth2UserService delegate = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = delegate.loadUser(userRequest);

        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        String userNameAttributeName = userRequest.getClientRegistration().getProviderDetails().getUserInfoEndpoint().getUserNameAttributeName();

        OAuthAttributes attributes = OAuthAttributes.of(registrationId, userNameAttributeName, oAuth2User.getAttributes());

        UserDto user = saveOrUdate(attributes);

        httpSession.setAttribute("userSession", new SessionUser(user));

        return new DefaultOAuth2User(
                Collections.singleton(new SimpleGrantedAuthority(user.getRoleKey())),
                attributes.getAttributes(),
                attributes.getNameAttributeKey());
    }

    @Transactional
    private UserDto saveOrUdate(OAuthAttributes attributes) {
//        UserDto userDto = userMapper.selectUserInfo(attributes.toEntity())
//                .map(entity -> entity.update(attributes.getName(), attributes.getPicture()))
//                .orElse(attributes.toEntity());
        UserDto user = UserDto.builder()
                .emailAddr(attributes.toEntity().getEmailAddr())
                .name(attributes.toEntity().getName())
                .joinType(attributes.toEntity().getJoinType())
                .picture(attributes.toEntity().getPicture())
                .userRole(attributes.toEntity().getUserRole())
                .build();

        userMapper.insertUserJoin(user);
        userMapper.insertUserJoinHistory(user);
        return user;
    }
}
