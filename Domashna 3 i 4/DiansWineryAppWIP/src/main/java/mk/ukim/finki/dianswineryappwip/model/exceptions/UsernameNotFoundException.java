package mk.ukim.finki.dianswineryappwip.model.exceptions;

public class UsernameNotFoundException extends RuntimeException{
    public UsernameNotFoundException(String username) {
        super(String.format("Username: $s not found", username));
    }
}
