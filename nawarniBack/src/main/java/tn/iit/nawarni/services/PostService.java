package tn.iit.nawarni.services;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import tn.iit.nawarni.entities.Post;
import tn.iit.nawarni.repositories.PostRepository;

@RequiredArgsConstructor
@Service
public class PostService {

	private final PostRepository postRepository;

	public Post getPostById(long id) throws Exception {
		return postRepository.findById(id).orElseThrow(() -> new Exception("Post not found or deleted"));
	}

	public Post add(Post post) {
		return postRepository.save(post);
	}

	public List<Post> getAll() {
		return postRepository.findAll();
	}

	public boolean exist(long id) {
		return postRepository.existsById(id);
	}

	public void delete(long id) {
		postRepository.deleteById(id);
	}
}
