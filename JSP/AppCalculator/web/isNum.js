function isNum() {
    let checkIsNum = new RegExp("([0-9]+.[0-9]+)|([0-9]+)")
    let firstOperand = document.getElementById("firstOperand").value;
    let secondOperand = document.getElementById("secondOperand").value;
    if (!(firstOperand ==="") && !(secondOperand ==="")){
        if (!checkIsNum.test(firstOperand)) {
            alert("Vui lòng nhập vào một số.1");
            return false;
        }
        if (!checkIsNum.test(secondOperand)){
            alert("Vui lòng nhập vào một số.2");
            return false;
        }
        return true;
    }else {
        alert("Vui lòng nhập vào một số.3");
        return false;
    }
}