package com.Auth.Authorize.Repo;

import com.Auth.Authorize.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
}
