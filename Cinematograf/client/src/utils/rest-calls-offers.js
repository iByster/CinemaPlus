import {CINEMATOGRAF_OFFERS_BASE_URL} from "./consts";
import {json, status} from "./rest-utils";

export function GetOffersByClient(clientId){
    console.log(clientId)
    const headers = {
        'Accept': 'application/json'
    }

    const myInit = { method: 'GET',
        headers: headers,
        mode: 'cors'};
    const request = new Request(CINEMATOGRAF_OFFERS_BASE_URL + '/client/' + clientId, myInit);

    console.log('Inainte de fetch pentru '+CINEMATOGRAF_OFFERS_BASE_URL)

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