import {Link} from "react-router-dom";
import style from './Movies.module.css'
export function MovieCard({data}){
    const {title, description, rating, duration, movieType, image} = data;
    return (
        <article className={style['movie-card']}>
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