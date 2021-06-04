import style from '../Auth/Registration/Registration.module.css'
import styleAddMovie from './AddMovie.module.css'
import {useState} from "react";
import {GetMovies, SaveMovie, UpdateMovie} from "../utils/rest-calls-movies";
import {Link} from "react-router-dom";
import {SaveSeat} from "../utils/rest-calls-seats";
import {useMovieContext} from "../Movies/MovieContextProvider";
export function AddMovie(props){
    const {setMovies, selectedMovie, movies} = useMovieContext();
    const [movieValues, setMovieValues] = useState({
        id:-1,
        title: '',
        description:'',
        rating:0,
        duration:'',
        movieType:'',
        image:''
    });
    if(movieValues.id === -1){
        if(props?.isUpdate){
            setMovieValues({...movieValues,...movies.find(movie => movie.id === selectedMovie)});
        }
    }
    function handleInputChange(e) {
        setMovieValues({
            ...movieValues,
            [e.target.name]: e.target.value,
        });
    }

    async function handleAddMovie(e){
            await SaveMovie(movieValues).then(async res=>  {


        console.log(res);
        let row = 1;
        let col = 0;
        let switch_aux = 0;

        for(let i = 1; i <= 44; i++){

           col++;

           const seat = {
               x:row,
               y:col,
               seatType: 'FREE',
               movie:res.id,
               reservation: null
           }
           if(switch_aux === 0){
               if(col === 10){
                   switch_aux = 1;
                   col = 0;
                   row++;
               }
           } else {
               if(col === 12){
                   switch_aux = 0;
                   col = 0;
                   row++;
               }
           }
           await SaveSeat(seat);

       }
        }).then(res => GetMovies().then(r => setMovies(r)))
            .then(res => alert(`movie added ${JSON.stringify(res, null, 4)}`));
    }

    async function handleUpdateMovie(e){
        if(window.confirm('Are you sure you want do make these changes?')){
            await UpdateMovie(movieValues)
                .then(async res => {
                    GetMovies().then(r => setMovies(r));
                })
                .then(res => alert(`Movie updated successfully!`));
        }
    }

    return(
        <div className={style["registration-background"]}>
            <div className={style["registration-container"]}>
                {props?.isUpdate ? (<h1>Update Movie</h1>) : (<h1>New Movie</h1>)}

                <form className={styleAddMovie["add-movie-form-alignment-grid"]}>
                    <label className={style["grid-item-align-center"]} htmlFor="title">Title:</label>
                    <input value={movieValues.title} onChange={handleInputChange} className={style["grid-item-align-center-stretch"]} name="title" id="title" type="text"/>
                    <label className={style["grid-item-align-center"]} htmlFor="description">Description:</label>
                    <input value={movieValues.description} onChange={handleInputChange} className={style["grid-item-align-center-stretch"]} name="description" id="description" type="text"/>
                    <label className={style["grid-item-align-center"]} htmlFor="rating">Rating:</label>
                    <input value={movieValues.rating} onChange={handleInputChange} className={style["grid-item-align-center-stretch"]} name="rating" id="rating" type="text"/>
                    <label className={style["grid-item-align-center"]} htmlFor="duration">Duration:</label>
                    <input value={movieValues.duration} onChange={handleInputChange} className={style["grid-item-align-center-stretch"]} name="duration" id="duration" type="text"/>
                    <label className={style["grid-item-align-center"]} htmlFor="movieType">Movie Type:</label>
                    <input value={movieValues.movieType} onChange={handleInputChange} className={style["grid-item-align-center-stretch"]} name="movieType" id="movieType" type="text"/>
                    <label className={style["grid-item-align-center"]} htmlFor="image">Image url:</label>
                    <input value={movieValues.image} onChange={handleInputChange} className={style["grid-item-align-center-stretch"]} name="image" id="image" type="text"/>
                    <Link to={'/'}>
                        <button onClick={props?.isUpdate ? handleUpdateMovie : handleAddMovie} className={`${style["grid-item-align-center"]} ${styleAddMovie["add-movie-button"]}`} type="submit">Done!</button>
                    </Link>
                </form>
            </div>
        </div>
    );
}