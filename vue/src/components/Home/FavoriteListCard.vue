<template>

  <div class="movie-card">
      <div>
        <h2 class="movie-title">{{ movie.Title }}</h2>
        <div class="movie-display" id="movie-display">
            <img v-bind:src="movie.Poster" alt="">
            <div class="movie-info">
                <h4> {{ movie.Plot }} </h4>
                <table>
                    <tr>
                        <th>Year</th>
                        <th>Length</th>
                        <th>Rated</th>
                    </tr>
                    <tr>
                        <td>{{ movie.Year }}</td>
                        <td>{{ movie.Runtime }}</td>
                        <td>{{ movie.Rated }}</td>
                    </tr>
                </table>
            </div>
            

        </div>
        
      </div>
     
       
      <!-- <h4 class="movie-plot">A meek Hobbit from the Shire and eight companions set out on a journey to destroy the powerful One Ring and save Middle-earth from the Dark Lord Sauron</h4>
      
      <div class="movie-info">
        <p>genre</p>
        <p>length</p>
        <p>rating</p>
      </div> -->
  </div>
</template>

<script>

export default {
    name: 'favorite-list-card',
    methods: {
    },
    props: {
        movie: Object
    },
    created() {
    },
    computed: {
        movies() {
            return this.$store.state.movies
        }
    }
        
    

}
</script>

<style>

.movie-card {
    /* display: flex;
    justify-content: center;
    background: white;
    flex-direction: column;
    flex-wrap: wrap;
    padding: 10px, 20px, 10px, 20px;
    border-radius: 15px 50px;
    opacity: 80%;
    width: 500px;
    text-align: center; */
    display: flex;
    justify-content: center;
    background: white;
    flex-direction: column;
    flex-wrap: wrap;
    padding: 10px, 20px, 10px, 20px;
    border-radius: 15px 50px;
    opacity: 80%;
    width: 45em;
    text-align: center;
    
}

#movie-display {
    display: flex;
    margin: 20px;
    align-items: center;
}

h4 {
    margin: 10%;
}

.movie-info {
    display: flex;
    flex-direction: column;
    align-content: space-around;
}

table {
    margin: 10%;

}

/* img {
    max-height: 600px;
} */
</style>