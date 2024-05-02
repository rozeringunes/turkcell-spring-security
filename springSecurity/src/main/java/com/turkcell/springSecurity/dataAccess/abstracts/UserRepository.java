package com.turkcell.springSecurity.dataAccess.abstracts;

import com.turkcell.springSecurity.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
