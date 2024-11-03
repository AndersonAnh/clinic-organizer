package ru.clinic.org.clinicorganizer.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.clinic.org.clinicorganizer.dto.UserDto;
import ru.clinic.org.clinicorganizer.security.User;
import ru.clinic.org.clinicorganizer.service.UserService;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserApiController {
    private final UserService userService;

    @PostMapping("/create")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<User> create(@RequestBody UserDto userDto){
        return new ResponseEntity<>(userService.save(userDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public void deleteUserById(@PathVariable Integer id){
        userService.delete(id);
    }

    @GetMapping
    public List<User> findAllUsers(){
        return userService.findAllUsers();
    }
}
