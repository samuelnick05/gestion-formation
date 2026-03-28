// assets/js/inscriptions.js

// ---------- INSCRIPTION ----------
async function inscrireEmploye() {
    const data = {
        idDemande: document.getElementById("idDemande").value,
        idSession: document.getElementById("idSession").value,
        dateInscription: document.getElementById("date").value
    };

    await apiPost("/inscriptions", data);

    alert("Employé inscrit avec succès !");
    window.location.href = "inscrire.html";
}

// ---------- ANNULATION ----------
async function annulerInscription() {
    const id = document.getElementById("idInscription").value;

    await apiPut(`/inscriptions/${id}/annuler`, {});
    alert("Inscription annulée !");
    window.location.href = "annuler.html";
}

// ---------- CLOTURE ----------
async function cloturerFormation() {
    const id = document.getElementById("idInscription").value;

    const data = {
        appreciation: document.getElementById("appreciation").value,
        document: document.getElementById("document").value
    };

    await apiPut(`/inscriptions/${id}/cloturer`, data);

    alert("Formation clôturée avec succès !");
    window.location.href = "cloturer.html";
}