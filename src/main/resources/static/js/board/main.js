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
        dataSendPost(url, sendData, "POST");
    }
};

board.init();


async function dataSendPost(url, data, method) {
    fetch(url, {
        method : method,
        headers : {
            "content-Type" : "application/json",
        },
        body : JSON.stringify(data)
        })
        .then((res) => res.status === 200 ? window.location.href = "/" : errMsg(res) )
}

function errMsg(err) {
    alert("API 호출 실패");
    console.log("status code :: ", err.status);
    return null;
}
