<template>
  <div id="app">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Tourney:wght@900&display=swap" rel="stylesheet">
    <div id="nav">
      <div class="home-logout">
        <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
        <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
      </div>
      <h1 class="title">TechFlix</h1>
    </div>
    <router-view />
  </div>
</template>

<style>
  #nav {
    display: flex;
    align-items: baseline;
  }

  .title {
    justify-content: flex-center;
  }


</style>
