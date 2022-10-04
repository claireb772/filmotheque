package fr.eni.filmotheque.bo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity()
public class Film {

	@Id
	@GeneratedValue
	private long id;

	@NotBlank(message = "Le titre est obligatoire")
	private String titre;

	@NotNull(message = "L'année est obligatoire")
	private int annee;

	@Min(value = 0, message = "La durée doit être supérieure à zéro")
	private int duree;

	@Length(min = 20, max = 250, message = "Le synopsis doit faire entre 20 et 250 caractères")
	private String synopsis;

	private int image;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "FilmParticipant", joinColumns = { @JoinColumn(name = "film_id") }, inverseJoinColumns = {
			@JoinColumn(name = "participant_id") })
	private List<Participant> acteurs;

	// @NotNull
	@ManyToOne
	private Participant realisateur;

	@ManyToOne
	private Genre genre;

	public Film(@NotBlank(message = "Le titre est obligatoire") String titre, int annee,
			@Min(value = 0, message = "La durée doit être supérieure à zéro") int duree,
			@Length(min = 20, max = 250, message = "Le synopsis doit faire entre 20 et 250 caractères") String synopsis,
			int image) {
		super();
		this.titre = titre;
		this.annee = annee;
		this.duree = duree;
		this.synopsis = synopsis;
		this.image = image;
	}

	public Film(@NotBlank(message = "Le titre est obligatoire") String titre, int annee,
			@Min(value = 0, message = "La durée doit être supérieure à zéro") int duree,
			@Length(min = 20, max = 250, message = "Le synopsis doit faire entre 20 et 250 caractères") String synopsis,
			int image, List<Participant> acteurs, Participant realisateur, Genre genre) {
		super();
		this.titre = titre;
		this.annee = annee;
		this.duree = duree;
		this.synopsis = synopsis;
		this.image = image;
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

	public int getImage() {
		return image;
	}

	public void setImage(int image) {
		this.image = image;
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
