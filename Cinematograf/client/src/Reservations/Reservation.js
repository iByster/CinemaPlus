import {useEffect, useState} from "react";
import {FindOneMovie} from "../utils/rest-calls-movies";
import {GetSeatsByReservation} from "../utils/rest-calls-seats";
import style from './Reservations.module.css'
export function Reservation({data}){
    const { movieID, reservationDate, id } = data;



    const [movie, setMovie] = useState({});

    const [seats, setSeats] = useState([]);

    useEffect(() => {
        FindOneMovie(movieID.id).then(res => setMovie(res));
    }, [movieID]);

    useEffect(() => {
        GetSeatsByReservation(id).then(res => setSeats(res));
    }, [id]);

    console.log(movie)

    return(
        <article className={style['reservation-card']}>
            <img src={movie.image}/>
            <div className={style['right-side']}>
                <h4>{movie.title}</h4>
                <p>Your seats:{seats.map(seat => (<span>{`Seat(${seat.x}, ${seat.y})`}</span>))}</p>
                <p>Date:{reservationDate}</p>
            </div>
        </article>
    );
}