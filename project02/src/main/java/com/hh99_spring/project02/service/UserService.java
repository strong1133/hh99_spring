package com.hh99_spring.project02.service;

import com.hh99_spring.project02.domain.User;
import com.hh99_spring.project02.dto.SignupRequestDto;
import com.hh99_spring.project02.repository.UserRepository;
import com.hh99_spring.project02.util.SignupValidator;
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
        //정규식 검사
        if(!SignupValidator.idValid(username)){
            throw new IllegalArgumentException("idValid");
        }
        //중복검사
        Optional<User> found = userRepository.findByUsername(username);
        if (found.isPresent()) {
            throw new IllegalArgumentException("duplicate");
        }

        //PW
        String password = signupRequestDto.getPassword();
        String password_check = signupRequestDto.getPassword_check();
        //정규식 검사
        if(!SignupValidator.pwValid(username, password)){
            throw new IllegalArgumentException("pwValid");
        }
        //비밀번호 재입력 일치 검사
        if (!password.equals(password_check)) {
            throw new IllegalArgumentException("notequal");
        }
        //모든조건 충족시 비밀번호 암호화
        password = passwordEncoder.encode(signupRequestDto.getPassword());

        //Email
        String email = signupRequestDto.getEmail();
        if (!SignupValidator.emailValid(email)){
            throw new IllegalArgumentException("emailValid");
        }

        User user = new User(username, password, email);
        userRepository.save(user);
    }

}
