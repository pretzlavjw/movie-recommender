<template>
  <div>
      <movie-card></movie-card>
      <watch-list/>
  </div>
</template>

<script>
import MovieService from "@/services/MovieService.js";
import MovieCard from './MovieCard.vue';


export default {
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