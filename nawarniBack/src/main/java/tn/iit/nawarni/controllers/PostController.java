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
import tn.iit.nawarni.entities.Notification;
import tn.iit.nawarni.entities.Post;
import tn.iit.nawarni.services.NotificationService;
import tn.iit.nawarni.services.PostService;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/posts")
public class PostController {

	private final NotificationService notificationService;
	private final PostService postService;

	@GetMapping("/{id}")
	public ResponseEntity<Post> read(@PathVariable long id) {
		Post post;
		try {
			post = postService.getPostById(id);
			return ResponseEntity.ok(post);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping
	public ResponseEntity<List<Post>> getAll() {
		List<Post> listPosts = postService.getAll();
		return ResponseEntity.ok(listPosts);
	}

	@PostMapping
	public ResponseEntity<Post> create(@RequestBody Post post) {
		Post newPost = postService.add(post);
		Notification notif = notificationService.create();
		notificationService.add(notif, post);
		return ResponseEntity.ok(newPost);
	}

	@PutMapping
	public ResponseEntity<Post> update(@RequestBody Post post) {
		var newPost = new Post();
		if (postService.exist(post.getId())) {
			newPost = postService.add(post);
			return ResponseEntity.ok(newPost);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping
	public ResponseEntity<Post> delete(@RequestBody Post post) {
		if (postService.exist(post.getId())) {
			postService.delete(post.getId());
			return ResponseEntity.ok(post);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
