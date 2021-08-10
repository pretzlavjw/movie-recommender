<template>
  <div class="like-container">
    <button id="like" class="btn btn-primary" v-on:click="getMovies">Like</button>
  </div>
</template>

<script>
import MovieService from "@/services/MovieService.js"

export default {
  // name: "LikeButton",
  // methods: {
  //   LikeMovie() {
  //     //this.$router.push('/login');
  //     //window.location.reload()
  //   },
    
  // },
  name: 'movie-card',
    methods: {
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
div.like-container {
  display: inline-block;
}
</style>