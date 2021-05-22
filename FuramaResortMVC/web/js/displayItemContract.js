function display(name) {
    switch (name) {
        case "employee":
            let idEmployee = document.getElementById("idBtnEmployee").value;
            document.getElementById("displayEmployee").style.display = "none";
            document.getElementById("idEmployee").value = idEmployee;
            document.getElementById("displayCus").style.display = "block"
            document.getElementById("displayService").style.display = "none"
            document.getElementById("displayForm").style.display = "none"
            break;
        case "customer":
            let idCus = document.getElementById("idBtnCus").value;
            document.getElementById("displayEmployee").style.display = "none";
            document.getElementById("idCus").value = idCus;
            document.getElementById("displayService").style.display = "block"
            document.getElementById("displayCus").style.display = "none"
            document.getElementById("displayForm").style.display = "none"
            break;
        case "service":
            let idService = document.getElementById("idBtnService").value;
            document.getElementById("displayEmployee").style.display = "none";
            document.getElementById("idService").value = idService;
            document.getElementById("rentalCostsContract").value = document.getElementById("rentalCosts").value;
            document.getElementById("displayService").style.display = "none"
            document.getElementById("displayCus").style.display = "none"
            document.getElementById("displayForm").style.display = "block"
            break;
        default:
            document.getElementById("displayService").style.display = "none"
            document.getElementById("displayCus").style.display = "none"
            document.getElementById("displayForm").style.display = "none"
            break;
    }
}
display(null);