package ru.whitebeef.beefmessenger.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import ru.whitebeef.beefmessenger.entities.UserRole;

@Data
public class UserDto {

    @NotEmpty
    @Size(min = 3, max = 30)
    private String username;
    private String password;
    private UserRole userRole;
    private Boolean locked;
    private Boolean enabled;

}
