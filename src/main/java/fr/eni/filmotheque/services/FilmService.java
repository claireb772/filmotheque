package fr.eni.filmotheque.services;

import java.util.List;

import fr.eni.filmotheque.bo.Film;

public interface FilmService {

	public List<Film> getListFilm();

	public Film getFilm(List<Film> films, int id);

	public int getLastFilmId(List<Film> films);

}
