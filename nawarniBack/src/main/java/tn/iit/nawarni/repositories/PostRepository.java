package tn.iit.nawarni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.iit.nawarni.entities.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
