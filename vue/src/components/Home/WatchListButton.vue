<template>
    <button id="watch-list" class="btn btn-watch-list" v-on:click="addToWatchlist(); getMovies();">Add To Watch List</button>
</template>

<script>
import MovieService from "@/services/MovieService.js"

export default {
  name: "WatchlistButton",
  methods: {
        addToWatchlist() {
            const setUserPreference = {
                id: this.$store.state.user.id,
                movieId: this.$store.state.movie.movieId,
                userPreference: "watchlist"
            }
            MovieService.create(setUserPreference)
            
        },
        getMovies() {
            console.log(this.$store.state.user.id)
            MovieService.get(this.$store.state.user.id).then(response => {
                this.$store.commit("SET_MOVIE", response.data)
            })
        }
    },
    data() {
        return {movies: []}

        
    },
    created() {
        this.getMovies()
    },
    computed: {
        movie() {
            return this.$store.state.movie
        }
  }
 };
</script>

<style>
#watch-list {
  background-color: whitesmoke;
  border: none;
  color: black;
  padding: 16px;
  text-align: center;
  font-size: 24px;
  border-radius: 8px;
  width: 165px;
  transition-duration: 0.4s;
}

#watch-list:hover {
  background-color:rgb(148, 148, 148);
  color: white;
}
</style>