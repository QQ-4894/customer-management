const baseURL = window.location.hostname.includes("localhost")
  ? "http://localhost:8080"
  : "";

document.getElementById("customerForm").addEventListener("submit", function(e) {
    e.preventDefault();

    const customer = {
        name: document.getElementById("customerName").value,
        email: document.getElementById("customerEmail").value,
        phone: document.getElementById("customerTel").value,
        address: document.getElementById("customerAddress").value,
    };

    fetch(`${baseURL}/api/customers`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(customer)
    })
    .then(res => res.json())
    .then(data => {
        alert("登録成功!");
        const customerID = data.id;
        window.location.href = "../index.html";
    })
    .catch(err => {
        console.error("通信エラー:", err);
        alert("通信エラーが発生しました。")
    });
});