package tn.iit.nawarni.services;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import tn.iit.nawarni.entities.StudentApplication;
import tn.iit.nawarni.repositories.StudentApplicationRepository;

@RequiredArgsConstructor
@Service
public class StudentApplicationService {

	private final StudentApplicationRepository saRepository;

	public StudentApplication getsaById(long id) throws Exception {
		return saRepository.findById(id).orElseThrow(() -> new Exception("not found or deleted"));
	}

	public StudentApplication add(StudentApplication sa) {
		return saRepository.save(sa);
	}

	public List<StudentApplication> getAll() {
		return saRepository.findAll();
	}

	public boolean exist(long id) {
		return saRepository.existsById(id);
	}

	public void delete(long id) {
		saRepository.deleteById(id);
	}
}
