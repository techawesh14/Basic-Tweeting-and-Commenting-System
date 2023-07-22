package com.Alemeno.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Alemeno.dao.UserDao;
import com.Alemeno.dto.ResponseStructure;
import com.Alemeno.dto.User;
import com.Alemeno.exception.IdNotFoundException;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;

	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
		ResponseStructure<User> structure = new ResponseStructure<User>();
		structure.setBody(userDao.saveUser(user));
		structure.setMessage("Saved Successfully");
		structure.setCode(HttpStatus.ACCEPTED.value());

		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<User>> updateUser(User user) {
		ResponseStructure<User> structure = new ResponseStructure<User>();

		structure.setBody(userDao.updateUser(user));
		structure.setMessage("Updated Successfully");
		structure.setCode(HttpStatus.ACCEPTED.value());

		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<String>> deleteUser(int id) {
		ResponseStructure<String> structure = new ResponseStructure<String>();
		Optional<User> op = userDao.getUser(id);
		if (op.isPresent()) {
			userDao.deleteUser(id);

			structure.setBody("User Present");
			structure.setMessage("Deleted Successfully");
			structure.setCode(HttpStatus.FOUND.value());
		} else
			throw new IdNotFoundException();

		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<User>> getUser(int id) {
		ResponseStructure<User> structure = new ResponseStructure<User>();

		Optional<User> op = userDao.getUser(id);
		if (op.isPresent()) {
			structure.setBody(op.get());
			structure.setMessage("Id is present");
			structure.setCode(HttpStatus.FOUND.value());
		} else
			throw new IdNotFoundException();

		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.FOUND);
	}
	public ResponseEntity<ResponseStructure<List<User>>> getAll() {
		ResponseStructure<List<User>> structure = new ResponseStructure<List<User>>();
		structure.setBody(userDao.getAll());
		structure.setMessage("Records are fetched");
		structure.setCode(HttpStatus.FOUND.value());
		return new ResponseEntity<ResponseStructure<List<User>>>(structure, HttpStatus.FOUND);
	}
}
