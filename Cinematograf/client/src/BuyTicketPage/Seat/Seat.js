import style from './Seat.module.css';
import {useState} from "react";

export function Seat(props){
    const {x, seatType} = props.data;
    let {y} = props.data;



    const [isSelected, setIsSelected] = useState(false);

    const color = seatType === 'FREE' ? 'white' : 'red';

    const toggleSelectSeat = () => {
        if(seatType === 'FREE'){
            setIsSelected(!isSelected);
            if(isSelected){
                console.log('remove' + props.data.id);
                console.log(props);
                props.removeSeatProp && props.removeSeatProp(props.data);
            } else {
                console.log(props);
                console.log('add' + props.data.id);
                props.addSeatProp && props.addSeatProp(props.data);
            }
        }
    }

    const setSeatInactive = () => {
        setIsSelected(false);
    }

    y += x % 2 === 1 ? 1 : 0;

    return(
        <div onClick={toggleSelectSeat} className={`${style.seat} ${isSelected ? style['seat-active'] : ''}`}
             style={{gridColumn : y, gridRow: x, background: color}}>

        </div>
    );
}