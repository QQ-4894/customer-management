const baseURL = window.location.hostname.includes("localhost")
  ? "http://localhost:8080"
  : "";

const params = new URLSearchParams(window.location.search);
const customerID = params.get("customerID");

if (customerID) {
    loadCustomerData(customerID);
} else {
    alert("customerIDが指定されていません。");
}

function loadCustomerData(id) {
    fetch(`${baseURL}/api/customers/${id}`)
    .then(res => {
        if (!res.ok) throw new Error("取得失敗");
        return res.json();
    })
        .then(customer => {
            document.getElementById("customerID").value = customer.id;
            document.getElementById("customerName").value = customer.name;
            document.getElementById("customerEmail").value = customer.email;
            document.getElementById("customerTel").value = customer.phone;
            document.getElementById("customerAddress").value = customer.address;

            const deleteLink = document.getElementById("deleteLink");
            if (deleteLink) {
                deleteLink.href = `../delete/index.html?customerID=${customer.id}`;
            }
    })
    .catch(err => {
        console.error("取得エラー:", err);
        alert("顧客情報の取得に失敗しました。");
    });
}

document.getElementById("editCustomerForm").addEventListener("submit", function(e) {
    e.preventDefault();

    const customerID = document.getElementById("customerID").value;

    const updatedCustomer = {
    name: document.getElementById("customerName").value,
    email: document.getElementById("customerEmail").value,
    phone: document.getElementById("customerTel").value,
    address: document.getElementById("customerAddress").value
};

fetch(`${baseURL}/api/customers/${customerID}`, {
    method: "PUT",
    headers: {
        "Content-Type": "application/json"
    },
    body: JSON.stringify(updatedCustomer)
})
.then(res => {
    if (res.ok) {
        alert("顧客情報を保存しました！");
        window.location.href = "../../customers/index.html";
    } else {
        alert("保存に失敗しました。");
    }
})
.catch(err => {
    console.error("通信エラー:", err);
    alert("通信エラーが発生しました。");
    });
});