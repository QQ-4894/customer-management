const baseURL = window.location.hostname.includes("localhost")
  ? "http://localhost:8080"
  : "";

const params = new URLSearchParams(window.location.search);
const customerID = params.get("customerID");

function deleteCustomer(id) {
    fetch(`${baseURL}/api/customers/${id}`, {
        method: "DELETE"
    })
    .then(res => {
        const message = document.getElementById("deleteMessage");
        if (res.ok) {
            message.textContent = "顧客を削除しました。";
        } else {
            message.textContent = "削除に失敗しました。";
        }
    })
    .catch(err => {
        console.error("削除エラー:", err);
        document.getElementById("deleteMessage").textContent = "通信エラーが発生しました。";
    });
}

if (customerID) {
    deleteCustomer(customerID);
} else {
    document.getElementById("deleteMessage").textContent = "削除対象の顧客IDが指定されていません。";
}
