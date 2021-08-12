<template>
  <div>
      <!-- not sure about this -->
          <div v-for="movie in $store.state.movies" v-bind:key="movie">
              <watchlist-card v-bind:movie="movie"/>
            </div>
  </div>
</template>

<script>
import MovieService from "@/services/MovieService.js";
import WatchlistCard from "@/components/Home/WatchlistCard.vue"


export default {
  components: { WatchlistCard },
    name: 'watchlist',
    methods: {
        getWatchlist() {
            
            console.log(this.$store.state.user.id)
            MovieService.getWatchlist(this.$store.state.user.id).then(response => {
                this.$store.commit("GET_WATCHLIST", response.data)
            })
            console.log(this.$store.state.movies)
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