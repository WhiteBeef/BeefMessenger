package ru.whitebeef.beefmessenger.mappers;

import org.mapstruct.Mapper;
import ru.whitebeef.beefmessenger.dto.LoginDataDto;
import ru.whitebeef.beefmessenger.dto.UserDto;
import ru.whitebeef.beefmessenger.entities.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto userToUserDto(User user);

    UserDto authRequestDtoToUserDto(LoginDataDto loginDataDto);

    User userDtoToUser(UserDto userDto);
}
