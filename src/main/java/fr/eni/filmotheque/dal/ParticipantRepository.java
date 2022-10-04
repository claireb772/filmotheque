package fr.eni.filmotheque.dal;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.eni.filmotheque.bo.Participant;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {

}
