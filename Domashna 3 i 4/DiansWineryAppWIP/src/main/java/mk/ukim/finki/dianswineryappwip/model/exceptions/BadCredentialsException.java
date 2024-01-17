package mk.ukim.finki.dianswineryappwip.model.exceptions;

public class BadCredentialsException extends RuntimeException{
    public BadCredentialsException() {
        super("Missing username or password");
    }
}
