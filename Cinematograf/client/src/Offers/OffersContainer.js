import {useEffect, useState} from "react";
import {useAuthContext} from "../Auth/AuthContext";
import style from './Offers.module.css';
import {GetOffersByClient} from "../utils/rest-calls-offers";
import {Offers} from "./Offers";

export function OffersContainer(){
    const [offers, setOffers] = useState([]);

    const {userProfile} = useAuthContext();

    useEffect(() => {
        GetOffersByClient(userProfile.username).then(res => setOffers(res));
    }, [userProfile]);

    return(
        <section className={style['offers-container']}>
            {offers.map((offer) => (<Offers key={offer.id} data={offer}/>))}
        </section>
    );
}