package hr.khorvat.blink.service.impl;

import hr.khorvat.blink.model.User;
import hr.khorvat.blink.repository.UserRepository;
import hr.khorvat.blink.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public User saveUser(){
        User u = new User();
        u.setFirstName("pero");
        u.setLastName("pero");
        u.setDateOfBirth(new Date());
        u.setSex("F");
        return userRepository.saveAndFlush(u);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
