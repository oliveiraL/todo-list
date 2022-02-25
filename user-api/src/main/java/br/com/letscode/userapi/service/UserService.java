package br.com.letscode.userapi.service;

import br.com.letscode.userapi.exception.AccessDeniedException;
import br.com.letscode.userapi.exception.UserNotFoundExeption;
import br.com.letscode.userapi.model.User;
import br.com.letscode.userapi.repository.UserRepository;
import br.com.letscode.userapi.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;


    public String autenticationUser(User user) {
        return userRepository.findByUsername(user.getUsername())
                .map(userDB -> {
                    if (passwordEncoder.matches(user.getPassword(), userDB.getPassword())) {
                        return userDB.getExternalId();
                    }
                    return null;
                })
                .map(jwtUtil::generateToken)
                .orElseThrow(AccessDeniedException::new);
    }

    public User save(User user){
        user.setExternalId(UUID.randomUUID());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getByExternalId(UUID id){
        return userRepository.findByExternalId(id).orElseThrow(UserNotFoundExeption::new);
    }


}
