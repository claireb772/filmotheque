package fr.eni.filmotheque.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import fr.eni.filmotheque.bo.Film;

@Service
public class FilmServiceImpl implements FilmService {

	@Override
	public List<Film> getListFilm() {
		List<Film> films = new ArrayList<>();
		films.add(new Film(1, "Fight Club", 1999, 139,
				"Insomniaque, désillusionné par sa vie personnelle et professionnelle, un jeune cadre expert en assurances, mène une vie monotone et sans saveur."));
		films.add(new Film(2, "Pulp Fiction", 1994, 154,
				" L'odyssée sanglante, burlesque et cocasse de petits malfrats dans la jungle de Hollywood à travers trois histoires qui s'entremêlent."));
		films.add(new Film(3, "Interstellar", 2014, 189,
				"Alors que la vie sur Terre touche à sa fin, un groupe d’explorateurs s’attelle à la mission la plus importante de l’histoire de l’humanité : franchir les limites de notre galaxie pour savoir si l’homme peut vivre sur une autre planète…"));

		return films;
	}

}
