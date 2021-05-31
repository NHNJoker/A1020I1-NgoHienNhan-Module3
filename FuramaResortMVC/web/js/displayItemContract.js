function display() {
    document.getElementById("displayService").style.display = "none"
    document.getElementById("displayCus").style.display = "none"
    document.getElementById("displayForm").style.display = "none"
}

display();

function displayEmployee(id) {
    document.getElementById("displayEmployee").style.display = "none";
    document.getElementById("idEmployee").value = id;
    document.getElementById("displayCus").style.display = "block"
    document.getElementById("displayService").style.display = "none"
    document.getElementById("displayForm").style.display = "none"
}

function displayCus(id) {
    document.getElementById("displayEmployee").style.display = "none";
    document.getElementById("idCus").value = id;
    document.getElementById("displayService").style.display = "block"
    document.getElementById("displayCus").style.display = "none"
    document.getElementById("displayForm").style.display = "none"
}

function displayService(id, price) {
    document.getElementById("displayEmployee").style.display = "none";
    document.getElementById("idService").value = id;
    document.getElementById("rentalCostsContract").value = price;
    document.getElementById("displayService").style.display = "none"
    document.getElementById("displayCus").style.display = "none"
    document.getElementById("displayForm").style.display = "block"
}
