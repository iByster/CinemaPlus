import {createContext, useContext, useEffect, useState} from 'react';
import {GetMovies} from "../utils/rest-calls-movies";

export const MovieContext = createContext();

export function useMovieContext() {
    return useContext(MovieContext);
}

export function MovieContextProvider({ children }) {
    // const [accessToken, setAccessToken] = useState();
    const [selectedMovie, setSelectedMovie] = useState();
    const [movies, setMovies] = useState([]);


    const selectMovie = (movie) => {
        setSelectedMovie(movie);
    }


    return (
        <MovieContext.Provider value={{selectedMovie, selectMovie, setSelectedMovie, movies, setMovies}}>
            {children}
        </MovieContext.Provider>
    );
}