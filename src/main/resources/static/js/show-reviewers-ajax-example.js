const xhr = new XMLHttpRequest();
 
xhr.onreadystatechange = function() {
 
    if (this.readyState == 4 && this.status == 200) {
        const res = JSON.parse(xhr.response)
        const container = document.querySelector('.container')

        console.log({res})

        res.forEach(function(reviewer) {
        const reviewerItem = document.createElement('div')

        const name = document.createElement('h2')
        name.innerText = reviewer.name;

        const description = document.createElement('p')
        description.innerText = reviewer.description

        const websiteUrls = [];
        reviewer.websitesUrls.forEach(websiteUrl =>  {
        	const websiteUrlElement = document.createElement('li')
        	websiteUrlElement.innerHTML = `reviewer websites: <a href=${websiteUrl}">${websiteUrl}</a>`
        	websiteUrls.push(websiteUrlElement)
        })

        container.appendChild(reviewerItem)
        reviewerItem.appendChild(name)
        reviewerItem.appendChild(description)

        websiteUrls.forEach(websiteUrl => reviewerItem.appendChild(websiteUrl))
  });
  }
}
xhr.open('GET', 'http://localhost:8080/show-reviewers', true)
xhr.send()