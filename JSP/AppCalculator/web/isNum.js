function isNum() {
    let checkIsNum = new RegExp("/([0-9]+.[0-9]+)|([0-9]+)/")
    let firstOperand = document.getElementById("firstOperand")
    let secondOperand = document.getElementById("secondOperand")
    if (!firstOperand ==="" && !secondOperand ===""){
        if (!checkIsNum.test(firstOperand)) {
            alert("Vui lòng nhập vào một số.");
            return false;
        }
        if ( !checkIsNum.test(secondOperand)){
            alert("Vui lòng nhập vào một số.");
            return false;
        }
        return true;
    }else {
        alert("Vui lòng nhập vào một số.");
        return false;
    }
}