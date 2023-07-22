package com.Alemeno.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import com.Alemeno.dto.User;
public interface UserRepository extends JpaRepository<User, Integer> {

}
