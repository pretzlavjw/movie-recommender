import axios from 'axios';

export default {
    updatePreference(id, genre) {
        return axios.post(`/users/update/${id}/${genre}`)
    },
    getFavorites(id) {
        return axios.get(`/users/favorites/${id}`)
    }
}