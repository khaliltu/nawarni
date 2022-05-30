package tn.iit.nawarni.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import tn.iit.nawarni.entities.Notification;
import tn.iit.nawarni.services.NotificationService;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/notifications")
public class NotificationController {

	private final NotificationService notificationService;

	@GetMapping("/{id}")
	public ResponseEntity<Notification> read(@PathVariable long id) {
		Notification notif;
		try {
			notif = notificationService.getNotificationById(id);
			return ResponseEntity.ok(notif);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping
	public ResponseEntity<List<Notification>> getAll() {
		List<Notification> listNotif = notificationService.getAll();
		return ResponseEntity.ok(listNotif);
	}

	@DeleteMapping
	public ResponseEntity<Notification> delete(@RequestBody Notification notif) {
		if (notificationService.exist(notif.getId())) {
			notificationService.delete(notif.getId());
			return ResponseEntity.ok(notif);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
