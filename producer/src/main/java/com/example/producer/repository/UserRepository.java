package com.example.producer.repository;

import com.example.producer.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author liu
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
