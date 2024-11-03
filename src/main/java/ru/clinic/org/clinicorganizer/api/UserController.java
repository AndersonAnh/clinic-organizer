package ru.clinic.org.clinicorganizer.api;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.clinic.org.clinicorganizer.dto.UserDto;
import ru.clinic.org.clinicorganizer.security.User;
import ru.clinic.org.clinicorganizer.service.UserService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public String users (Model model){
        List<User> users = userService.findAllUsers();
        model.addAttribute("users",users);
        return "user/users";
    }

    @GetMapping("/users/add")
    public String showAddUserForm(Model model){
        model.addAttribute("user",new User());
        return "user/add-user";
    }

    @PostMapping("/users/add")
    public String addUser(UserDto userDto){
        userService.save(userDto);
        return "redirect:/users";
    }

    @GetMapping("/users/delete")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public String showDeleteUserForm(){
        return "user/delete-user";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PostMapping("/users/delete")
    public String deleteUser(@RequestParam Integer id){
        userService.delete(id);
        return "redirect:/users";
    }
}
