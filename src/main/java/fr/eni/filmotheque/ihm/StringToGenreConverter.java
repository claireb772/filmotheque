package fr.eni.filmotheque.ihm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import fr.eni.filmotheque.bo.Genre;
import fr.eni.filmotheque.services.FilmService;

@Component
public class StringToGenreConverter implements Converter<String, Genre> {

	private FilmService filmService;

	@Autowired
	public StringToGenreConverter(FilmService filmService) {
		this.filmService = filmService;
	}

	@Override
	public Genre convert(String id) {
		Long genreId = Long.parseLong(id);
		return filmService.getGenreById(genreId);
	}

}
