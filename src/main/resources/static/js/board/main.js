let board = {
    init : function() {
        let _this = this;

        document.querySelector('#brSaveBtn').addEventListener('click', () => {
            _this.insertBoard();
        });

        document.querySelector("#boardTable").addEventListener('click', (e) => {
            let selBrNo = e.target.closest("tr").getAttribute("selBrNo");
            if(selBrNo == null) return null;
            console.log(_this);
            _this.getBoardDetailData(selBrNo);
        })

    },

    insertBoard : function() {
        let url = '/board';
        const sendData = {};
        sendData["title"] = document.querySelector('#brTitle').value;
        sendData["content"] = document.querySelector('#brContent').value;
        dataSendPost(url, sendData, "POST");
    },

    getBoardDetailData : function(selBrNo) {
        let url = '/board/'
        getDetailData(url, selBrNo)

    }
};

board.init();

async function getDetailData(url, brNo){
    fetch(url + (brNo == (undefined || null) ? '' : brNo))
    .then((res) => {
        if(res.status != 200) return null;
//        console.log("res :: ", res);
//        console.log("res1111 :: ", res.html());
        return res.text();
    })
    .then((data) => {
        console.log("data ::: ", data);
        document.querySelector("#testDiv").innerHTML = data;
    })
    .catch(err => {
        console.log("err :: ", err);
    })
}




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
