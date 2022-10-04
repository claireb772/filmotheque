package fr.eni.filmotheque.dal;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.eni.filmotheque.bo.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String login);

}
