package ru.freeomsk.Exception;

import org.springframework.dao.DataIntegrityViolationException;

public class UniqUsernameExistException extends DataIntegrityViolationException {
    public UniqUsernameExistException(String message) {
        super(message);
    }
}
