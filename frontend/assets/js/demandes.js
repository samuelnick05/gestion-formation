// assets/js/demandes.js

// Soumettre une nouvelle demande de formation
async function submitDemande() {
    const data = {
        idEmploye: document.getElementById("employe").value,
        idFormation: document.getElementById("formation").value,
        dateDemande: document.getElementById("date").value
    };

    await apiPost("/demandes", data);

    alert("Demande soumise !");
    window.location.href = "create.html";
}

// Charger la liste des demandes (pour instruire)
async function loadDemandeForInstr() {
    const id = new URLSearchParams(window.location.search).get("id");

    document.getElementById("idDemande").value = id;
}

// Instruire une demande
async function instruireDemande() {
    const id = document.getElementById("idDemande").value;

    const data = {
        idResponsable: document.getElementById("responsable").value,
        accepter: document.getElementById("accepter").checked
    };

    await apiPut(`/demandes/${id}/instruire`, data);

    alert("Demande instruite !");
    window.location.href = "instruire.html";
}