package br.com.letscode.userapi.controller;

import br.com.letscode.userapi.converter.UserMapper;
import br.com.letscode.userapi.dto.TokenDTO;
import br.com.letscode.userapi.dto.UserCreateDTO;
import br.com.letscode.userapi.dto.UserDTO;
import br.com.letscode.userapi.dto.UserLoginDTO;
import br.com.letscode.userapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;
    private final UserMapper mapper;

    @PostMapping("autentication")
    public ResponseEntity<TokenDTO> autentication(@RequestBody UserLoginDTO dto){
        final var token = service.autenticationUser(mapper.userLoginDTOToUser(dto));
        return ResponseEntity.ok(new TokenDTO(token));
    }

    @PostMapping
    public ResponseEntity<UserDTO> save(@RequestBody UserCreateDTO dto){
        final var user = service.save(mapper.userCreateDTOToUser(dto));
        return ResponseEntity.ok(mapper.userToUserDTO(user));
    }

    @GetMapping
    public List<UserDTO> getAll(){
        return service.getAll().stream().map(mapper::userToUserDTO).toList();
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDTO> getUserId(@PathVariable UUID id){
        final var user = service.getByExternalId(id);
        return ResponseEntity.ok(mapper.userToUserDTO(user));
    }
}
