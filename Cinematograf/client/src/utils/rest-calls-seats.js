import {CINEMATOGRAF_SEATS_BASE_URL} from "./consts";

function status(response) {
    console.log('response status '+response.status);
    if (response.status >= 200 && response.status < 300) {
        return Promise.resolve(response)
    } else {
        return Promise.reject(new Error(response.statusText))
    }
}

function json(response) {
    return response.json()
}



export function GetSeats(movieID){
    const headers = {
        'Accept': 'application/json'
    }

    const myInit = { method: 'GET',
        headers: headers,
        mode: 'cors'};
    const request = new Request(CINEMATOGRAF_SEATS_BASE_URL + '/' + movieID, myInit);

    console.log('Inainte de fetch pentru '+CINEMATOGRAF_SEATS_BASE_URL)

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