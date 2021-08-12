<template>
  <div>
      <!-- not sure about this -->
      <router-link v-bind:to="{ name: 'movie' }" v-for="movie in $store.state.movies" v-bind:key="movie.movieId">
          <movie-card v-bind:movie="movie" />
      </router-link>
  </div>
</template>

<script>
import MovieService from "@/services/MovieService.js";
import MovieCard from './MovieCard.vue';


export default {
  components: { MovieCard },
    name: 'watchlist',
    methods: {
        getWatchlist() {
            console.log(this.$store.state.user.id)
            MovieService.getWatchlist(this.$store.state.user.id).then(response => {
                this.$store.commit("GET_WATCHLIST", response.data)
            })
        }
    },
    data() {
        return {movies: []}

        
    },
    created() {
        this.getWatchlist()
    },
    computed: {
        movie() {
            return this.$store.state.movie
        }
    }
        




//   components: { MovieCard },
//     name: 'watch-list',
//     props: {
//         'userPreference': String
//     },
//     data() {
//         return {
//             movie: {
                
//             }
//         }
//     }

}
</script>

<style>

</style>