
console.log("board메인 js");
console.log("board메인 js :: ", boardList);


let board = {
    init : function() {
        let _this = this;

        document.querySelector('#brSaveBtn').addEventListener('click', () => {
            _this.insertBoard();
        });

    },

    insertBoard : function() {
        let url = '/board';
        const sendData = {};
        sendData["title"] = document.querySelector('#brTitle').value;
        sendData["content"] = document.querySelector('#brContent').value;
        console.log("sendData :: ", sendData);
        dataSend(sendData, "POST", url);

    }

};

board.init();

function dataSend(data, method, url) {
    let res = fetch(url, {
        method: method,
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify(data)
    })
    .then(response => {
        if(response.status != 200){
            alert("글등록 실패");
            return null;
        }
        window.location.href = "/";
    })
//    .then(result => {
//        window.location.href = "/";
//    })

//    let result = await res.json();
}


