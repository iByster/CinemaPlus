package persistence.validators;

import entities.Seat;
import org.springframework.stereotype.Component;

@Component
public class SeatValidator implements Validator<Seat>{
    @Override
    public void validate(Seat entity) throws ValidationException {

    }
}
