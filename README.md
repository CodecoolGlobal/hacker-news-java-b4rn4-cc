# Hacker news client

## Story

One of your best friends, Michael Hackson is really into tech news.
He loves aggregator sites where there are no ads, only news articles with their titles.
This allows Michael to decide whether the title is catchy enough to navigate to the article,
or if he should just ignore it.
This is the reason he always talks about [Hacker news](https://news.ycombinator.com/news).
Although he loves the site, he'd like some extra custom features and a more exciting design that is less... spartan.
He knows your background and admires your programming skills, so he reached out to you
to create a custom-looking hacker news client exclusively for him.
As his birthday is around the corner, you take the opportunity to surprise him.

## What are you going to learn?

- Refresh your knowledge of asynchronously fetching data from backend.
- Serialize data to JSON.
- Call an API from the backend.
- Understand layered architecture.
- Use web servlets in Java.


## Tasks

1. Create a web application which renders news from the `Hacker news` site.
    - The opening page of the website (`/`) can be accessed.
    - There is a menu at the top of the page with the following elements.
- `Hackson news`
- `Top news`
- `Newest`
- `Jobs`
    - Clicking Hackson news redirects to the start page.
    - Clicking top news refreshes the inner content of the page with the top news without reloading the page. See details below.
    - Clicking jobs, refreshes the inner content of the page with the jobs without reloading the page. See details below.
    - There is a footer with the name and email address of the developer.

2. Show top news from `Hacker News` site as cards next to each other.
    - There is an `/api/top?page=1` API endpoint implemented by a servlet which provides top news data in the following JSON format. ```json [
  {
  "title": "Show HN: I'm starting a Svelte JavaScript newsletter",
  "timeAgo": "a few seconds ago",
  "author": "d3sandoval",
  "url": "https://svelte.substack.com/"
  },
  ...
] ... ``` - If the page parameter is not set, the first thirty elements are received. - If the page parameter is set, the respective page is received (`GET /api/top?page=5` returns with the news from the 5 fifth page).
    - This endpoint uses the data from Hacker News API (api.hnpwa.com), which is retrieved on the backend side. (See General requirements.)
    - The opening page of the website (`/`) loads the first thirty top news articles from hacker news.
    - The page has an HTML `div` element that contains the data in cards.
    - Every card shows the following information on a news article.
- `Title`, which is also a link to the original article.
- `Author`, the uploader, if available.
- `TimeAgo`, which is the publication date.
    - The webpage follows a basic design. ![Hackernews Screenshot 01](media/oop/hacker-news-screenshot-01.png)
    - There is a next button above the cards. Clicking this button displays the next thirty news articles, if available.
    - There is a previous button above the cards. Clicking this button displays the previous thirty news articles, if available.

3. When I select `Newest` from the menu, the page content changes to newest news.
    - There is an `/api/newest?page=1` API endpoint which provides the latest news data in the following JSON format. 1        ```json [
  {
  "title": "Show HN: I'm starting a Svelte JavaScript newsletter",
  "timeAgo": "a few seconds ago",
  "author": "d3sandoval",
  "url": "https://svelte.substack.com/"
  },
  ...
] ``` - If the page parameter is not defined, the first thirty elements are received. - If the page parameter is set, the proper page of data is received. (`GET /api/newest?page=5` returns with the news from the fifth page.)
    - When clicking the `Newest` button in the menu, the page refreshes the content of the cards with the first thirty latest news articles.
    - The page has an HTML `div` element that contains the data in cards.
    - Every card shows the following information on a news article.
- `Title`, which is also a link to the original article.
- `Author`, the uploader, if available.
- `TimeAgo`, which is the publication date.
    - There is a next button above the cards. Clicking this button displays the next thirty news articles, if available.
    - There is a previous button above the cards. Clicking this button displays the previous thirty news articles, if available.

4. When I select `Jobs` from the menu the page content changes to job-related news.
    - There is an `/api/jobs?page=1` API endpoint, which provides the following job news data in JSON format. ```json [
  {
      "title": "Flexport is hiring engineers in Amsterdam",
      "timeAgo": "a day ago",
      "author": "",
      "url": "https://Flexport.com"
  },
  ...
] ``` - If the page parameter is not defined, the first thirty elements are received. - If the page parameter is set, the proper page of data is received. (`GET /api/jobs?page=5` returns the news from the fifth page.)
    - The page has an HTML `div` element that contains the data in cards.
    - Every card shows the following information on a job news article.
- `Title`, which is also a link to the original article.
- `TimeAgo`, which is the publication date.
    - There is a next button above the cards. Clicking this button displays the next thirty job news, if available.
    - There is a previous button above the table. Clicking this button displays the previous thirty job news, if available.

## General requirements

- For the whole project, get the data using [Hacker news API](https://api.hnpwa.com/v0) on the backend side.
- The page does not show a server error anytime during the review.
- All code is pushed to the GitHub repository in atomic commits. The implemented feature-related commits are managed on separate feature branches and merged in a pull request to the `master` branch.

## Hints

- Install the [JSON viewer Pro](https://chrome.google.com/webstore/detail/json-viewer-pro/eifflpmocdbdmepbjaopkkhbfmdgijcc) extension for Chrome to help you examine JSON data.
- Make sure to have [Postman](https://www.postman.com/) installed when working with APIs.
- If the domain is missing from the JSON response, the article is from the hacker news itself, like [this one](https://news.ycombinator.com/item?id=23574723).
- To , Use [context initialization parameters](https://www.baeldung.com/context-servlet-initialization-param#initializing-context-parameters) to define immutable data that is globally shared and accessed across a web application.
- [Define the TypeToken](https://stackoverflow.com/a/5554296) when serializing a list of objects.


## Background materials

- <i class="far fa-exclamation"></i> [Introducing servlets](project/curriculum/materials/pages/java/introducing-servlets.md)
- <i class="far fa-exclamation"></i> [Servlets tutorial](https://www.tutorialspoint.com/servlets/servlets-form-data.htm)
- <i class="far fa-exclamation"></i> [Serialization in Java](project/curriculum/materials/pages/java/serialization-in-java.md)
- <i class="far fa-exclamation"></i> [Simple HTTP request in Java](https://www.baeldung.com/java-http-request)
- <i class="far fa-exclamation"></i> [Returning a JSON response from a servlet](https://www.baeldung.com/servlet-json-response)
- <i class="far fa-exclamation"></i> [Custom Gson serialization](https://futurestud.io/tutorials/gson-advanced-custom-serialization-part-1)
- <i class="far fa-book-open"></i> [Layered architecture](https://medium.com/@priyalwalpita/software-architecture-patterns-layered-architecture-a3b89b71a057)
- <i class="far fa-book-open"></i> [Retrieving data from the backend](project/curriculum/materials/pages/web/the-last-missing-piece-api.md)
- <i class="far fa-book-open"></i> [Do you remember of REST?](project/curriculum/materials/pages/web/restful.md)

