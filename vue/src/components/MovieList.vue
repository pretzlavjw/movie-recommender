<template>
  <div class="container">
      <table id="movieTable">
         what
          </table>
    </div>
</template>

<script>


export default {
    name: "movie-list",
    data() {
     return {
         filter: {
             movieTitle: "",
             movieGenre: ""
         },
         movies: [ {
             movieTitle: "ALEX",
             movieGenre: "ACTION"
         }
             
         ]

     }
    }

}
</script>

<style>

</style>