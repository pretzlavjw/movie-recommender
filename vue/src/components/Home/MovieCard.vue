<template>

  <div class="movie-card">
      <h3 class="movie-title">Movie Title</h3>
      <img src="https://m.media-amazon.com/images/M/MV5BN2EyZjM3NzUtNWUzMi00MTgxLWI0NTctMzY4M2VlOTdjZWRiXkEyXkFqcGdeQXVyNDUzOTQ5MjY@._V1_SX300.jpg">
      <h4 class="movie-plot">A meek Hobbit from the Shire and eight companions set out on a journey to destroy the powerful One Ring and save Middle-earth from the Dark Lord Sauron</h4>
      
      <div class="movie-info">
        <p>genre</p>
        <p>length</p>
        <p>rating</p>
      </div>
  </div>
</template>

<script>
import MovieService from "@/services/MovieService.js";

export default {
    name: 'movie-list',
    methods: {
        getMovies(userId) {
            MovieService.get(userId).then(response => {
                this.$store.commit("SET_MOVIES", response.data)
            })
        }
    }

}
</script>

<style>

</style>