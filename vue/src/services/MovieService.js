import axios from 'axios';

// const http = axios.create({
//     baseURL: "http://localhost:8080"
//   });

export default {
    get(id) {
        return axios.get(`/movie/get-movie/${id}`)
    },
    create(setUserPreference) {
        return axios.post(`/movie/update-status/${setUserPreference.id}/${setUserPreference.movieId}/${setUserPreference.userPreference}/`)
    }
}