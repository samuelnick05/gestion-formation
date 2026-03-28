async function loadEmployes() {
    const employes = await apiGet("/employes");
    const table = document.getElementById("employesTable");

    table.innerHTML = "";

    employes.forEach(emp => {
        table.innerHTML += `
            <tr>
                <td>${emp.numeroEmploye}</td>
                <td>${emp.nom}</td>
                <td>${emp.adresse}</td>
            </tr>
        `;
    });
}

async function addEmploye() {
    const data = {
        numeroEmploye: parseInt(document.getElementById("num").value),
        nom: document.getElementById("nom").value,
        adresse: document.getElementById("adresse").value
    };

    await apiPost("/employes", data);
    alert("Employé ajouté !");
    window.location.href = "list.html";
}