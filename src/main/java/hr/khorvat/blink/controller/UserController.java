package hr.khorvat.blink.controller;

import hr.khorvat.blink.model.dto.BasicUserDTO;
import hr.khorvat.blink.model.dto.UserDTO;
import hr.khorvat.blink.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/users")
    public ResponseEntity<Page<BasicUserDTO>> findAll(Pageable pageable) {
        Page<BasicUserDTO> users = userService.findAll(pageable);
        return ResponseEntity.ok(users);
    }

    @GetMapping(value = "/users/{id}")
    public ResponseEntity<UserDTO> findAll(@PathVariable Long id) {
        UserDTO user = userService.findOne(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> save(@RequestBody @Valid UserDTO userDTO) {
        UserDTO user = userService.save(userDTO);
        return ResponseEntity.ok(user);
    }

    @PutMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> update(@RequestBody @Valid UserDTO userDTO) {
        UserDTO user = userService.update(userDTO);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping(value = "/users/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.ok().build();
    }
}
