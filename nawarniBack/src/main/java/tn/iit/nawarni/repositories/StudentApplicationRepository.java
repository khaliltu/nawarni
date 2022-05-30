
package tn.iit.nawarni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.iit.nawarni.entities.StudentApplication;

@Repository
public interface StudentApplicationRepository extends JpaRepository<StudentApplication, Long> {

}
