import axios from 'axios';

// const http = axios.create({
//     baseURL: "http://localhost:8080"
//   });

export default {
    get(id) {
        return axios.get(`/movie/get-movie/${id}`)
    }
}