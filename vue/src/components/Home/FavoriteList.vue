<template>
  <div>
      <!-- not sure about this -->
          <div v-for="movie in $store.state.movies" v-bind:key="movie">
              <favorite-list-card v-bind:movie="movie"/>
            </div>
  </div>
</template>

<script>
import MovieService from "@/services/MovieService.js";
import FavoriteListCard from "@/components/Home/FavoriteListCard.vue"

export default {
  components: { FavoriteListCard },
    name: 'favorite-list',
    methods: {
        getFavorites() {
            
            console.log(this.$store.state.user.id)
            MovieService.getFavorites(this.$store.state.user.id).then(response => {
                this.$store.commit("GET_FAVORITES", response.data)
            })
            console.log(this.$store.state.movies)
        }
    },
    data() {
        return {movies: []}
    },
    created() {
        this.getFavorites()
    },
    computed: {
        movie() {
            return this.$store.state.movies;
        }
    }

}
    
</script>

<style>

</style>