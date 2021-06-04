import style from './SidebarUtils.module.css'
import {useAuthContext} from "../../Auth/AuthContext";
import {NavLink} from "react-router-dom";
import {useMovieContext} from "../../Movies/MovieContextProvider";
import {DeleteMovieById, GetMovies} from "../../utils/rest-calls-movies";
import {DeleteSeatsByMovie} from "../../utils/rest-calls-seats";
import {DeleteReservationsByMovId} from "../../utils/rest-calls-reservations";

export function SidebarUtils(){
    const {userProfile} = useAuthContext();
    const {selectedMovie, setMovies} = useMovieContext();

    const handleDeleteMovie = async () => {
        if(window.confirm(`Are you sure you want to delete movie with id: ${selectedMovie}?`)){
            console.log(selectedMovie);
            await DeleteSeatsByMovie(selectedMovie);
            await DeleteReservationsByMovId(selectedMovie);
            await DeleteMovieById(selectedMovie);
            await GetMovies().then(r => setMovies(r))
            alert(`Movie with id deleted:${selectedMovie}`)
        }
    }



    return(

      <div className={style.container}>
          {userProfile?.adminMode && (
              <div className={style['button-container']}>
                  <NavLink to={'/admin/add-movie'}>
                    <button className={style.button}>Add Movie</button>
                  </NavLink>
                  <button  onClick={handleDeleteMovie} className={style.button}>Delete Movie</button>
                  <NavLink to={'/admin/update-movie'}>
                    <button className={style.button}>Update Movie</button>
                  </NavLink>
              </div>
              )}
      </div>
    );
}