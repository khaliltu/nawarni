package tn.iit.nawarni.services;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import tn.iit.nawarni.entities.Document;
import tn.iit.nawarni.entities.Notification;
import tn.iit.nawarni.entities.Post;
import tn.iit.nawarni.entities.StudentApplication;
import tn.iit.nawarni.repositories.NotificationRepository;

@RequiredArgsConstructor
@Service
public class NotificationService {

	private final NotificationRepository notificationRepository;

	public Notification getNotificationById(long id) throws Exception {
		return notificationRepository.findById(id).orElseThrow(() -> new Exception("Notification not found"));
	}

	public Notification add(Notification notif, Document document) {
		notif.setDocument(document);
		notif.setText("PCP Departement has added a new file named:  " + document.getName());
		return notificationRepository.save(notif);
	}
	
	public Notification add(Notification notif, Post post) {
		notif.setPost(post);
		notif.setText(post.getUser().getFirstName()+"has a new post");
		return notificationRepository.save(notif);
	}
	
	public Notification add(Notification notif, StudentApplication studentApplication) {
		notif.setStudentApplication(studentApplication);
		notif.setText(studentApplication.getUser().getFirstName()
				+" "
				+ studentApplication.getUser().getLastName()
				+" "
				+ "a appliqué à votre stage "
				+ studentApplication.getPost().getDescription());
		return notificationRepository.save(notif);
	}

	public boolean exist(long id) {
		return notificationRepository.existsById(id);
	}
	
	public List<Notification> getAll() {
		return notificationRepository.findAll();
	}

	public Notification create() {
		ZoneId defaultZoneId = ZoneId.systemDefault();
		LocalDate ld= LocalDate.now();
		Date date= Date.from(ld.atStartOfDay(defaultZoneId).toInstant());
		Notification notif = Notification.builder().date(date).build();
		return notif;
	}
	public void delete(long id) {
		notificationRepository.deleteById(id);
	}
}
