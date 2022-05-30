
package tn.iit.nawarni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.iit.nawarni.entities.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

}
