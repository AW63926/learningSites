const xhr = new XMLHttpRequest();
 
xhr.onreadystatechange = function() {
 
    if (this.readyState == 4 && this.status == 200) {
        const res = JSON.parse(xhr.response)
        const container = document.querySelector('.container')

        console.log({res})

        res.forEach(function(website) {
        const websiteItem = document.createElement('div')

        const name = document.createElement('h2')
        name.innerText = website.name;

        const description = document.createElement('p')
        description.innerText = website.description

        const reviewerUrls = [];
        website.reviewersUrls.forEach(reviewerUrl =>  {
        	const reviewerUrlElement = document.createElement('li')
        	reviewerUrlElement.innerHTML = `website reviewers: <a href=${reviewerUrl}">${reviewerUrl}</a>`
        	reviewerUrls.push(reviewerUrlElement)
        })

        container.appendChild(websiteItem)
        websiteItem.appendChild(name)
        websiteItem.appendChild(description)

        reviewerUrls.forEach(reviewerUrl => websiteItem.appendChild(reviewerUrl))
  });
  }
}
xhr.open('GET', 'http://localhost:8080/show-websites', true)
xhr.send()