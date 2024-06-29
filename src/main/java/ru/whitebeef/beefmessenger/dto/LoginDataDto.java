package ru.whitebeef.beefmessenger.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class LoginDataDto {
    @NotNull
    @Size(min = 3, max = 30)
    private String username;
    @NotNull
    @Size(min = 3, max = 30)
    private String password;
}
