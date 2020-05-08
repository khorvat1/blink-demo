package hr.khorvat.blink.service;

import hr.khorvat.blink.model.User;

import java.util.List;

public interface UserService {

    User saveUser();

    List<User> findAll();
}
