async function loadFormations() {
    const formations = await apiGet("/formations");
    const table = document.getElementById("formationsTable");

    table.innerHTML = "";

    formations.forEach(f => {
        table.innerHTML += `
            <tr>
                <td>${f.numeroFormation}</td>
                <td>${f.nomFormation}</td>
                <td>${f.contenuTexte}</td>
                <td>
                    <a href="edit.html?id=${f.numeroFormation}">Modifier</a>
                </td>
            </tr>`;
    });
}

async function addFormation() {
    const data = {
        numeroFormation: parseInt(document.getElementById("num").value),
        nomFormation: document.getElementById("nom").value,
        contenuTexte: document.getElementById("contenu").value
    };

    await apiPost("/formations", data);
    alert("Formation ajoutée !");
    window.location.href = "list.html";
}

async function loadFormationForEdit() {
    const id = new URLSearchParams(window.location.search).get("id");

    const formations = await apiGet("/formations");
    const f = formations.find(x => x.numeroFormation == id);

    document.getElementById("num").value = f.numeroFormation;
    document.getElementById("nom").value = f.nomFormation;
    document.getElementById("contenu").value = f.contenuTexte;
}

async function updateFormation() {
    const data = {
        numeroFormation: parseInt(document.getElementById("num").value),
        nomFormation: document.getElementById("nom").value,
        contenuTexte: document.getElementById("contenu").value
    };

    await apiPost("/formations", data);
    alert("Formation mise à jour !");
    window.location.href = "list.html";
}