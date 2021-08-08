<template>
  <div class="home">
    <movie-list></movie-list>
    <h1>Home</h1>
    <p>Movie title goes here?</p>
  </div>
</template>

<script>

import MovieList from "@/components/MovieList.vue";
export default {
  name: "home",
  components: {
    MovieList
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