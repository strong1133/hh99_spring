package com.hh99_spring.re_week02_03.repository;


import com.hh99_spring.re_week02_03.domain.Product;
import com.hh99_spring.re_week02_03.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findByUsername(String username);
}
