<template>
    <div>       
    <h1 class="styles">Add A New Movie</h1>
    <form>
        <label for="imdbId" class="styles">IMDB ID: </label>
        <input
          type="text"
          id="imdbId"
          class="form-control"
          placeholder="IMDB ID"
          v-model="imdbID"
          required
          autofocus
        />
        <button v-on:click="addMovie">ADD MOVIE</button>
    </form>
    <!-- <form>
        <label for="imdbId" class="styles">MOVIE TITLE: </label>
        <input
          type="text"
          id="title"
          class="form-control"
          placeholder="MOVIE TITLE"
          v-model="titleToAdd"
          required
          autofocus
        />
        <button v-on:click="addMovieByTitle">ADD MOVIE</button>
    </form> -->
    </div> 
</template>

<script>
import movieService from "../../services/MovieService.js"
export default {
    
    name: 'add-movie',
    data() {
        return {
            imdbID: '',
            titleToAdd: ''
        }
    },

    methods: {
        addMovie() {
            // use this.imdbID as the parameter for whatever service method you need to post to server
            movieService
                .addMovie(this.imdbID)
                .then(response => {
                    if (response.status === 200) {
                        console.log('It worked!!!!');
                    }
                }).catch(error => {
                    console.log(error.response);
                });
            
        }
        // addMoviebyTitle() {
        //         movieService
        //         .addMoviebyTitle(this.titleToAdd)
        //         .then(response => {
        //             if (response.status === 200) {
        //                 console.log('It worked!!!!');
        //             }
        //         }).catch(error => {
        //             console.log(error.response);
        //         }); 
        // }
        // addMovies() {
        //     MovieService.create(this.$store.state.movie.imdbId).then(response => {
        //         this.$store.push("ADD_MOVIE", )
        // //     })

        // }

        // addMovies() {
        //     const addNewMovie = {
        //         id: this.$store.state.user.id,
        //         imdbId: this.$store.state.movie.imdbId,
        //         userPreference: "disliked"
        //     }
        //     MovieService.create(addNewMovie)
            
        // }
    }
}
</script>

<style>
@import '../../resources/styles.css';

#imdbId {
    width: 250px;
    padding: 12px 20px;
    margin: 20px 0;
    box-sizing: border-box;
}

button {
  background-color: #7f34b1;
  border: none;
  color: white;
  padding: 16px;
  text-align: center;
  font-size: 18px;
  border-radius: 8px;
  width: 165px;
}

form {
    align-items: center;
    align-content: center;
    flex-wrap: wrap;
    justify-content: space-around;
    justify-self: center;
}


</style>