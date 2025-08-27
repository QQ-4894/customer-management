const baseURL = window.location.hostname.includes("localhost")
  ? "http://localhost:8080"
  : "";

fetch("../customers/templates/customer-list-row.html")
.then(res => res.text())
.then(template => {
    fetch(`${baseURL}/api/customers`)
    .then(res => res.json())
    .then(data => {
        const tbody = document.getElementById("customer-list");
        tbody.innerHTML = "";

        data.forEach(c => {
            const row = template
            .replace(/{{id}}/g, c.id ?? "")
            .replace(/{{name}}/g, c.name ?? "")
            .replace(/{{email}}/g, c.email ?? "")
            .replace(/{{phone}}/g, c.phone ?? "")
            .replace(/{{address}}/g, c.address ?? "");

            tbody.insertAdjacentHTML("beforeend", row);
        });
    });
});
