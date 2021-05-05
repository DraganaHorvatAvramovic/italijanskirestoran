import axios from 'axios';

var ItalijanskiRestoranAxios = axios.create({
    baseURL: 'http://localhost:8080/api',
});

export default ItalijanskiRestoranAxios;