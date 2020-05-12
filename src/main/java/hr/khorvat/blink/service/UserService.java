package hr.khorvat.blink.service;

import hr.khorvat.blink.model.dto.BasicUserDTO;
import hr.khorvat.blink.model.dto.UserDTO;
import hr.khorvat.blink.model.dto.UserDocumentDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    Page<BasicUserDTO> findAll(Pageable pageable);

    UserDTO findOne(Long id);

    UserDTO save(UserDTO userDTO);

    UserDTO update(UserDTO userDTO);

    void delete(Long id);

    UserDTO saveAutomaticEntry(UserDocumentDTO userDocumentDTO);
}
