<template>
  <div>
    <dislike-button></dislike-button>
    <watch-list-button></watch-list-button>
    <like-button></like-button>
  </div>
</template>

<script>
import DislikeButton from "@/components/Home/DislikeButton.vue";
import WatchListButton from "@/components/Home/WatchListButton.vue";
import LikeButton from "@/components/Home/LikeButton.vue";
export default {
  components: {
    DislikeButton,
    WatchListButton,
    LikeButton
  },
  name: "Buttons"
};
</script>

<style>
div {
  display: inline;
  margin: 0 auto;
  
  }
</style>