import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:8080"
  });

export default {
    get(id) {
        return http.get(`/movie/get-movie/${id}`)
    }
}