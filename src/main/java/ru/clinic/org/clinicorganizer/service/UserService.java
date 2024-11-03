package ru.clinic.org.clinicorganizer.service;

import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.clinic.org.clinicorganizer.dto.UserDto;
import ru.clinic.org.clinicorganizer.repo.UserRepository;
import ru.clinic.org.clinicorganizer.security.User;

import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return userRepository.findByUsername(username)
                .map(user -> {
                    return new org.springframework.security.core.userdetails.User(
                            user.getUsername(),
                            user.getPassword(),
                            Collections.singleton(new SimpleGrantedAuthority(user.getRole().name()))
                    );
                })
                .orElseThrow(() -> {
                    return new UsernameNotFoundException("Не удалось найти пользователя: " + username);
                });
    }
    public User save(UserDto userDto){
        User user = User.builder()
                .username(userDto.getUsername())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .role(userDto.getRole())
                .build();
        return userRepository.save(user);
    }

    public void delete(Integer id){
        userRepository.deleteById(id);
    }

    public List<User>findAllUsers(){
       return userRepository.findAll();
    }
}
