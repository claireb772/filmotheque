package fr.eni.filmotheque.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import fr.eni.filmotheque.bo.Film;
import fr.eni.filmotheque.bo.Genre;

@Service
public class FilmServiceImpl implements FilmService {

	private List<Film> films;
	private List<Genre> genres;
	private Map<Integer, Genre> mapGenres;

	public FilmServiceImpl() {
		genres = new ArrayList<>();
		genres.add(new Genre(1, "Drame"));
		genres.add(new Genre(2, "Comédie"));
		genres.add(new Genre(3, "Science-fiction"));
		genres.add(new Genre(4, "Aventure"));

		mapGenres = new HashMap<Integer, Genre>();
		genres.forEach(m -> mapGenres.put((int) m.getId(), m));
	}

	@Override
	public List<Film> getListFilm() {

		if (films == null) {
			films = new ArrayList<Film>();
			films.add(new Film(1, "Fight Club", 1999, 139,
					"Insomniaque, désillusionné par sa vie personnelle et professionnelle, un jeune cadre expert en assurances, mène une vie monotone et sans saveur.",
					1));
			films.add(new Film(2, "Pulp Fiction", 1994, 154,
					" L'odyssée sanglante, burlesque et cocasse de petits malfrats dans la jungle de Hollywood à travers trois histoires qui s'entremêlent.",
					2));
			films.add(new Film(3, "Interstellar", 2014, 189,
					"Alors que la vie sur Terre touche à sa fin, un groupe d’explorateurs s’attelle à la mission la plus importante de l’histoire de l’humanité : franchir les limites de notre galaxie pour savoir si l’homme peut vivre sur une autre planète…",
					3));
			return films;
		}

		return films;
	}

	@Override
	public Film getFilm(List<Film> films, int id) {

		Film film = null;

		for (Film f : films) {
			if (f.getId() == id) {
				film = f;
			}
		}

		return film;
	}

	@Override
	public int getLastFilmId(List<Film> films) {

		int id = 0;

		Film film = films.get(films.size() - 1);
		id = (int) film.getId();

		return id;
	}

	@Override
	public List<Genre> getListGenre() {
		return genres;
	}

	@Override
	public Map<Integer, Genre> getMapGenres() {
		return mapGenres;
	}

}
