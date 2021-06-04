import {CINEMATOGRAF_ADMINS_BASE_URL} from "./consts";
import {json, status} from "./rest-utils";

export function GetAdminLogged(id, password){
    const myHeaders = new Headers();
    myHeaders.append("Accept", "application/json");

    const antet = { method: 'GET',
        headers: myHeaders,
        mode: 'cors'};

    const taskDelUrl=CINEMATOGRAF_ADMINS_BASE_URL+'?username=' + id + "&password=" + password;

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