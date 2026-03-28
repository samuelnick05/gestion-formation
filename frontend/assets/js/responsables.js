// assets/js/responsables.js

async function addResponsable() {
    const data = {
        numeroEmploye: parseInt(document.getElementById("num").value),
        nom: document.getElementById("nom").value,
        adresse: document.getElementById("adresse").value,
        dateNomination: document.getElementById("dateN").value
    };

    await apiPost("/responsables", data);

    alert("Responsable ajouté !");
    window.location.href = "add.html";
}