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

import ch.qos.logback.classic.spi.STEUtil;
import lombok.RequiredArgsConstructor;
import lombok.var;
import tn.iit.nawarni.entities.StudentApplication;
import tn.iit.nawarni.entities.User;
import tn.iit.nawarni.services.StudentApplicationService;
import tn.iit.nawarni.services.UserService;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/student-applications")
public class StudentApplicationController {

	private final StudentApplicationService saService;

	@GetMapping("/{id}")
	public ResponseEntity<StudentApplication> read(@PathVariable long id) {
		StudentApplication sa;
		try {
			sa = saService.getsaById(id);
			return ResponseEntity.ok(sa);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping
	public ResponseEntity<List<StudentApplication>> getAll() {
		List<StudentApplication> listSA = saService.getAll();
		return ResponseEntity.ok(listSA);
	}

	@PostMapping
	public ResponseEntity<StudentApplication> create(@RequestBody StudentApplication sa) {
		StudentApplication newSA = saService.add(sa);
		return ResponseEntity.ok(newSA);
	}

	@PutMapping
	public ResponseEntity<StudentApplication> update(@RequestBody StudentApplication sa) {
		var newSA = new StudentApplication();
		if (saService.exist(sa.getId())) {
			newSA = saService.add(sa);
			return ResponseEntity.ok(newSA);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping
	public ResponseEntity<StudentApplication> delete(@RequestBody StudentApplication sa) {
		if (saService.exist(sa.getId())) {
			saService.delete(sa.getId());
			return ResponseEntity.ok(sa);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
