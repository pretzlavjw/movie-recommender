import axios from 'axios';

// const http = axios.create({
//     baseURL: "http://localhost:8080"
//   });

export default {
    get(id) {
        return axios.get(`/movie/get-movie/${id}`)
    },
    create(id, movieId, userPreference) {
        return axios.post(`/movie/update-status/${id}/${movieId}/${userPreference}/`)
    }
}