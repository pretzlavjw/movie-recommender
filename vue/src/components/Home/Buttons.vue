<template>
  <div>
      <dislike-button></dislike-button>
    <like-button></like-button>
  </div>
</template>

<script>
import DislikeButton from "@/components/Home/DislikeButton.vue";
import LikeButton from "@/components/Home/LikeButton.vue";
export default {
  components: {
    DislikeButton,
    LikeButton
  },
  name: "Buttons"
};
</script>

<style>
</style>