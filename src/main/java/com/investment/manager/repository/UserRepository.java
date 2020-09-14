package com.investment.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.investment.manager.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
