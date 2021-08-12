<template>
<<<<<<< HEAD
  <div class="watchlist">
       <div> <!-- Need a v-for loop to cycle through the array of movies, assign them to a movie card -->
          <movie-card></movie-card>
      </div>
=======
  <div>
      <!-- not sure about this -->
      <router-link v-bind:to="{ name: 'movie' }" v-for="movie in $store.state.movies" v-bind:key="movie.movieId">
          <movie-card v-bind:movie="movie" />
      </router-link>
>>>>>>> d0df5e5342df156ccaf78fa26bafcd7ccc80f14a
  </div>
</template>

<script>
import MovieService from "@/services/MovieService.js";
import MovieCard from './MovieCard.vue';

export default {
  components: { MovieCard },
<<<<<<< HEAD
    name: 'watch-list',
    props: {
        'userId': Number,
        'userPreference': String
=======
    name: 'watchlist',
    methods: {
        getWatchlist() {
            console.log(this.$store.state.user.id)
            MovieService.getWatchlist(this.$store.state.user.id).then(response => {
                this.$store.commit("GET_WATCHLIST", response.data)
            })
        }
>>>>>>> d0df5e5342df156ccaf78fa26bafcd7ccc80f14a
    },
    data() {
        return {
            movies: []
        }
    }

}
</script>

<style>

</style>