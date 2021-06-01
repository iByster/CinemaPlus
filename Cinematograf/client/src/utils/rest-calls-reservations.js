import {status, json} from "./rest-utils";
import {CINEMATOGRAF_RESERVATIONS_BASE_URL} from "./consts";

export function SaveReservation(reservation){
    console.log('inainte de fetch post'+JSON.stringify(reservation));

    const myHeaders = new Headers();
    myHeaders.append("Accept", "application/json");
    myHeaders.append("Content-Type","application/json");

    const antet = { method: 'POST',
        headers: myHeaders,
        mode: 'cors',
        body:JSON.stringify(reservation)};

    return fetch(CINEMATOGRAF_RESERVATIONS_BASE_URL,antet)
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