package services;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import model.User;

public interface UserService extends UserDetailsService {
    User register(String username,String password,String email);

}
