package mk.ukim.finki.dianswineryappwip.service.impl;

import mk.ukim.finki.dianswineryappwip.repository.UserRepository;
import mk.ukim.finki.dianswineryappwip.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
