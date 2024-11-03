package ru.clinic.org.clinicorganizer.dto;

import lombok.Data;
import ru.clinic.org.clinicorganizer.security.Role;

@Data
public class UserDto{
    private String username;
    private String password;
    private Role role;
}
