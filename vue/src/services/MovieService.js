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
    },
    getWatchlist(id) {
        return axios.get(`/movie/watchlist/${id}`)
    },
    getFavorites(id) {
        return axios.get(`/movie/favorited/${id}`)
    },
    addMovie(imdbId) {
        return axios.post(`/movie/create/${imdbId}`, {
            headers: {
                'Authorization': `Bearer ${localStorage.getItem('token')}`
            }
        });
    }
    // addMoviebyTitle(title) {
    //     return axios.post(`/movie/createbytitle/${title}`)
    // }
}