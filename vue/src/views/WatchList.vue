<template>
  <div class="watchlist">
    <h1 class="styles">Watchlist: </h1>
    <watch-list/>
       <div class="watchlist-well">
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

import WatchList from '@/components/Home/WatchList.vue'

export default {
  components: {
    WatchList
  }
}
</script>

<style>
@import '../resources/styles.css';
label {
  font-size: 24px;
}
</style>