import style from './BuyTicket.module.css'
import {useEffect, useState} from "react";
import {GetSeats, UpdateSeat} from "../utils/rest-calls-seats";
import {Seat} from "./Seat/Seat";
import {useLocation} from "react-router-dom";
import {SaveReservation} from "../utils/rest-calls-reservations";
import {useAuthContext} from "../Auth/AuthContext";

export function BuyTicketPage(){

    const {userProfile} = useAuthContext();

    const location = useLocation();

    const movieID = location.pathname.split('/')[3];

    console.log(movieID);


    const [seats, setSeats] = useState([]);


    const selectedSeats = [];



    useEffect(()=>{
        GetSeats(movieID).then(res => setSeats(res));
    }, []);

    const handleBuyTicketBtn = () => {
        const reservation = {
            id:'0',
            movieID: movieID,
            clientID: userProfile.username,
            reservationDate: `${Date.now()}`
        }
        SaveReservation(reservation)
            .then(res => {
                selectedSeats.forEach(seat => {
                    seat.seatType = 'TAKEN';
                    console.log("HEREEEEEEEEEEEE " + res.id);
                    seat.reservation = res.id;
                    UpdateSeat(seat)
                        .then(r => console.log(r));
                });
            })
            .catch(e=>console.log(e));

        selectedSeats.length = 0;
    }

    const addSeat = (seat) => {
        selectedSeats.push(seat)
        console.log(selectedSeats);
    }

    const removeSeat = (seat) => {
        const index = selectedSeats.indexOf(seat);
        selectedSeats.splice(index, 1);
        console.log(selectedSeats);
    }

    const seatInactive = () => {

    }


    return(
        <section className={style["buyticket-container"]}>
            <div>
                <div className={style.screen}>
                    <p>Screen</p>
                </div>
            </div>
            <div className={style['seats-container']}>
                {
                    seats.map((seat) => (<Seat key={seat.id} seatInactive={seatInactive} addSeatProp={addSeat} removeSeatProp={removeSeat} data={seat}/>))
                }
            </div>
            <div>
                <button onClick={handleBuyTicketBtn} className={`${style.button} ${style['buyticket-button']}`}>BUY TICKETS</button>
            </div>
        </section>
    );
}