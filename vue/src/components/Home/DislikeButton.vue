<template>
    <button id="dislike-button" class="btn-danger" v-on:click="dislikeMovie">Dislike</button>
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
#dislike-button {
  background-color: #f44336;
  border: none;
  color: white;
  padding: 16px;
  text-align: center;
  font-size: 24px;
  border-radius: 8px;
  width: 165px;
  transition-duration: 0.4s;
}

#dislike-button:hover {
  background-color: #b61b10;
  color: white;
}

</style>