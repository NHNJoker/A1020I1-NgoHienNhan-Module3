let checkBirth = new RegExp(/^[0-9]{2}\/(([0][1-9])|([1][0-2]))\/(([1][9][3-9)][0-9])|([2][0][0-2][0-1]))$/);
let checkID = new RegExp(/^[0-9]{9}$/);
let checkEmail = new RegExp(/^([a-z-A-Z-0-9])+[@][a-z]{5}[.][a-z]{3}$/);
let checkNum = new RegExp(/^[0-9]+$/);
let checkPhone = new RegExp(/^((091)|(090))[0-9]{7}$/)

function validateService() {

    let areaService = document.getElementById("areaUsed").value;

    if (!checkNum.test(areaService)) {
        document.getElementById("msgArea").innerText = "Input must be numeric."
        return false
    } else {
        document.getElementById("msgArea").innerText = ""
    }
    let numFloor = document.getElementById("numberOfFloors").value;

    if (!checkNum.test(numFloor)) {
        document.getElementById("msgFloor").innerText = "Input must be numeric."
        return false
    } else {
        document.getElementById("msgFloor").innerText = ""
    }
    let maxPeople = document.getElementById("maxPeople").value;

    if (!checkNum.test(numFloor)) {
        document.getElementById("msgMaxPeople").innerText = "Input must be numeric."
        return false
    } else {
        document.getElementById("msgMaxPeople").innerText = ""
    }

    let rentalCost = document.getElementById("rentalCosts").value;

    if (!checkNum.test(numFloor)) {
        document.getElementById("msgRentalCosts").innerText = "Input must be numeric.."
        return false
    } else {
        document.getElementById("msgRentalCosts").innerText = ""
    }
    return true;
}

function validateCus() {
    let nameEdit = "";
    let name = document.getElementById('inputNameCus').value;
    name = name.trim().toLowerCase();
    for (let i = 0; i < name.length; i++) {
        if (name.charAt(i) === " " && name.charAt(i + 1) === " ") {
            continue;
        }
        if (i === 0 || name.charAt(i - 1) === " ") {
            nameEdit += name.charAt(i).toUpperCase();
            continue
        }
        nameEdit += name.charAt(i);
    }
    name = nameEdit;
    if (name === '') {
        document.getElementById('msgName').innerText = "Please enter the name customer.";
        return false;
    } else {
        document.getElementById('msgName').innerText = "";
    }

    let date = document.getElementById("inputDateOfBirth").value;
    let subString = date.split("-");
    let today = new Date();

    if (date == null) {
        document.getElementById('msgDate').innerText = "Please enter the date of birth.";
        return false;
    } else {
        if ((today.getFullYear() - subString[0]) <= 18) {
            document.getElementById('msgDate').innerText = "Customer must be 18 years old.";
            console.log("3");
            return false;
        } else {
            document.getElementById('msgDate').innerText = "";
        }
    }

    let idCus = document.getElementById("inputID").value;
    let idTest = checkID.test(idCus)
    if (idCus == null) {
        document.getElementById('msgID').innerText = "Please enter the ID card.";
        return false;
    } else {
        if (!idTest) {
            console.log("4");
            document.getElementById('msgID').innerText = "ID card must be 9 numbers.";
            return false;
        } else {
            document.getElementById('msgID').innerText = "";
        }
    }

    console.log(!checkID.test(idCus))
    let phone = document.getElementById("inputPhone").value;
    if (!checkPhone.test(phone)) {
        document.getElementById('msgPhone').innerText = "The phone number must have all 10 numbers and the prefix is ​​090 or 091.";
        return false;
    } else {
        document.getElementById('msgPhone').innerText = "";
    }

    return true;
}