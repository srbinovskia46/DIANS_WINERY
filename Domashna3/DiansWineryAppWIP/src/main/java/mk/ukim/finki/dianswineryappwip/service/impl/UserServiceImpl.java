package mk.ukim.finki.dianswineryappwip.service.impl;

import mk.ukim.finki.dianswineryappwip.model.User;
import mk.ukim.finki.dianswineryappwip.model.exceptions.BadCredentialsException;
import mk.ukim.finki.dianswineryappwip.model.exceptions.PasswordsDoNotMatchException;
import mk.ukim.finki.dianswineryappwip.model.exceptions.UserAlreadyExistsException;
import mk.ukim.finki.dianswineryappwip.model.exceptions.UsernameNotFoundException;
import mk.ukim.finki.dianswineryappwip.repository.UserRepository;
import mk.ukim.finki.dianswineryappwip.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User register(String username, String password, String repeatPassword, String email, String name) {
        if (username == null || username.isEmpty() || password==null || password.isEmpty() || email==null || email.isEmpty()){
            throw new BadCredentialsException();
        }
        if (repeatPassword == null || repeatPassword.isEmpty() || !password.equals(repeatPassword)){
            throw new PasswordsDoNotMatchException();
        }
        if (userRepository.findByUsername(username).isPresent() || userRepository.findByEmail(email).isPresent()) {
            throw new UserAlreadyExistsException();
        }
        User user = new User(username, password, email, name);
        return userRepository.save(user);
    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
