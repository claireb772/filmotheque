package fr.eni.filmotheque.ihm;

import java.sql.SQLException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.eni.filmotheque.bo.Film;
import fr.eni.filmotheque.services.FilmService;

@Controller
public class FilmController {

	private FilmService filmService;

	@Autowired
	public FilmController(FilmService filmService) {
		this.filmService = filmService;
	}

	@RequestMapping({ "/", "", "/accueil" })
	public String films(Model model) throws SQLException {

		List<Film> films = filmService.getListFilm();

		model.addAttribute("films", films);

		return "accueil";
	}

	@GetMapping("/detail/{id}")
	public String getDetail(@PathVariable int id, Model model) throws SQLException {

		Film film = filmService.getFilmById(id);
		model.addAttribute("film", film);

		return "detail";
	}

	@GetMapping({ "/ajouter" })
	public String formFilm(Model modele, FilmService filmService) {

		Film film = new Film();

		modele.addAttribute("film", film);

		return "ajout";
	}

	@PostMapping({ "/ajouter" })
	public String addFilm(@Valid @ModelAttribute("film") Film film, BindingResult validationResult, Model model)
			throws SQLException {

		if (validationResult.hasErrors()) {
			return "ajout";
		}

		filmService.save(film);

		return "redirect:/accueil";
	}

}
