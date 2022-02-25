package br.com.letscode.todolist.client;

import br.com.letscode.todolist.client.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:8081/users")
public interface UserApiClient {

    @GetMapping("/{id}")
    UserDTO getUser(@PathVariable("id") String id);
}
