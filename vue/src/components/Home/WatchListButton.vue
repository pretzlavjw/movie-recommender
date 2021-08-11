<template>
    <button id="watch-list" class="btn btn-watch-list">Watch List</button>
</template>

<script>
// import MovieService from "@/services/MovieService.js"

// export default {
//   // name: "LikeButton",
//   // methods: {
//   //   LikeMovie() {
//   //     //this.$router.push('/login');
//   //     //window.location.reload()
//   //   },
    
//   // },
//   name: 'movie-card',
//     methods: {
//         getMovies() {
//             console.log(this.$store.state.user.id)
//             MovieService.get(this.$store.state.user.id).then(response => {
//                 this.$store.commit("SET_MOVIE", response.data)
//             })
//         }
//     },
//     data() {
//         return {movies: []}

        
//     },
//     created() {
//         this.getMovies()
//     },
//     computed: {
//         movie() {
//             return this.$store.state.movie
//         }
//     }
// };
</script>

<style>
#watch-list {
  background-color: #00ADEE;
  border: none;
  color: rgb(255, 255, 255);
  padding: 16px;
  text-align: center;
  font-size: 24px;
  border-radius: 8px;
  width: 165px;
  transition-duration: 0.4s;
}

#watch-list:hover {
  background-color: #0390c4;
  color: white;
}
</style>