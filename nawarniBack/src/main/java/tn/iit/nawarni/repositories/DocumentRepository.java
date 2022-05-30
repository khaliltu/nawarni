package tn.iit.nawarni.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.iit.nawarni.entities.Document;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {

	List<Document> findByPath(String path);
}