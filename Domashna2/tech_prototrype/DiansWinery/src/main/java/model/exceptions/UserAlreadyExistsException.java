package model.exceptions;

    public class UserAlreadyExistsException extends RuntimeException {
        public UserAlreadyExistsException() {
            super("User already exists!");
        }
    }

