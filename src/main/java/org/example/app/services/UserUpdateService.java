package org.example.app.services;

import org.example.app.database.DBCheck;
import org.example.app.entities.User;
import org.example.app.exceptions.DBException;
import org.example.app.exceptions.UpdateException;
import org.example.app.repositories.UserUpdateRepository;
import org.example.app.utils.*;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserUpdateService {

    UserUpdateRepository repository;
    private static final Logger LOGGER =
            Logger.getLogger(UserUpdateService.class.getName());

    public UserUpdateService(UserUpdateRepository repository) {
        this.repository = repository;
    }

    public String updateUser(String[] data) {
        if (DBCheck.isDBExists()) {
            try {
                throw new DBException(Constants.DB_ABSENT_MSG);
            } catch (DBException e) {
                LOGGER.log(Level.SEVERE, Constants.LOG_DB_ABSENT_MSG);
                return e.getMessage();
            }
        }

        Map<String, String> errors = DataValidator.validateData(data);

        if (errors.size() > 0) {
            try {
                throw new UpdateException("Check inputs for update data.", errors);
            } catch (UpdateException ue) {
                LOGGER.log(Level.WARNING, Constants.LOG_DATA_INPUTS_WRONG_MSG);
                return ue.getErrors(errors);
            }
        }
        return repository.updateAllUserInfo(mapData(data));
    }

    public String updatePhone(String[] data) {

        if (DBCheck.isDBExists()) {
            try {
                throw new DBException(Constants.DB_ABSENT_MSG);
            } catch (DBException e) {
                LOGGER.log(Level.SEVERE, Constants.LOG_DB_ABSENT_MSG);
                return e.getMessage();
            }
        }

        Map<String, String> errors = DataValidator.validateIdPhone(data);

        if (errors.size() > 0) {
            try {
                throw new UpdateException("Check inputs for update data.", errors);
            } catch (UpdateException ue) {
                LOGGER.log(Level.WARNING, Constants.LOG_DATA_INPUTS_WRONG_MSG);
                return ue.getErrors(errors);
            }
        }
        return repository.updateUserPhone(mapData(data));
    }

    public String updateEmail(String[] data) {

        if (DBCheck.isDBExists()) {
            try {
                throw new DBException(Constants.DB_ABSENT_MSG);
            } catch (DBException e) {
                LOGGER.log(Level.SEVERE, Constants.LOG_DB_ABSENT_MSG);
                return e.getMessage();
            }
        }

        Map<String, String> errors = DataValidator.validateIdEmail(data);

        if (errors.size() > 0) {
            try {
                throw new UpdateException("Check inputs for update data.", errors);
            } catch (UpdateException ue) {
                LOGGER.log(Level.WARNING, Constants.LOG_DATA_INPUTS_WRONG_MSG);
                return ue.getErrors(errors);
            }
        }
        return repository.updateUserEmail(mapData(data));
    }

    private User mapData(String[] data) {
        User user = new User();
        user.setId(Integer.parseInt(data[0].trim()));
        user.setPhone(data[1]);
        user.setEmail(data[2]);
        return user;
    }
}
