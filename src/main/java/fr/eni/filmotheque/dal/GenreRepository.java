package fr.eni.filmotheque.dal;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.eni.filmotheque.bo.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {

}
