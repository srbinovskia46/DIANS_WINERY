package mk.ukim.finki.dianswineryappwip.model.exceptions;

public class PasswordsDoNotMatchException extends RuntimeException{
    public PasswordsDoNotMatchException(){
        super("Passwords do not match");
    }
}
