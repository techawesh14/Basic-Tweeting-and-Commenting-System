package com.Alemeno.dao;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.Alemeno.dto.User;
import com.Alemeno.repo.UserRepository;
@Repository
public class UserDao {
	@Autowired
	private UserRepository userRepository;
	public User saveUser(User user) {	
		return userRepository.save(user);
	}
	public User updateUser(User user) {
		return userRepository.save(user);
	}
	public Optional<User> getUser(int id) {
		return userRepository.findById(id);
	}
	
	public List<User> getAll() {
		return userRepository.findAll();
	}
	public void deleteUser(int id) {
		userRepository.deleteById(id);
		
	}

}
