package persistence.validators;

import entities.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientValidator implements Validator<Client>{

    @Override
    public void validate(Client entity) throws ValidationException {

    }
}
