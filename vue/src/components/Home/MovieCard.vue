<template>

  <div class="movie-card">
      <div>
        <h2 class="movie-title">{{ movie.Title }}</h2>
        <div class="movie-display">
            <img v-bind:src="movie.Poster" alt="">
            <h4> {{ movie.Plot }} </h4>
        </div>
        
      </div>
     
       
      <!-- <h4 class="movie-plot">A meek Hobbit from the Shire and eight companions set out on a journey to destroy the powerful One Ring and save Middle-earth from the Dark Lord Sauron</h4>
      
      <div class="movie-info">
        <p>genre</p>
        <p>length</p>
        <p>rating</p>
      </div> -->
  </div>
</template>

<script>
import MovieService from "@/services/MovieService.js";

export default {
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
        
    

}
</script>

<style>

.movie-card {
    display: flex;
    justify-content: center;
    background: white;
    flex-direction: column;
    flex-wrap: wrap;
    padding: 10px, 20px, 10px, 20px;
    border-radius: 15px 50px;
    opacity: 80%;
    width: 500px;
    margin: 0 auto;
    text-align: center;
}

img {
    max-height: 300px;
}
</style>