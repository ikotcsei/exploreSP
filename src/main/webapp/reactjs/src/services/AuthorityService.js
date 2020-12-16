import axios from 'axios';

const AUTH_API_BASE_URL = 'https://localhost:8443/authapi';

class AuthorityService{
    getAuthorities(){
        return axios.get(AUTH_API_BASE_URL);
    }
}

export default new AuthorityService()