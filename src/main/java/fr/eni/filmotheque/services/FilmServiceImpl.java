package fr.eni.filmotheque.services;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.filmotheque.bo.Film;
import fr.eni.filmotheque.bo.Genre;
import fr.eni.filmotheque.dal.FilmRepository;
import fr.eni.filmotheque.dal.GenreRepository;

@Service
public class FilmServiceImpl implements FilmService {

	private FilmRepository filmRepository;
	private GenreRepository genreRepository;

	@Autowired
	public FilmServiceImpl(FilmRepository filmRepository, GenreRepository genreRepository) {

		this.filmRepository = filmRepository;
		this.genreRepository = genreRepository;
	}

	public FilmServiceImpl() {

	}

	@Override
	public List<Film> getListFilm() throws SQLException {
		return filmRepository.findAll();
	}

	@Override
	public void save(Film film) {
		filmRepository.save(film);

	}

	@Override
	public List<Genre> getListGenre() {
		return genreRepository.findAll();
	}

	@Override
	public Film getFilmById(long id) {
		return filmRepository.findById(id).get();
	}

	@Override
	public Genre getGenreById(long id) {
		return genreRepository.findById(id).get();
	}

}
