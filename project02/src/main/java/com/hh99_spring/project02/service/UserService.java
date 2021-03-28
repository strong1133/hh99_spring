package com.hh99_spring.project02.service;

import com.hh99_spring.project02.domain.User;
import com.hh99_spring.project02.dto.SignupRequestDto;
import com.hh99_spring.project02.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;


    public void registerUser(SignupRequestDto signupRequestDto) {
        //ID
        String username = signupRequestDto.getUsername();
        Optional<User> found = userRepository.findByUsername(username);

        if (found.isPresent()) {
            throw new IllegalArgumentException("duplicate");
        }

        //PW
        String password = signupRequestDto.getPassword();
        String password_check = signupRequestDto.getPassword_check();

        if (!password.equals(password_check)) {
            throw new IllegalArgumentException("notequal");
        }
        password = passwordEncoder.encode(signupRequestDto.getPassword());
        String email = signupRequestDto.getEmail();

        User user = new User(username, password, email);
        userRepository.save(user);
    }

}
