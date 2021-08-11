<template>
    <button id="dislike-button" class="btn-danger" v-on:click="dislikeMovie(); getMovies();">Dislike</button>
</template>

<script>
import MovieService from "@/services/MovieService.js"

export default {
  name: "DislikeButton",
  methods: {
        dislikeMovie() {
            const setUserPreference = {
                id: this.$store.state.user.id,
                movieId: this.$store.state.movie.movieId,
                userPreference: "disliked"
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
#dislike-button {
  background-color:   rgb(75, 13, 13);
  border: none;
  color: white;
  padding: 16px;
  text-align: center;
  font-size: 24px;
  border-radius: 8px;
  width: 165px;
  transition-duration: 0.4s;
}

#dislike-button:hover {
  background-color: rgb(112, 26, 26);
  color: white;
}

</style>