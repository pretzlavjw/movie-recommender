<template>
  <div class="like-container">
    <button id="like" class="btn btn-primary" v-on:click="LikeMovie">Like</button>
  </div>
</template>

<script>
export default {
  name: "LikeButton",
  methods: {
    LikeMovie() {
      this.$emit("Like");
    }
  }
};
</script>

<style>
div.like-container {
  display: inline-block;
}
</style>