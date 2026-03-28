// assets/js/sessions.js

async function loadSessions() {
    const sessions = await apiGet("/sessions");
    const table = document.getElementById("sessionsTable");

    table.innerHTML = "";

    sessions.forEach(s => {
        table.innerHTML += `
            <tr>
                <td>${s.idSession}</td>
                <td>${s.date}</td>
                <td>${s.prix}</td>
            </tr>
        `;
    });
}

async function addSession() {
    const data = {
        idSession: parseInt(document.getElementById("id").value),
        date: document.getElementById("date").value,
        prix: parseFloat(document.getElementById("prix").value)
    };

    await apiPost("/sessions", data);

    alert("Session ajoutée !");
    window.location.href = "list.html";
}