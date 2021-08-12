<template>
  <div class="watchlist">
    <watch-list/>
       <div class="watchlist-well">
        <label for="watchlist" class="sr-only">Watchlist: </label>
        <input
          type="text"
          id="watchlist"
          class="form-control"
          placeholder="Watchlist"
          v-model="user.watchlist"
          required
          autofocus
        />
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

</style>