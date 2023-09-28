package org.example.app.services;

import org.example.app.database.DBCheck;
import org.example.app.entities.User;
import org.example.app.exceptions.CreateException;
import org.example.app.exceptions.DBException;
import org.example.app.repositories.UserCreateRepository;
import org.example.app.utils.Constants;
import org.example.app.utils.DataValidator;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserCreateService {

    UserCreateRepository repository;
    private static final Logger LOGGER =
            Logger.getLogger(UserCreateService.class.getName());

    public UserCreateService(UserCreateRepository repository) {
        this.repository = repository;
    }

    public String createUser(String[] data) {

        if (DBCheck.isDBExists()) {
            try {
                throw new DBException(Constants.DB_ABSENT_MSG);
            } catch (DBException e) {
                LOGGER.log(Level.SEVERE, Constants.LOG_DB_ABSENT_MSG);
                return e.getMessage();
            }
        }

        Map<String, String> errors = DataValidator.validateNamePhoneEmail(data);

        if (!errors.isEmpty()) {
            try {
                throw new CreateException("Check inputs", errors);
            } catch (CreateException ce) {
                LOGGER.log(Level.WARNING, Constants.LOG_DATA_INPUTS_WRONG_MSG);
                return ce.getErrors(errors);
            }
        }
        return repository.createUser(mapData(data));
    }

    private User mapData(String[] data) {
        User user = new User();
        user.setName(data[0].trim());
        user.setPhone(data[1].trim());
        user.setEmail(data[2].trim());
        return user;
    }
}
