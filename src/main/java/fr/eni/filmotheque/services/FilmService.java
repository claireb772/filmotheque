package fr.eni.filmotheque.services;

import java.util.List;
import java.util.Map;

import fr.eni.filmotheque.bo.Film;
import fr.eni.filmotheque.bo.Genre;

public interface FilmService {

	public List<Film> getListFilm();

	public Film getFilm(List<Film> films, int id);

	public int getLastFilmId(List<Film> films);

	public List<Genre> getListGenre();

	public Map<Integer, Genre> getMapGenres();

}
