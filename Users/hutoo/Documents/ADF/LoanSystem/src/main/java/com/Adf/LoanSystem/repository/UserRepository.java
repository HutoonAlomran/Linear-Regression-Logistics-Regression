package com.Adf.LoanSystem.repository;

import com.Adf.LoanSystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByNid(Integer nid);
}

