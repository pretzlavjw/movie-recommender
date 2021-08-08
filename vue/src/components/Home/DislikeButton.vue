<template>
  <div class="dislike-button">
    <button class="btn btn-danger" v-on:click="dislikeMovie">Dislike</button>
  </div>
</template>

<script>
export default {
  name: "DislikeButton",
  methods: {
    dislikeMovie() {
      this.$emit("Reject");
    }
  }
};
</script>

<style>
</style>