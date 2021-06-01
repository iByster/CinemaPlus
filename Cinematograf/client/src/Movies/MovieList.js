import {useEffect, useState} from "react";
import {GetMovies} from "../utils/rest-calls-movies";
import {MovieCard} from "./MovieCard";
import style from './Movies.module.css'

export function MovieList(){
    const [movies, setMovies] = useState([]);

    useEffect(() => {
        GetMovies().then(movies => setMovies(movies))
    }, []);


    return (
      <section className={style['movie-container']}>
          {movies.length > 0 && movies.map((movie) => (<MovieCard data={movie} key={movie.id}/>))}
      </section>
    );
}