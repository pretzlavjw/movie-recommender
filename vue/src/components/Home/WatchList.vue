<template>
  <div class="watchlist">
       <div> <!-- Need a v-for loop to cycle through the array of movies, assign them to a movie card -->
          <movie-card></movie-card>
      </div>
  </div>
</template>

<script>
import MovieService from "@/services/MovieService.js";
import MovieCard from './MovieCard.vue';

export default {
  components: { MovieCard },
    name: 'watch-list',
    props: {
        'userId': Number,
        'userPreference': String
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