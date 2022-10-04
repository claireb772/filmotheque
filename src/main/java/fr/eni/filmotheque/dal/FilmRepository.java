package fr.eni.filmotheque.dal;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.eni.filmotheque.bo.Film;

public interface FilmRepository extends JpaRepository<Film, Long> {

}
