let output = '';
const movieEntry = document.querySelector('.movie-list');
const addMovieForm = document.querySelector ('.addMovieForm'); 
const movieNameValue =document.getElementById ('movieName');
const movieDirectorValue =document.getElementById ('movieDirector');
const movieRatingValue =document.getElementById ('movieRating');
const movieLengthValue =document.getElementById ('movieLength');
const yearOfReleaseValue =document.getElementById ('yearOfRelease'); 

const createPosts = (posts) =>  {
    posts.forEach(post => {
        output += ` <div class="card mt-4 col-md-6 bg-ligt">
<div class="card-body">
  <h3 class="card-title">${post.movieName}</h3>
  <h4 class="card-subtitle mb-2 text-muted">${post.movieDirector}</h4>
  <h6 class="card-subtitle mb-2 text-muted">${post.movieRating}</h6>
  <h6 class="card-subtitle mb-2 text-muted">${post.movieLength}</h6>
  <p class="card-subtitle mb-2 text-muted">${post.yearOfRelease}</p>

  <a href="#" class="card-link">Edit</a>
  <a href="#" class="card-link">Delete</a>
</div>
</div>
`;
});
movieEntry.innerHTML = output ;

}

const url = 'http://localhost:8080/movie/readall';

//Get - Read Movie
//Method - GET
//13.54

fetch(url)
    .then(res => res.json())
    .then(data =>  createPosts (data))

let url2= "http://Localhost:8080/movie/create" ;
//Create -Insert Movie
//Method - POST

addMovieForm.addEventListener("submit", (e) => {
    e.preventDefault();

   
   
    fetch(url2, {
        method: "POST",
        headers: {
            "content-type" : 'application/json'
        },
        body: JSON.stringify({
          movieName: movieNameValue.value,
          movieDirector: movieDirectorValue.value,
          movieRating : movieRatingValue.value,
          movieLength : movieLengthValue.value, 
          yearOfRelease : yearOfReleaseValue.value,



     })
    });
})