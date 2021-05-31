package persistence.validators;

import entities.Reservation;
import org.springframework.stereotype.Component;

@Component
public class ReservationValidator implements Validator<Reservation> {
    @Override
    public void validate(Reservation entity) throws ValidationException {

    }
}
