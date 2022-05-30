package tn.iit.nawarni.services;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import tn.iit.nawarni.entities.User;
import tn.iit.nawarni.repositories.UserRepository;

@RequiredArgsConstructor
@Service
public class UserService {

	private final UserRepository userRepository;

	public User getUserById(long id) throws Exception {
		return userRepository.findById(id).orElseThrow(() -> new Exception("User not found"));
	}

	public User add(User user) {
		return userRepository.save(user);
	}

	public List<User> getAll() {
		return userRepository.findAll();
	}

	public boolean exist(long id) {
		return userRepository.existsById(id);
	}

	public void delete(long id) {
		userRepository.deleteById(id);
	}
}
