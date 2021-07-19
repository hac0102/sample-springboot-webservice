package com.sample.board.springboot.config.auth.dto;

import com.sample.board.springboot.web.dto.user.Role;
import com.sample.board.springboot.web.dto.user.UserDto;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Getter
@Slf4j
public class OAuthAttributes {

    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String name;
    private String email;
    private String picture;
    private String type;
    private int userNo;


    @Builder
    public OAuthAttributes(Map<String, Object> attributes, String nameAttributeKey, String name, String email, String picture, String type) {
        this.attributes = attributes;
        this.nameAttributeKey = nameAttributeKey;
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.type = type;
    }

    public static OAuthAttributes of(String registrationId, String userNameAttributeName, Map<String, Object> attributes) {
        if("naver".equals(registrationId)) {
            return ofNaver("id", attributes, registrationId);
        }
//
//        if("Kakao".equals(registrationId)) {
//            return ofKakao("id", attributes, registrationId);
//        }

        return ofGoogle(userNameAttributeName, attributes, registrationId);
    }

//    private static OAuthAttributes ofKakao(String id, Map<String, Object> attributes, String registrationId) {
//        log.info("카카오 로그인 정보 response :: {}", attributes);
//        log.info("카카오 로그인 정보 registrationId :: {}", registrationId);
//        return null;
//    }

    private static OAuthAttributes ofGoogle(String userNameAttributeName, Map<String, Object> attributes, String registrationId) {
        log.info("구글 로그인 정보 response :: {}", attributes);
        return OAuthAttributes.builder()
                .name((String) attributes.get("name"))
                .email((String) attributes.get("email"))
                .picture((String) attributes.get("picture"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .type(registrationId)
                .build();
    }

    private static OAuthAttributes ofNaver(String userNameAttributeName, Map<String, Object> attributes, String registrationId) {
        Map<String, Object> response = (Map<String, Object>) attributes.get("response");
        log.info("네이버 로그인 정보 response :: {}",  response);

        return OAuthAttributes.builder()
                .name((String) response.get("name"))
                .email((String) response.get("email"))
                .picture((String) response.get("profile_image"))
                .attributes(response)
                .nameAttributeKey(userNameAttributeName)
                .type(registrationId)
                .build();
    }

    public UserDto toEntity() {
        return UserDto.builder()
                .name(name)
                .emailAddr(email)
                .picture(picture)
                .userRole(Role.USER)
                .joinType(type)
                .userNo(userNo)
                .build();
    }
}
