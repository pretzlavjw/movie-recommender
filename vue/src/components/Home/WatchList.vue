<template>
  <div>
      <movie-card></movie-card>
  </div>
</template>

<script>
import MovieService from "@/services/MovieService.js";
import MovieCard from './MovieCard.vue';

export default {
  components: { MovieCard },
    name: 'watch-list',
    props: {
        'userPreference': String
    },
    data() {
        return {
            movie: {
                
            }
        }
    }

}
</script>

<style>

</style>