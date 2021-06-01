import {CINEMATOGRAF_CLIENTS_BASE_URL} from "./consts";
import {status, json} from "./rest-utils";


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