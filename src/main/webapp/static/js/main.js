const topNewsElement = document.getElementById("top-news");
const prevButton = document.getElementById("prev");
const contentDiv = document.getElementById("content")
const nextButton = document.getElementById("next");

async function apiGet(url) {
    let response = await fetch(url, {
        method: "GET",
    });
    if (response.ok) {
        return response.json();
    }
}
