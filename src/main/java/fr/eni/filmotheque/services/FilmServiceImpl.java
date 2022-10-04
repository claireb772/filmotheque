package fr.eni.filmotheque.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.filmotheque.bo.Film;
import fr.eni.filmotheque.bo.Genre;
import fr.eni.filmotheque.bo.Participant;
import fr.eni.filmotheque.dal.FilmRepository;
import fr.eni.filmotheque.dal.GenreRepository;
import fr.eni.filmotheque.dal.ParticipantRepository;

@Service
public class FilmServiceImpl implements FilmService {

	private List<Film> films;
	private List<Genre> genres;
	private Map<Long, Genre> mapGenres;
	private FilmRepository filmRepository;
	private GenreRepository genreRepository;
	private ParticipantRepository participantRepository;

	@Autowired
	public FilmServiceImpl(FilmRepository filmRepository, GenreRepository genreRepository,
			ParticipantRepository participantRepository) {

		this.filmRepository = filmRepository;
		this.genreRepository = genreRepository;
		this.participantRepository = participantRepository;
	}

	public FilmServiceImpl() {

		genres = new ArrayList<>();
		genres.add(new Genre("Drame"));
		genres.add(new Genre("Comédie"));
		genres.add(new Genre("Science-fiction"));
		genres.add(new Genre("Aventure"));
		genreRepository.saveAll(genres);
		System.out.println("CONSTRUCTEUR");
		mapGenres = new HashMap<Long, Genre>();
		genres.forEach(m -> mapGenres.put((long) m.getId(), m));
	}

//	@Override
//	public List<Film> getListFilm() {
//
//		if (films == null) {
//			films = new ArrayList<Film>();
//			films.add(new Film(1, "Fight Club", 1999, 139,
//					"Insomniaque, désillusionné par sa vie personnelle et professionnelle, un jeune cadre expert en assurances, mène une vie monotone et sans saveur.",
//					1, null, new Participant(1, "Fincher", "David"), new Genre(1, "Drame")));
//			films.add(new Film(2, "Pulp Fiction", 1994, 154,
//					" L'odyssée sanglante, burlesque et cocasse de petits malfrats dans la jungle", 2, null,
//					new Participant(2, "Tarentino", "Quentin"), new Genre(2, "Comedie")));
//			films.add(new Film(3, "Interstellar", 2014, 189,
//					"Alors que la vie sur Terre touche à sa fin, un groupe d’explorateurs s’attelle à la mission la plus importante de l’histoire de l’humanité : franchir les limites de notre galaxie pour savoir si l’homme peut vivre sur une autre planète…",
//					3, null, new Participant(3, "Nolan", "Christopher"), new Genre(2, "Science-fiction")));
//			return films;
//		}
//
//		return films;
//	}

	@Override
	public List<Film> getListFilm() throws SQLException {

		return filmRepository.findAll();
	}

	public void saveFilm() {

		genres = new ArrayList<>();
		genres.add(new Genre("Drame"));
		genres.add(new Genre("Comédie"));
		genres.add(new Genre("Science-fiction"));
		genres.add(new Genre("Aventure"));
		genreRepository.saveAll(genres);
		System.out.println("SAVE FILM");
		Genre genre = genreRepository.findById((long) 1).get();
		List<Participant> listeActeurs = new ArrayList<Participant>();
		listeActeurs.add(new Participant("Pitt", "Brad"));

		participantRepository.saveAll(listeActeurs);
		List<Participant> acteurs = new ArrayList<>();
		Participant participant = participantRepository.findById((long) 5).get();
		acteurs.add(participant);
		System.out.println(acteurs.get(0));
		filmRepository.save(new Film("Fight Club", 1999, 139,
				"Insomniaque, désillusionné par sa vie personnelle et professionnelle, un jeune cadre expert en assurances, mène une vie monotone et sans saveur.",
				1, acteurs, participant, genre));
	}

	@Override
	public void save(Film film) {
		filmRepository.save(film);
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
	public Map<Long, Genre> getMapGenres() {
		return mapGenres;
	}

	@Override
	public Film getFilmById(long id) {
		// TODO Auto-generated method stub
		Optional<Film> film = filmRepository.findById(id);

		return film.get();
	}

}
