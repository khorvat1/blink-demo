package hr.khorvat.blink.service.impl;

import hr.khorvat.blink.model.User;
import hr.khorvat.blink.model.dto.BasicUserDTO;
import hr.khorvat.blink.model.dto.UserDTO;
import hr.khorvat.blink.repository.UserRepository;
import hr.khorvat.blink.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<BasicUserDTO> findAll(Pageable pageable) {
        return userRepository.findAll(pageable).map(BasicUserDTO::new);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDTO findOne(Long id) {
        Objects.requireNonNull(id);
        User user = userRepository.findOneWithEagerRelationsById(id).orElseThrow(() -> new IllegalStateException("User not found for Id"));
        UserDTO userDTO = new UserDTO(user);
        return userDTO;
    }
}
