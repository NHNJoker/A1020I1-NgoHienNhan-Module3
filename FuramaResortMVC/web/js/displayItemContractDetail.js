function displayAccompaniedService(id) {
    document.getElementById("row"+id).style.backgroundColor="blue";
    document.getElementById("idAccompaniedService").value=id;
}

function displayContract(id) {
    document.getElementById("idContract").value=id;
    document.getElementById("displayContract").style.display = "none";
    document.getElementById("displayAccompaniedService").style.display = "block";
}

function display() {
    document.getElementById("displayAccompaniedService").style.display = "none";
}
display();