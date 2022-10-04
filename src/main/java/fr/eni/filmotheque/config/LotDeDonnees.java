package fr.eni.filmotheque.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import fr.eni.filmotheque.bo.Film;
import fr.eni.filmotheque.bo.Genre;
import fr.eni.filmotheque.bo.Participant;
import fr.eni.filmotheque.bo.User;
import fr.eni.filmotheque.dal.FilmRepository;
import fr.eni.filmotheque.dal.GenreRepository;
import fr.eni.filmotheque.dal.ParticipantRepository;
import fr.eni.filmotheque.dal.UserRepository;

@Configuration
public class LotDeDonnees {

	@Bean
	public CommandLineRunner initLotDeDonnees(FilmRepository filmRepository, GenreRepository genreRepository,
			ParticipantRepository participantRepository, UserRepository userRepository,
			PasswordEncoder passwordEncoder) {
		return (args) -> {

			User user = new User("nom", "prenom", "admin", passwordEncoder().encode("admin"), true);
			userRepository.save(user);

			List<Genre> genres = new ArrayList<>();

			genres.add(new Genre("Drame"));
			genres.add(new Genre("Comédie"));
			genres.add(new Genre("Science-fiction"));
			genres.add(new Genre("Aventure"));
			genreRepository.saveAll(genres);

			List<Participant> participants = new ArrayList<>();

			participants.add(new Participant("Linch", "David"));
			participants.add(new Participant("Pitt", "Brad"));
			participants.add(new Participant("Norton", "Edouard"));
			participants.add(new Participant("Tarentino", "Quentin"));
			participants.add(new Participant("Thurman", "Uma"));
			participants.add(new Participant("Travolta", "John"));
			participants.add(new Participant("Nolan", "Christopher"));
			participants.add(new Participant("McConaughey", "Matthew"));
			participants.add(new Participant("Chastain", "Jessica"));
			participants.add(new Participant("Hattaway", "Anne"));

			participantRepository.saveAll(participants);

			List<Participant> participantFilm1 = new ArrayList<>();
			participantFilm1.add(participants.get(1));
			participantFilm1.add(participants.get(2));

			Film film1 = new Film("Fight Club", 1999, 139,
					"Insomniaque, désillusionné par sa vie personnelle et professionnelle, un jeune cadre expert en assurances, mène une vie monotone et sans saveur.",
					1);
			film1.setActeurs(participantFilm1);
			film1.setRealisateur(participants.get(0));
			film1.setGenre(genres.get(0));
			filmRepository.save(film1);

			Film film2 = new Film("Pulp Fiction", 1994, 154,
					" L'odyssée sanglante, burlesque et cocasse de petits malfrats dans la jungle", 2);
			List<Participant> participantFilm2 = new ArrayList<>();
			participantFilm2.add(participants.get(4));
			participantFilm2.add(participants.get(5));
			film2.setActeurs(participantFilm2);
			film2.setRealisateur(participants.get(3));
			film2.setGenre(genres.get(1));
			filmRepository.save(film2);

			Film film3 = new Film("Interstellar", 2014, 189,
					"Alors que la vie sur Terre touche à sa fin, un groupe d’explorateurs s’attelle à la mission la plus importante de l’histoire de l’humanité : franchir les limites de notre galaxie pour savoir si l’homme peut vivre sur une autre planète…",
					3);
			List<Participant> participantFilm3 = new ArrayList<>();
			participantFilm3.add(participants.get(7));
			participantFilm3.add(participants.get(8));
			participantFilm3.add(participants.get(9));
			film3.setActeurs(participantFilm3);
			film3.setRealisateur(participants.get(6));
			film3.setGenre(genres.get(2));
			filmRepository.save(film3);

		};

	}

	private PasswordEncoder passwordEncoder() {
		// TODO Auto-generated method stub
		return new BCryptPasswordEncoder();
	}

}
