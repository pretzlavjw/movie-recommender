<template>
    <div>       
    <h1 class="styles">Add A New Movie</h1>
        <label for="imdbId" class="sr-only">IMDB ID: </label>
        <input
          type="text"
          id="imdbId"
          class="form-control"
          placeholder="IMDB ID"
          v-model="imdbID"
          required
          autofocus
        />
        <button v-on:click.prevent="addMovie">ADD MOVIE</button>
    </div> 
        

</template>

<script>
import movieService from "../../services/MovieService.js"
export default {
    
    name: 'add-movie',
    data() {
        return {
            imdbID: ''
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
@import '../../resources/styles.css'

</style>