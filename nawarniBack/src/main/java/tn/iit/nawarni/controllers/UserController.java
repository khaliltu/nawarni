package tn.iit.nawarni.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.var;
import tn.iit.nawarni.entities.User;
import tn.iit.nawarni.services.UserService;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/users")
public class UserController {

	private final UserService userService;

	@GetMapping("/{id}")
	public ResponseEntity<User> read(@PathVariable long id) {
		User user;
		try {
			user = userService.getUserById(id);
			return ResponseEntity.ok(user);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping
	public ResponseEntity<List<User>> getAll() {
		List<User> listUsers = userService.getAll();
		return ResponseEntity.ok(listUsers);
	}

	@PostMapping
	public ResponseEntity<User> create(@RequestBody User user) {
		User newUser = userService.add(user);
		return ResponseEntity.ok(newUser);
	}

	@PutMapping
	public ResponseEntity<User> update(@RequestBody User user) {
		var newUser = new User();
		if (userService.exist(user.getId())) {
			newUser = userService.add(user);
			return ResponseEntity.ok(newUser);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping
	public ResponseEntity<User> delete(@RequestBody User user) {
		if (userService.exist(user.getId())) {
			userService.delete(user.getId());
			return ResponseEntity.ok(user);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
