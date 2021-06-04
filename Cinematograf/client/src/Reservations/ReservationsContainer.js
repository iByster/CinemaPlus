import {useEffect, useState} from "react";
import {GetReservationsByClient} from "../utils/rest-calls-reservations";
import {Reservation} from "./Reservation";
import {useAuthContext} from "../Auth/AuthContext";
import style from './Reservations.module.css'
export function ReservationsContainer(){
    const [reservations, setReservations] = useState([]);

    const {userProfile} = useAuthContext();

    useEffect(() => {
        GetReservationsByClient(userProfile.username).then(res => setReservations(res));
    }, [userProfile]);

    console.log(`RESERVATION: + reservations`)

    return(
        <section className={style['reservation-container']}>
            {reservations.length > 0 && reservations.map(reservation => (<Reservation data={reservation} key={reservation.id} />))}
        </section>
    );
}