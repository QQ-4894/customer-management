document.addEventListener("DOMContentLoaded", () => {
    const inquiries = [
        {
            timestamp: "2025-08-22 14:30",
            name: "山田太郎",
            email: "taro@example.com",
            message: "サービスについて質問があります。"
        },
        {
            timestamp: "2025-08-22 15:10",
            name: "佐藤花子",
            email: "hanako@example.com",
            message: "ログインできません。"
        }
    ];

    const tbody = document.getElementById("inquiryList");
    
    inquiries.forEach(inquiry => {
        const row = document.createElement("tr");
        row.innerHTML = `
        <td>${inquiry.timestamp}</td>
        <td>${inquiry.name}</td>
        <td>${inquiry.email}</td>
        <td>${inquiry.message}</td>
        `;
        tbody.appendChild(row);
    });
});
