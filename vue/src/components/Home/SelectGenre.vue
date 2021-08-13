<template>
<div>       
    <h1 class="styles">Update Genre Preferences</h1>
    <form>
        <label for="genrePreferences" class="styles">Genre Preference: </label>
        <input
          type="text"
          id="Genre"
          class="form-control"
          placeholder="Genre"
          v-model="genre"
          required
          autofocus
        />
        <button v-on:click="updateGenre">Toggle Genre</button>
    </form>
    </div> 
  <!-- <div>
      <form>
          <input type="checkbox" id="action" name="action" value="Action" v-on:click="updateGenre('Action')">
          <label for="action">Action</label>
          <input type="checkbox" id="horror" name="horror" value="Horror" v-on:click="updateGenre('Horror')">
          <label for="horror">Horror</label>
          <input type="checkbox" id="comedy" name="comedy" value="Comedy" v-on:click="updateGenre('Comedy')">
          <label for="comedy">Comedy</label>
          <input type="checkbox" id="mystery" name="mystery" value="Mystery" v-on:click="updateGenre('Mystery')">
          <label for="mystery">Mystery</label>
          <input type="checkbox" id="drama" name="drama" value="Drama" v-on:click="updateGenre('Drama')">
          <label for="drama">Drama</label>
          <input type="checkbox" id="romance" name="romance" value="Romance" v-on:click="updateGenre('Romance')">
          <label for="romance">Romance</label>
          <input type="checkbox" id="fantasy" name="fantasy" value="Fantasy" v-on:click="updateGenre('Fantasy')">
          <label for="fantasy">Fantasy</label>
          <input type="checkbox" id="thriller" name="thriller" value="Thriller" v-on:click="updateGenre('Thriller')">
          <label for="thriller">Thriller</label>
          <input type="checkbox" id="western" name="western" value="Western" v-on:click="updateGenre('Western')">
          <label for="western">Western</label>
          <input type="checkbox" id="sci-fi" name="sci-fi" value="Sci-Fi" v-on:click="updateGenre('Sci-Fi')">
          <label for="sci-fi">Sci-Fi</label>
      </form>
  </div> -->
</template>

<script>
import UserService from "@/services/UserService.js";

export default {
name: 'select-genre',
data() {
    return {
        genre: ''
    }
},
methods: {
    updateGenre() {
        UserService.updatePreference(this.$store.state.user.id, this.genre)
    }
}

}
</script>

<style>
form {
    display: flex;
    flex-direction: column;
    color: rgb(238, 14, 238);
    align-content: center;
}

</style>