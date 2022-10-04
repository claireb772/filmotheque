package fr.eni.filmotheque.dal;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.eni.filmotheque.bo.Avis;

public interface AvisRepository extends JpaRepository<Avis, Long> {

}
