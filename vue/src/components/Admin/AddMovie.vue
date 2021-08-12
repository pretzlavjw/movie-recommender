<template>
    <div>       
    <h1 class="styles">poop</h1>
        <label for="imdbId" class="sr-only">IMDB ID: </label>
        <input
          type="text"
          id="imdbId"
          class="form-control"
          placeholder="IMDB ID"
          v-model="input.imdbId"
          required
          autofocus
        />
    </div> 
        

</template>

<script>
import MovieService from "../../services/MovieService.js"
export default {
    
    name: 'add-movie',

    methods: {
        // addMovies() {
        //     MovieService.create(this.$store.state.movie.imdbId).then(response => {
        //         this.$store.push("ADD_MOVIE", )
        // //     })

        // }

        addMovies() {
            const addNewMovie = {
                id: this.$store.state.user.id,
                imdbId: this.$store.state.movie.imdbId,
                userPreference: "disliked"
            }
            MovieService.create(addNewMovie)
            
        }
    }
}
</script>

<style>
@import '../../resources/styles.css'

</style>