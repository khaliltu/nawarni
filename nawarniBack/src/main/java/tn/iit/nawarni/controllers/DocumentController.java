package tn.iit.nawarni.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import lombok.val;
import lombok.var;
import tn.iit.nawarni.entities.Document;
import tn.iit.nawarni.entities.Notification;
import tn.iit.nawarni.services.DocumentService;
import tn.iit.nawarni.services.NotificationService;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/documents")
public class DocumentController {

	private final NotificationService notificationService;
	private final DocumentService documentService;

	@GetMapping("admin-documents")
	public ResponseEntity<List<Document>> getDocuments() {
		List<Document> list = documentService.getAdminDocuments();
		return ResponseEntity.ok(list);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Document> getAdminDocument(@PathVariable("id") long id) {
		var document = documentService.findById(id);
		return ResponseEntity.of(document);
	}

	@PostMapping
	public ResponseEntity<Document> uploadFile(@RequestBody MultipartFile multipartFile) throws IOException {
		val destination = "Admin_Documents";
		Document document = documentService.saveDocument(multipartFile, destination);
		documentService.add(document);
		Notification notif = notificationService.create();
		notificationService.add(notif, document);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("/upload-cv")
	public ResponseEntity<Document> uploadCv(@RequestBody MultipartFile multipartFile) throws IOException {
		val destination = "Student_Documents";
		Document document = documentService.saveDocument(multipartFile, destination);
		documentService.add(document);

		return new ResponseEntity<>(HttpStatus.OK);
	}

}