import style from './BuyTicket.module.css'
import {useEffect, useState} from "react";
import {GetSeats, UpdateSeat} from "../utils/rest-calls-seats";
import {Seat} from "./Seat/Seat";
import {useLocation} from "react-router-dom";
import {SaveReservation} from "../utils/rest-calls-reservations";
import {useAuthContext} from "../Auth/AuthContext";
import {GetMovies} from "../utils/rest-calls-movies";
import {useMovieContext} from "../Movies/MovieContextProvider";

export function BuyTicketPage(){

    const {userProfile} = useAuthContext();

    const location = useLocation();

    const movieID = location.pathname.split('/')[3];

    console.log(movieID);

    const {setMovies} = useMovieContext();


    const [seats, setSeats] = useState([]);


    const selectedSeats = [];



    useEffect(()=>{
        GetSeats(movieID).then(res => setSeats(res));
    }, [movieID]);

    const handleBuyTicketBtn = async () => {
        const reservation = {
            id: '0',
            movieID: movieID,
            clientID: userProfile.username,
            reservationDate: `${Date.now()}`
        }
        const res = await SaveReservation(reservation);

        for(let i = 0; i < selectedSeats.length; i++){
            selectedSeats[i].seatType = 'TAKEN';
            console.log("HEREEEEEEEEEEEE " + res.id);
            selectedSeats[i].reservation = res.id;
            await UpdateSeat(selectedSeats[i]);

        }



        selectedSeats.length = 0


        await GetSeats(movieID).then(r => setSeats(r))
        alert(`Reservation made: ${JSON.stringify(reservation, null, 4)}`);

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


    return(
        <section className={style["buyticket-container"]}>
            <div>
                <div className={style.screen}>
                    <p>Screen</p>
                </div>
            </div>
            <div className={style['seats-container']}>
                {
                    seats.map((seat) => (<Seat key={seat.id} addSeatProp={addSeat} removeSeatProp={removeSeat} data={seat}/>))
                }
            </div>
            <div>
                <button onClick={handleBuyTicketBtn} className={`${style.button} ${style['buyticket-button']}`}>BUY TICKETS</button>
            </div>
        </section>
    );
}