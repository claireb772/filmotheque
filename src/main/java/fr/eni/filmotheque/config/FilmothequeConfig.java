package fr.eni.filmotheque.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.ApplicationScope;

import fr.eni.filmotheque.bo.Genre;
import fr.eni.filmotheque.bo.Participant;
import fr.eni.filmotheque.services.FilmService;
import fr.eni.filmotheque.services.ParticipantService;

@Configuration
public class FilmothequeConfig {

	@Bean
	@ApplicationScope
	public List<Participant> acteurs(ParticipantService participantService) {
		return participantService.getListParticipant();
	}

	@Bean
	@ApplicationScope
	public List<Genre> genres(FilmService filmService) {
		return filmService.getListGenre();
	}

}
