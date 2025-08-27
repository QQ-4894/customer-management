document.addEventListener("DOMContentLoaded", () => {
    const logsList = document.getElementById("historyList");

    const logsData = [
        {
            date: "2025-08-20 10:00",
            company: "株式会社カトウ",
            contact: "田中一郎",
            content: "新製品の提案",
            visitor: "営業部・山田和樹"
        },
        {
            date: "2025-08-21 14:30",
            company: "株式会社鈴木",
            contact: "佐藤花子",
            content: "契約更新の打ち合わせ",
            visitor: "営業部・佐々木健"
        },
    ];

    logsData.forEach(log => {
        const row = document.createElement("tr");
        row.innerHTML = `
        <td>${log.date}</td>
        <td>${log.company}</td>
        <td>${log.contact}</td>
        <td>${log.content}</td>
        <td>${log.visitor}</td>
        `;
        logsList.appendChild(row);
    });
});
