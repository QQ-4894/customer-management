document.addEventListener("DOMContentLoaded", () => {
const userList = document.getElementById("usersList");
const users = [
    {
        id: "U001",
        name: "山田太郎",
        department: "営業部",
        email: "yamada@example.com",
        role: "管理者"
    },
    {
        id: "U002",
        name: "佐藤花子",
        department: "営業部",
        email: "sato@example.com",
        role: "一般"
    },
    {
        id: "U003",
        name: "高橋健",
        department: "技術部",
        email: "takahashi@example.com",
        role: "一般"
    }
];

users.forEach(user => {
    const row = document.createElement("tr");
    row.innerHTML = `
    <td>${user.id}</td>
    <td>${user.name}</td>
    <td>${user.department}</td>
    <td>${user.email}</td>
    <td>${user.role}</td>
    `;
    userList.appendChild(row);
    });
});
