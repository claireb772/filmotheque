package fr.eni.filmotheque.bo;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class Film {

	private long id;

	@NotBlank(message = "Le titre est obligatoire")
	private String titre;

	@NotNull(message = "L'année est obligatoire")
	private int annee;

	@Min(value = 0, message = "La durée doit être supérieure à zéro")
	private int duree;

	@Length(min = 20, max = 250, message = "Le synopsis doit faire entre 20 et 250 caractères")
	private String synopsis;
	private int idImage;
	private List<Participant> acteurs;

	@NotNull
	private Participant realisateur;
	private Genre genre;

	public Film(long id, @NotBlank(message = "Le titre est obligatoire") String titre, int annee,
			@Min(value = 0, message = "La durée doit être supérieure à zéro") int duree,
			@Length(min = 20, max = 250, message = "Le synopsis doit faire entre 20 et 250 caractères") String synopsis,
			int idImage) {
		super();
		this.id = id;
		this.titre = titre;
		this.annee = annee;
		this.duree = duree;
		this.synopsis = synopsis;
		this.idImage = idImage;
	}

	public Film(@NotBlank(message = "Le titre est obligatoire") String titre, int annee,
			@Min(value = 0, message = "La durée doit être supérieure à zéro") int duree,
			@Length(min = 20, max = 250, message = "Le synopsis doit faire entre 20 et 250 caractères") String synopsis,
			int idImage) {
		super();
		this.titre = titre;
		this.annee = annee;
		this.duree = duree;
		this.synopsis = synopsis;
		this.idImage = idImage;
	}

	public Film(long id, @NotBlank(message = "Le titre est obligatoire") String titre, int annee,
			@Min(value = 0, message = "La durée doit être supérieure à zéro") int duree,
			@Length(min = 20, max = 250, message = "Le synopsis doit faire entre 20 et 250 caractères") String synopsis,
			int idImage, List<Participant> acteurs, Participant realisateur, Genre genre) {
		super();
		this.id = id;
		this.titre = titre;
		this.annee = annee;
		this.duree = duree;
		this.synopsis = synopsis;
		this.idImage = idImage;
		this.acteurs = acteurs;
		this.realisateur = realisateur;
		this.genre = genre;
	}

	public Film() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public int getIdImage() {
		return idImage;
	}

	public void setIdImage(int idImage) {
		this.idImage = idImage;
	}

	public List<Participant> getActeurs() {
		return acteurs;
	}

	public void setActeurs(List<Participant> acteurs) {
		this.acteurs = acteurs;
	}

	public Participant getRealisateur() {
		return realisateur;
	}

	public void setRealisateur(Participant realisateur) {
		this.realisateur = realisateur;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Film [id=" + id + ", titre=" + titre + ", annee=" + annee + ", duree=" + duree + "]";
	}

}
