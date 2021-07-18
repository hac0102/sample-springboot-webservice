let board = {
    init : function() {
        let _this = this;

        document.querySelector('#brSaveBtn').addEventListener('click', () => {
            _this.insertBoard();
        });

        document.querySelector("#boardTable").addEventListener('click', (e) => {
            let selBrNo = e.target.closest("tr").getAttribute("selBrNo");
            if(selBrNo == null) return null;
            _this.getBoardDetailData(selBrNo);
        });

        document.querySelector("#brUpdateBtn").addEventListener('click', (e) => {
            btnChgFormFiled("update");
        });

        document.querySelector("#brUpdateSaveBtn").addEventListener('click', (e) => {
            _this.updateBoard();
        });


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
    },

    updateBoard() {
        let url = '/board';
        const sendData = {};
        sendData["brNo"] = document.querySelector('#brDtlBrNo').value;
        sendData["title"] = document.querySelector('#brDtlTitle').value;
        sendData["content"] = document.querySelector('#brDtlContent').value;
        dataSendPost(url, sendData, "PUT");
    }

};

board.init();

async function getDetailData(url, brNo){
    fetch(url + (brNo == (undefined || null) ? '' : brNo))
    .then((res) => {
        return res.status != 200 ? null : res.text();
    })
    .then((data) => {
        document.querySelector("#testDiv").innerHTML = data;
        btnChgFormFiled("detail");
    })
    .catch(err => {
        errMsg(err);
//        console.log("getDetailData :: err :: ", err);
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
        .then((res) => res.status === 200 ? pageReset(true) : errMsg(res) )
}

function pageReset(flag){
    window.location.href = "/";
}

function errMsg(err) {
    alert("API 호출 실패");
    console.log("status code :: ", err.status);
    return null;
}

function btnChgFormFiled(flag){
    document.getElementById("brDtlTitle").disabled = flag === "update" ? false : true;
    document.getElementById("brDtlContent").disabled = flag === "update" ? false : true;
    document.querySelector("#brUpdateBtn").style.display = flag === "update" ? "none" : "";
    document.querySelector("#brUpdateSaveBtn").style.display = flag === "update" ? "" : "none";
}
