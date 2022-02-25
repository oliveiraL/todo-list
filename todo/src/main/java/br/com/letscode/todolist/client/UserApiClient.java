package br.com.letscode.todolist.client;

import br.com.letscode.todolist.client.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(url = "http://localhost:8081/users", name = "userApi")
public interface UserApiClient {

    @GetMapping("/{id}")
    UserDTO getUser(@PathVariable("id") UUID id);
}
