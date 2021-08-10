<template>

  <div class="movie-card">
      <div>
           <h3 class="movie-title">{{ movie.Title }}</h3>
           
               <img v-bind:src="movie.Poster" alt="">
                <p> {{ movie.Poster}} </p>
     
           


           <h5> {{ movie.Plot }} </h5>
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

</style>