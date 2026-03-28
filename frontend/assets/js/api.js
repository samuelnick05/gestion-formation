const API_URL = "http://localhost:8080/api";

async function apiGet(route) {
    const res = await fetch(API_URL + route);
    return res.json();
}

async function apiPost(route, data) {
    const res = await fetch(API_URL + route, {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify(data)
    });
    return res.json();
}

async function apiPut(route, data) {
    const res = await fetch(API_URL + route, {
        method: "PUT",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify(data)
    });
    return res.json();
}

async function apiDelete(route) {
    const res = await fetch(API_URL + route, {method: "DELETE"});
    return res.json();
}