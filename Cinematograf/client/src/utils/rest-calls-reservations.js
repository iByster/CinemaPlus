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

export function DeleteReservationsByMovId(id){

    console.log(id);
    const headers = {
        'Accept': 'application/json'
    }

    const myInit = { method: 'DELETE',
        headers: headers,
        mode: 'cors'};
    const request = new Request(CINEMATOGRAF_RESERVATIONS_BASE_URL + '/' + id, myInit);

    console.log('Inainte de fetch pentru '+CINEMATOGRAF_RESERVATIONS_BASE_URL+ '/' + id);

    return fetch(request)
        .then(status)
        .then(data=> {
            console.log('Request succeeded with JSON response', data);
            return data;
        }).catch(error=>{
            console.log('Request failed', error);
            return error;
        });

}


export function GetReservationsByClient(clientId){
    console.log(clientId)
    const headers = {
        'Accept': 'application/json'
    }

    const myInit = { method: 'GET',
        headers: headers,
        mode: 'cors'};
    const request = new Request(CINEMATOGRAF_RESERVATIONS_BASE_URL + '/' + clientId, myInit);

    console.log('Inainte de fetch pentru '+CINEMATOGRAF_RESERVATIONS_BASE_URL)

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