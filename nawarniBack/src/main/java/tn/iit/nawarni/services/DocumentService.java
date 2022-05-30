package tn.iit.nawarni.services;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import tn.iit.nawarni.entities.Document;
import tn.iit.nawarni.repositories.DocumentRepository;

@RequiredArgsConstructor
@Service
public class DocumentService {

	private final DocumentRepository documentRepository;

	public Document add(Document document) {
		return documentRepository.save(document);
	}

	public List<Document> getAdminDocuments() {
		return documentRepository.findByPath("Admin_Documents");
	}

	public Document saveDocument(MultipartFile multipartFile, String destination) throws IOException {

		Document document = Document.builder().originalName(StringUtils.cleanPath(multipartFile.getOriginalFilename()))
				.type(multipartFile.getContentType()).path(destination).size(multipartFile.getSize()).build();
		FileUploadService.saveFile(document.getOriginalName(), multipartFile, destination);
		return document;
	}

	public Optional<Document> findById(long id) {

		return documentRepository.findById(id);
	}
}