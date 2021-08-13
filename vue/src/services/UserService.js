import axios from 'axios';

export default {
    updatePreference(id, genre) {
        return axios.post(`/users/update/${id}/${genre}`)
    }
}