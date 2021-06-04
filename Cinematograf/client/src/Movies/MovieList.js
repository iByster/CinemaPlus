import {useEffect, useState} from "react";
import {GetMovies} from "../utils/rest-calls-movies";
import {MovieCard} from "./MovieCard";
import style from './Movies.module.css'
import {useMovieContext} from "./MovieContextProvider";

export function MovieList(){


    const {selectedMovie, setSelectedMovie, movies, setMovies} = useMovieContext();

    useEffect( () => {
        GetMovies().then(movie => setMovies(movie));
    }, []);




    return (
      <section className={style['movie-container']}>
          {movies && movies.map((movie) => (<MovieCard setSelected={setSelectedMovie} data={movie} selected={selectedMovie} key={movie.id}/>))}
      </section>
    );
}