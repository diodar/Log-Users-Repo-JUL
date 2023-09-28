package org.example.app.utils;

import java.util.HashMap;
import java.util.Map;

public class DataValidator {

    public static Map<String, String> validateData(String[] data) {
        String strId = data[0].trim();
        int id = 0;

        Map<String, String> errors = new HashMap<>();

        try {
            id = Integer.parseInt(strId);
        } catch (NumberFormatException nfe) {
            errors.put("id", nfe.getMessage());
        }

        if (IdValidator.isIdValid(strId))
            errors.put("id", Constants.WRONG_ID_MSG);
        if (id <= 0)
            errors.put("id", Constants.WRONG_ID_MSG);
        if (IdChecker.isIdExists(id))
            errors.put("id", Constants.ID_NO_EXISTS_MSG);
        if (PhoneValidator.isPhoneValid(data[1]))
            errors.put("phone", Constants.WRONG_PHONE_MSG);
        if (EmailValidator.isEmailValid(data[2]))
            errors.put("email", Constants.WRONG_EMAIL_MSG);

        return errors;
    }

    public static Map<String, String> validateIdPhone(String[] data) {
        String strId = data[0].trim();
        int id = 0;

        Map<String, String> errors = new HashMap<>();

        try {
            id = Integer.parseInt(strId);
        } catch (NumberFormatException nfe) {
            errors.put("id", nfe.getMessage());
        }

        if (IdValidator.isIdValid(strId))
            errors.put("id", Constants.WRONG_ID_MSG);
        if (id <= 0)
            errors.put("id", Constants.WRONG_ID_MSG);
        if (IdChecker.isIdExists(id))
            errors.put("id", Constants.ID_NO_EXISTS_MSG);
        if (PhoneValidator.isPhoneValid(data[1]))
            errors.put("phone", Constants.WRONG_PHONE_MSG);
        return errors;
    }

    public static Map<String, String> validateIdEmail(String[] data) {
        String strId = data[0].trim();
        int id = 0;

        Map<String, String> errors = new HashMap<>();

        try {
            id = Integer.parseInt(strId);
        } catch (NumberFormatException nfe) {
            errors.put("id", nfe.getMessage());
        }

        if (IdValidator.isIdValid(strId))
            errors.put("id", Constants.WRONG_ID_MSG);
        if (id <= 0)
            errors.put("id", Constants.WRONG_ID_MSG);
        if (IdChecker.isIdExists(id))
            errors.put("id", Constants.ID_NO_EXISTS_MSG);
        if (EmailValidator.isEmailValid(data[2]))
            errors.put("phone", Constants.WRONG_PHONE_MSG);
        return errors;
    }

    public static Map<String, String> validateId(String[] data) {
        String strId = data[0].trim();
        int id = 0;

        Map<String, String> errors = new HashMap<>();

        try {
            id = Integer.parseInt(strId);
        } catch (NumberFormatException nfe) {
            errors.put("id", nfe.getMessage());
        }

        if (IdValidator.isIdValid(strId))
            errors.put("id", Constants.WRONG_ID_MSG);

        if (id <= 0)
            errors.put("id", Constants.WRONG_ID_MSG);

        if (IdChecker.isIdExists(id))
            errors.put("id", Constants.ID_NO_EXISTS_MSG);

        return errors;
    }

    public static Map<String, String> validateNamePhoneEmail(String[] data) {

        Map<String, String> errors = new HashMap<>();

        if (data[0].trim().isEmpty())
            errors.put("name", Constants.INPUT_REQ_MSG);

        if (PhoneValidator.isPhoneValid(data[1].trim()))
            errors.put("phone", Constants.WRONG_PHONE_MSG);

        if (EmailValidator.isEmailValid(data[2].trim()))
            errors.put("email", Constants.WRONG_EMAIL_MSG);

        return errors;
    }
}
