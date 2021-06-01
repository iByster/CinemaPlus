import {CINEMATOGRAF_MOVIES_BASE_URL} from "./consts";
import {status, json} from "./rest-utils";


export function GetMovies(){
    const headers = {
        'Accept': 'application/json'
    }

    const myInit = { method: 'GET',
        headers: headers,
        mode: 'cors'};
    const request = new Request(CINEMATOGRAF_MOVIES_BASE_URL, myInit);

    console.log('Inainte de fetch pentru '+CINEMATOGRAF_MOVIES_BASE_URL)

    return fetch(request)
        .then(status)
        .then(json)
        .then(data=> {
            console.log('Request succeeded with JSON response', data);
            return data;
        }).catch(error=>{
            console.log('Request failed', error);
            return error;
        });

}