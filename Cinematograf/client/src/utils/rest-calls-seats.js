import {CINEMATOGRAF_SEATS_BASE_URL} from "./consts";
import {status, json} from "./rest-utils";


export function GetSeats(movieID){
    const headers = {
        'Accept': 'application/json'
    }

    const myInit = { method: 'GET',
        headers: headers,
        mode: 'cors'}
    const request = new Request(CINEMATOGRAF_SEATS_BASE_URL + '/movie/' + movieID, myInit);

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

export function DeleteSeatsByMovie(movieID){
    const headers = {
        'Accept': 'application/json'
    }

    const myInit = { method: 'DELETE',
        headers: headers,
        mode: 'cors'
    }
    const request = new Request(CINEMATOGRAF_SEATS_BASE_URL + '/movie/' + movieID, myInit);

    console.log('Inainte de fetch pentru cacat'+CINEMATOGRAF_SEATS_BASE_URL+ '/movie/' + movieID)

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


export function GetSeatsByReservation(reservationID){
    const headers = {
        'Accept': 'application/json'
    }

    const myInit = { method: 'GET',
        headers: headers,
        mode: 'cors'}
    const request = new Request(CINEMATOGRAF_SEATS_BASE_URL + '/reservation/' + reservationID, myInit);

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


export function UpdateSeat(seat){
    console.log('inainte de fetch post'+JSON.stringify(seat));

    const myHeaders = new Headers();
    myHeaders.append("Accept", "application/json");
    myHeaders.append("Content-Type","application/json");

    const antet = { method: 'PUT',
        headers: myHeaders,
        mode: 'cors',
        body:JSON.stringify(seat)};

    return fetch(CINEMATOGRAF_SEATS_BASE_URL+'/' + seat.id,antet)
        .then(status)
        .then(response=>{
            return response.text();
        }).catch(error=>{
            console.log('Request failed', error);
            return Promise.reject(error);
        });
}

export function SaveSeat(seat){
    console.log('inainte de fetch post'+JSON.stringify(seat));

    const myHeaders = new Headers();
    myHeaders.append("Accept", "application/json");
    myHeaders.append("Content-Type","application/json");

    const antet = { method: 'POST',
        headers: myHeaders,
        mode: 'cors',
        body:JSON.stringify(seat)};

    return fetch(CINEMATOGRAF_SEATS_BASE_URL,antet)
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
