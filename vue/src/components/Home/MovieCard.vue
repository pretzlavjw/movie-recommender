<template>

  <div class="movie-card">
      <movie-list></movie-list>
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
import MovieList from "@/components/MovieList.vue"

export default {
  components: { MovieList },
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