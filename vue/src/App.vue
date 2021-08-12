<template>
  <div id="app">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Tourney:wght@900&display=swap" rel="stylesheet">
    <div id="nav">
      <h1 class="title">TechFlix</h1>
      <div class="home-logout">
        <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
        <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>&nbsp;|&nbsp;
        <router-link :to="{ name: 'watchlist' } ">Watchlist</router-link>&nbsp;|&nbsp;
        <router-link :to="{ name: 'admin' } ">Add A Movie</router-link>&nbsp;|&nbsp;
        <router-link :to="{ name: 'favorite-list' } ">Favorites</router-link>
      </div>
      
    </div>
    <router-view />
  </div>
</template>

<style>
  #nav {
    display: flex;
    flex-direction: column;
    align-items: center;
    border-radius: 15px 50px;
    opacity: 80%;
  }

  .title {
    justify-content: flex-center;
    border-bottom: 4px double rgb(238, 14, 238);
  }


</style>
