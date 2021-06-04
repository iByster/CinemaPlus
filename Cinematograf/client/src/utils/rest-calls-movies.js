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

export function UpdateMovie(movie){
    console.log('inainte de fetch post'+JSON.stringify(movie));

    const myHeaders = new Headers();
    myHeaders.append("Accept", "application/json");
    myHeaders.append("Content-Type","application/json");

    const antet = { method: 'PUT',
        headers: myHeaders,
        mode: 'cors',
        body:JSON.stringify(movie)};

    return fetch(CINEMATOGRAF_MOVIES_BASE_URL+'/' + movie.id,antet)
        .then(status)
        .then(response=>{
            return response.text();
        }).catch(error=>{
            console.log('Request failed', error);
            return Promise.reject(error);
        });
}


export function DeleteMovieById(id){

    console.log(id);
    const headers = {
        'Accept': 'application/json'
    }

    const myInit = { method: 'DELETE',
        headers: headers,
        mode: 'cors'};
    const request = new Request(CINEMATOGRAF_MOVIES_BASE_URL + '/' + id, myInit);

    console.log('Inainte de fetch pentru '+CINEMATOGRAF_MOVIES_BASE_URL+ '/' + id);

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

export function FindOneMovie(movie){
    console.log(`MOOOOOVIEEE: ${movie}`);
    const headers = {
        'Accept': 'application/json'
    }

    const myInit = { method: 'GET',
        headers: headers,
        mode: 'cors'}
    const request = new Request(CINEMATOGRAF_MOVIES_BASE_URL + '/' + movie, myInit);

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

export function SaveMovie(movie){
    console.log('inainte de fetch post'+JSON.stringify(movie));

    const myHeaders = new Headers();
    myHeaders.append("Accept", "application/json");
    myHeaders.append("Content-Type","application/json");

    const antet = { method: 'POST',
        headers: myHeaders,
        mode: 'cors',
        body:JSON.stringify(movie)};

    return fetch(CINEMATOGRAF_MOVIES_BASE_URL,antet)
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
