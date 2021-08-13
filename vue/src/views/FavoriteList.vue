<template>
  <div class="favorite-list">
    <h1 class="styles">Favorites: </h1>
    <favorite-list/>
       <div class="favorite-list-well">
        <label for="favorite-list" class="sr-only">Favorites: </label>
        <!-- <input
          type="text"
          id="watchlist"
          class="form-control"
          placeholder="Watchlist"
          v-model="user.watchlist"
          required
          autofocus
        /> -->
       </div>



  </div>
</template>

<script>

import FavoriteList from '@/components/Home/FavoriteList.vue'

export default {
  components: {
    FavoriteList
  }
}
</script>

<style>
@import '../resources/styles.css';
</style>