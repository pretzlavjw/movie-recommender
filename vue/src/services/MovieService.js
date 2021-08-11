import axios from 'axios';

// const http = axios.create({
//     baseURL: "http://localhost:8080"
//   });

export default {
    get(id) {
        return axios.get(`/movie/get-movie/${id}`)
    },
    create(newFavorite) {
        return axios.post(`/movie/update-status/${newFavorite.id}/${newFavorite.movieId}/${newFavorite.userPreference}/`)
    }
}