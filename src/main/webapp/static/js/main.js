const topNewsElement = document.getElementById("top-news");
const prevButton = document.getElementById("prev");
const contentDiv = document.getElementById("content")
const nextButton = document.getElementById("next");

contentDiv.classList.add("cards_wrap");
topNewsElement.addEventListener("click", topNews);

async function topNews() {
    const news = await getTopNews();
}

async function getTopNews() {
    return await apiGet("/top-news");
}

async function apiGet(url) {
    let response = await fetch(url, {
        method: "GET",
    });
    if (response.ok) {
        return response.json();
    }
}

function cardBuilder(news) {
    for (const currentNews of news) {
        let cardItemDiv = document.createElement("div");
        let cardDiv = document.createElement("div");
        let titleDiv = document.createElement("div");
        let timeAgoDiv = document.createElement("div");
        let authorDiv = document.createElement("div");
        let titleLink = document.createElement("a");
        cardItemDiv.classList.add("card_item");
        cardDiv.classList.add("card_inner");
        titleDiv.classList.add("title");
        timeAgoDiv.classList.add("time_ago");
        authorDiv.classList.add("author");
        titleLink.href = currentNews["url"];
        titleLink.innerText = currentNews["title"];
        titleDiv.append(titleLink);
        timeAgoDiv.innerText = currentNews["time_ago"];
        authorDiv.innerText = currentNews["user"];
        cardDiv.append(titleDiv, timeAgoDiv, authorDiv);
        cardItemDiv.append(cardDiv);
        contentDiv.append(cardItemDiv);
    }
}
