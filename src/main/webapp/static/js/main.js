const topNewsElement = document.getElementById("top-news");
const prevButton = document.getElementById("prev");
const contentDiv = document.getElementById("content");
const nextButton = document.getElementById("next");
const newestNewsElement = document.getElementById("newest");
const jobsElement = document.getElementById("jobs");
const mainPage = document.getElementById("main-page");
const buttonsDiv = document.getElementById("nav-buttons");

contentDiv.classList.add("cards_wrap");
topNewsElement.addEventListener("click", topNews);
prevButton.addEventListener("click", previousPage);
nextButton.addEventListener("click", nextPage);
newestNewsElement.addEventListener("click", getNewestNews);
jobsElement.addEventListener("click", getJobs);
mainPage.addEventListener("click", init);

async function getNewestNews() {
    let news = await apiGet("/newest");
    cardBuilder(news);
    setupButtons("/newest?page=");
    topNewsElement.firstElementChild.classList.remove("active-page");
    jobsElement.firstElementChild.classList.remove("active-page");
    mainPage.firstElementChild.classList.remove("active-page");
    newestNewsElement.firstElementChild.classList.add("active-page");
}

async function topNews() {
    const news = await getTopNews();
    cardBuilder(news);
    setupButtons("/top-news?page=");
    topNewsElement.firstElementChild.classList.add("active-page");
    jobsElement.firstElementChild.classList.remove("active-page");
    mainPage.firstElementChild.classList.remove("active-page");
    newestNewsElement.firstElementChild.classList.remove("active-page");
}

async function getJobs() {
    const news = await apiGet("/jobs");
    cardBuilder(news);
    setupButtons("/jobs?page=");
    topNewsElement.firstElementChild.classList.remove("active-page");
    jobsElement.firstElementChild.classList.add("active-page");
    mainPage.firstElementChild.classList.remove("active-page");
    newestNewsElement.firstElementChild.classList.remove("active-page");
}

async function previousPage() {
    let currentPage = parseInt(prevButton.dataset.currentPage);
    let url = prevButton.dataset.url;
    let pageIdentifier = (currentPage - 1).toString();
    nextButton.dataset.currentPage = pageIdentifier;
    prevButton.dataset.currentPage = pageIdentifier;
    let news = await apiGet(url + pageIdentifier);
    cardBuilder(news);
}

async function nextPage() {
    let currentPage = parseInt(nextButton.dataset.currentPage);
    let url = nextButton.dataset.url;
    let pageIdentifier = (currentPage + 1).toString();
    nextButton.dataset.currentPage = pageIdentifier;
    prevButton.dataset.currentPage = pageIdentifier;
    let news = await apiGet(url + pageIdentifier);
    cardBuilder(news);
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

function setupButtons(url) {
    nextButton.dataset.currentPage = "1";
    prevButton.dataset.currentPage = "1";
    buttonsDiv.style.display = "block";
    prevButton.dataset.url = url;
    nextButton.dataset.url = url;
}

function cardBuilder(news) {
    contentDiv.innerHTML = "";
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

async function init() {
    let content = await apiGet("/top-news");
    cardBuilder(content);
    buttonsDiv.style.display = "none";
    mainPage.firstElementChild.classList.add("active-page");
    newestNewsElement.firstElementChild.classList.remove("active-page");
    topNewsElement.firstElementChild.classList.remove("active-page");
    jobsElement.firstElementChild.classList.remove("active-page");
}

init();
