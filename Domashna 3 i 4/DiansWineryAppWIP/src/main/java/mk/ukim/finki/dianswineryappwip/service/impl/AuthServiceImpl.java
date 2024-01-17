package mk.ukim.finki.dianswineryappwip.service.impl;

import mk.ukim.finki.dianswineryappwip.model.User;
import mk.ukim.finki.dianswineryappwip.model.exceptions.InvalidArgumentsException;
import mk.ukim.finki.dianswineryappwip.model.exceptions.InvalidUserCredentialsException;
import mk.ukim.finki.dianswineryappwip.model.exceptions.PasswordsDoNotMatchException;
import mk.ukim.finki.dianswineryappwip.model.exceptions.UsernameAlreadyExistsException;
import mk.ukim.finki.dianswineryappwip.repository.UserRepository;
import mk.ukim.finki.dianswineryappwip.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User login(String username, String password) {
        if (username==null || username.isEmpty() || password==null || password.isEmpty()){
            throw new InvalidArgumentsException();
        }
        return userRepository.findByUsernameAndPassword(username, password)
                .orElseThrow(InvalidUserCredentialsException::new);
    }

    @Override
    public User register(String username, String password, String repeatPassword, String name, String surname) {
        if (username==null || username.isEmpty() || password==null || password.isEmpty()){
            throw new InvalidArgumentsException();
        }
        if (!password.equals(repeatPassword)){
            throw new PasswordsDoNotMatchException();
        }

        if (userRepository.findByUsername(username).isPresent()
                || !userRepository.findByUsername(username).isEmpty()){
            throw new UsernameAlreadyExistsException(username);
        }

        User user = new User(username, password, name, surname);
        userRepository.save(user);
        return user;
    }
}
