<template>
  <div class="watchlist">
      <watch-list-button/>
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

         <router-link :to="{ name: 'watchlist' }" >View Watchlist</router-link>



  </div>
</template>

<script>
export default {

}
</script>

<style>

</style>