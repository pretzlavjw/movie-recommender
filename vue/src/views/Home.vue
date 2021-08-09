<template>
  <div class="home">
    <movie-card />
    <h1>Home</h1>
    <p>Movie title goes here?</p>
  </div>
</template>

<script>
import MovieCard from "@/components/Home/MovieCard.vue";
import Buttons from "@/components/Home/Buttons.vue";

export default {
  name: "home",
  components: {
    MovieCard
  }
};
</script>

<style>

.home {
  color: rgb(238, 14, 238);;
}

h1 {
  display: flex;
  justify-content: center;
}

p {
  display: flex;
  justify-content: center;
}
</style>