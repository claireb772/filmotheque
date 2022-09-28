package fr.eni.filmotheque.ihm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import fr.eni.filmotheque.bo.Film;
import fr.eni.filmotheque.services.FilmService;

@Controller
public class FilmController {

	private FilmService filmService;

	@Autowired
	public FilmController(FilmService filmService) {
		this.filmService = filmService;
	}

	@GetMapping({ "/", "/accueil" })
	public String films(Model model) {

		List<Film> films = filmService.getListFilm();

		model.addAttribute("films", films);

		return "accueil";
	}

	@GetMapping("/detail/{id}")
	public String getDetail(@PathVariable int id, Model model) {

		return "detail";
	}

}
