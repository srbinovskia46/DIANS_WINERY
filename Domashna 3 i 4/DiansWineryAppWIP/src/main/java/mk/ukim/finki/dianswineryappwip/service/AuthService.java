package mk.ukim.finki.dianswineryappwip.service;

import mk.ukim.finki.dianswineryappwip.model.User;

public interface AuthService{
    User login(String username, String password);
    User register(String username, String password, String repeatPassword, String name, String surname);
}
