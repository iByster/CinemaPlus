import style from './Seat.module.css';
import {useEffect, useState} from "react";

export function Seat(props){
    let {x, seatType} = props.data;
    // console.log(seatType);
    let {y} = props.data;
    const [isSelected, setIsSelected] = useState(false);
    //
    // useEffect(() => {
    //     if(props.isTaken(seatType)){
    //         setIsSelected(!isSelected);
    //     }
    // }, [seatType]);


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



    y += x % 2 === 1 ? 1 : 0;

    return(
        <div onClick={toggleSelectSeat} className={`${style.seat} ${isSelected && seatType === 'FREE'  ? style['seat-active'] : style['seat-taken']}`}
             style={{gridColumn : y, gridRow: x, background: color}}>

        </div>
    );
}