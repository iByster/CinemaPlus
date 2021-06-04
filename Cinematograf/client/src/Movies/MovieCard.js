import {Link} from "react-router-dom";
import style from './Movies.module.css'
import {useState} from "react";
import {useAuthContext} from "../Auth/AuthContext";
export function MovieCard({data, setSelected, selected}){
    const {title, description, rating, duration, movieType, image} = data;

    const {userProfile} = useAuthContext();

    const handleSelectedMovie = () => {
        console.log("hereeeee");
        setSelected(data.id);
    }
    return (
        <article onClick={handleSelectedMovie} className={`${style['movie-card']}  ${selected === data.id && userProfile?.adminMode && style['movie-card-selected']}`}>
            <Link to={"/movies/" + data.id}>

                <img src={image} alt={title}/>
                <h2>{title}</h2>

                </Link>
            <p>{description}</p>
            <ul>
                <p>Type:{movieType}</p>
                <p>Duration:{duration}</p>
                <p>Rating:{rating}/10</p>
            </ul>
            <Link to={`/buyticket/${title}/${data.id}`}>
                <button>Buy Ticket!</button>
            </Link>
        </article>
    );
}