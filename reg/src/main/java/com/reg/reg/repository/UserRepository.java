package com.reg.reg.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.reg.reg.model.User;

public interface UserRepository extends JpaRepository<User, Long> 
{

}

