package persistence.validators;

import entities.Admin;
import org.springframework.stereotype.Component;

@Component
public class AdminValidator implements Validator<Admin> {
    @Override
    public void validate(Admin entity) throws ValidationException {

    }
}
