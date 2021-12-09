const topNewsElement = document.getElementById("top-news");
const prevButton = document.getElementById("prev");
const contentDiv = document.getElementById("content")
const nextButton = document.getElementById("next");

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
