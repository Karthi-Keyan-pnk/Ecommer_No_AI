package org.example.userservice.userservice.Repository;

import org.example.userservice.userservice.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
