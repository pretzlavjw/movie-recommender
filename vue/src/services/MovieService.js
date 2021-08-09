import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:8081"
  });

export default {
    get(userId) {
        return http.get(`/movie/get-movie/${userId}`)
    }
}