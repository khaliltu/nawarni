package tn.iit.nawarni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.iit.nawarni.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}