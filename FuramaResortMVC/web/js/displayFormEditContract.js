function displayDefault() {
    document.getElementById("displayTableCus").style.display = "none";
    document.getElementById("displayTableEmployee").style.display = "none";
    document.getElementById("displayTableService").style.display = "none";
    document.getElementById("displayTableAccompaniedService").style.display = "none";
}
displayDefault();

function displayEditCus() {
    document.getElementById("displayTableCus").style.display = "block";
}

function chooseCus(idCus, nameCus) {
    document.getElementById("idCus").value = idCus;
    document.getElementById("nameCus").innerHTML = nameCus;
    document.getElementById("displayTableCus").style.display = "none";
}

function displayEditEmployee() {
    document.getElementById("displayTableEmployee").style.display = "block";
}

function chooseEmployee(idEmployee, nameEmployee) {
    document.getElementById("idEmployee").value = idEmployee;
    document.getElementById("nameEmployee").innerHTML = nameEmployee;
    document.getElementById("displayTableEmployee").style.display = "none";
}

function displayEditService() {
    document.getElementById("displayTableService").style.display = "block";
}

function chooseService(idService, rentalCosts, nameService) {
    document.getElementById("idService").value = idService;
    document.getElementById("nameService").innerHTML = nameService;
    document.getElementById("rentalCostsContract").value = rentalCosts;
    document.getElementById("displayTableService").style.display = "none";
}

function displayEditAccompaniedService() {
    document.getElementById("displayTableAccompaniedService").style.display = "block";
}

function chooseAccompaniedService(idAccompaniedService, nameAccompaniedService) {
    document.getElementById("idAccompaniedService").value = idAccompaniedService;
    document.getElementById("nameAccompaniedService").innerHTML = nameAccompaniedService;
    document.getElementById("displayTableAccompaniedService").style.display = "none";
}
