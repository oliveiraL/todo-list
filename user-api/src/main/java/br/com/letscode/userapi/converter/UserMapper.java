package br.com.letscode.userapi.converter;

import br.com.letscode.userapi.dto.UserCreateDTO;
import br.com.letscode.userapi.dto.UserDTO;
import br.com.letscode.userapi.dto.UserLoginDTO;
import br.com.letscode.userapi.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User userDTOToUser(UserDTO dto);

    User userLoginDTOToUser(UserLoginDTO dto);

    UserDTO userToUserDTO(User user);

    User userCreateDTOToUser(UserCreateDTO dto);
}
