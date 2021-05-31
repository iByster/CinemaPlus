import style from './Seat.module.css';
import {useLocation} from "react-router-dom";

export function Seat({data}){
    const {x, y, seatType} = data;

    const color = seatType === 'FREE' ? 'white' : 'red';


    return(
        <div className={style.seat} style={{gridColumn : x, gridRow: y, background: color}}>

        </div>
    );
}