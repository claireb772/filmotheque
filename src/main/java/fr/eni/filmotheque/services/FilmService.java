package fr.eni.filmotheque.services;

import java.sql.SQLException;
import java.util.List;

import fr.eni.filmotheque.bo.Film;
import fr.eni.filmotheque.bo.Genre;

public interface FilmService {

	public List<Film> getListFilm() throws SQLException;

	public List<Genre> getListGenre();

	public Film getFilmById(long id);

	void save(Film film);

	public Genre getGenreById(long id);

}
