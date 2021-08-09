<template>

  <div class="movie-card">
      <h3 class="movie-title">Movie Title</h3>
      <img v-bind:src="url">
      <h4 class="movie-plot">Description</h4>
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