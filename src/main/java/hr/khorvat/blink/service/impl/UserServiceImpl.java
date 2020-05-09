package hr.khorvat.blink.service.impl;

import hr.khorvat.blink.external.BlinkFeignClient;
import hr.khorvat.blink.model.User;
import hr.khorvat.blink.model.dto.*;
import hr.khorvat.blink.model.mapper.UserMapper;
import hr.khorvat.blink.repository.UserRepository;
import hr.khorvat.blink.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final BlinkFeignClient blinkFeignClient;

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

    @Override
    @Transactional
    public UserDTO save(UserDTO userDTO) {
        User user = userMapper.toEntity(userDTO);
        user = userRepository.saveAndFlush(user);

        return new UserDTO(user);
    }

    @Override
    @Transactional
    public UserDTO update(UserDTO userDTO) {
        User user = userRepository.findById(userDTO.getId()).orElseThrow(() -> new IllegalStateException("User not found for Id"));
        user = userMapper.patchEntity(userDTO, user);
        user = userRepository.saveAndFlush(user);

        return new UserDTO(user);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    @Transactional
    public UserDTO saveAutomaticEntry(UserDocumentDTO userDocumentDTO) {
        BlinkRequestDTO blinkRequestDTO = new BlinkRequestDTO(userDocumentDTO.getImageURL(), userDocumentDTO.getImageBase64());
        ResponseEntity<BlinkResponseDTO> response = blinkFeignClient.request(blinkRequestDTO);
        if (response.getStatusCode() != HttpStatus.OK) {
            throw new IllegalStateException("Exception in image processing");
        }
        BlinkResponseDTO userData = response.getBody();

        User user = userMapper.toEntity(userData, userDocumentDTO);
        user = userRepository.saveAndFlush(user);

        return new UserDTO(user);
    }
}
