import axios from "axios";

const request = axios.create(
    {
        //backend url
        baseURL: '/api',
        timeout: 5000
    }
)

//request interpreter
//modify request before send it
//such as add token on request header or encryption
request.interceptors.request.use(config =>{
    config.headers['Content-Type'] = 'application/json;charset=utf-8';

// config.headers['token'] = user.token; // set token in request header
    return config
}, error => {
    return Promise.reject(error)
});

//response interpreter
request.interceptors.response.use(
    response =>{
        let res = response.data;

        //if a file is returned
        if (response.config.responseType === 'blob'){
            return res
        }

        //if string returned
        //check if it's an empty string or not
        //if it's not an empty string and convertable to JSON string then we convert
        //it to JSON
        //if an empty string is returned then we don't convert it
        if (typeof res === 'string')
        {
            res = res ? JSON.parse(res) : res
        }

        return res;
    },
    error => {
        console.log('err' + error)
        return Promise.reject(error)
    }
)

export default request