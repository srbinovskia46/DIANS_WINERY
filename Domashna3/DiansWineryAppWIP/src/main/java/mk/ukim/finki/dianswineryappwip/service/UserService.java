package mk.ukim.finki.dianswineryappwip.service;

import mk.ukim.finki.dianswineryappwip.model.User;

public interface UserService {
    User register(String username, String password, String repeatPassword, String email, String name);
    User loadUserByUsername(String username);
}
