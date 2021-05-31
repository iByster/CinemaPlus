package persistence.validators;

import entities.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieValidator implements Validator<Movie> {
    @Override
    public void validate(Movie entity) throws ValidationException {

    }
}
