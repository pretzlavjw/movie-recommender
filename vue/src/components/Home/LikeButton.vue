<template>
    <button id="like" class="btn btn-primary" v-on:click="addFavorite(); getMovies();" >Like</button>
</template>

<script>
import MovieService from "@/services/MovieService.js"

export default {
  name: 'LikeButton',
    methods: {
        addFavorite() {
            const setUserPreference = {
                id: this.$store.state.user.id,
                movieId: this.$store.state.movie.movieId,
                userPreference: "favorited"
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
#like {
  background-color: #7f34b1;
  border: none;
  color: white;
  padding: 16px;
  text-align: center;
  font-size: 24px;
  border-radius: 8px;
  width: 165px;
  transition-duration: 0.4s;
}

#like:hover {
  background-color: #49136d;
  color: white;
}
</style>