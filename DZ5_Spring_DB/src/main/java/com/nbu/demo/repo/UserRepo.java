package com.nbu.demo.repo;

import com.nbu.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    User findUserByEmail(String email);

    @Query(value = "select u from User u where u.email=email and u.isActive=true", nativeQuery = false)
    User findActiveUserByEmail(@Param("email") String email);
}
