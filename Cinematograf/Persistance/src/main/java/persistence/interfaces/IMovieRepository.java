package persistence.interfaces;

import entities.Movie;

import java.util.List;

public interface IMovieRepository extends IRepositoryCrud<Movie, Long> {
    List<Movie> filterMovieByType();
    List<Movie> filterMovieByTitle();
    List<Movie> sortMoviesAscendingByTitle();
    List<Movie> sortMoviesDescendingByTitle();
    List<Movie> sortMoviesDescendingByRating();
    List<Movie> sortMoviesAscendingByRating();
}
