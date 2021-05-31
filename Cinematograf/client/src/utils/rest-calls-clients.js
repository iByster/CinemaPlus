import {CINEMATOGRAF_CLIENTS_BASE_URL} from "./consts";

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


export function GetClientLogged(id, password){
    const myHeaders = new Headers();
    myHeaders.append("Accept", "application/json");

    const antet = { method: 'GET',
        headers: myHeaders,
        mode: 'cors'};

    const taskDelUrl=CINEMATOGRAF_CLIENTS_BASE_URL+'?username=' + id + "&password=" + password;

    return fetch(taskDelUrl,antet)
        .then(status)
        .then(status)
        .then(json)
        .then(data=> {
            console.log('Request succeeded with JSON response', data);
            return data;
        }).catch(e=>{
            console.log('error '+e);
            return Promise.reject(e);
        });
}