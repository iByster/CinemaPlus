package persistence.validators;

import entities.Offer;
import org.springframework.stereotype.Component;

@Component
public class OfferValidator implements Validator<Offer> {
    @Override
    public void validate(Offer entity) throws ValidationException {

    }
}
