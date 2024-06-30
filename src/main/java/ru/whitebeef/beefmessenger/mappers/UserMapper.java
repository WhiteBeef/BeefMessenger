package ru.whitebeef.beefmessenger.mappers;

import org.mapstruct.Mapper;
import ru.whitebeef.beefmessenger.dto.AuthRequestDto;
import ru.whitebeef.beefmessenger.dto.UserDto;
import ru.whitebeef.beefmessenger.entities.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto userToUserDto(User user);

    UserDto authRequestDtoToUserDto(AuthRequestDto authRequestDto);

    User userDtoToUser(UserDto userDto);
}
