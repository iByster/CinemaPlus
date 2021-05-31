import style from './BuyTicket.module.css'
import {useEffect, useState} from "react";
import {GetSeats} from "../utils/rest-calls-seats";
import {Seat} from "./Seat/Seat";
import {useLocation} from "react-router-dom";

export function BuyTicketPage(){

    const location = useLocation();

    const movieID = location.pathname.split('/')[3];

    console.log(movieID);

    const [seats, setSeats] = useState([]);

    useEffect(()=>{
        GetSeats(movieID).then(res => setSeats(res));
    }, []);

    const dataTest = {
        x: 2,
        y: 2,
        seatType: "TAKEN"
    }

    return(
        <section className={style["buyticket-container"]}>
            <div>
                <div className={style.screen}>
                    <p>Screen</p>
                </div>
            </div>
            <div className={style['seats-container']}>

            </div>
            <div>BuyTicket</div>
        </section>
    );
}