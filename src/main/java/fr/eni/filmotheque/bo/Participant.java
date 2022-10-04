package fr.eni.filmotheque.bo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Participant {

	@Id
	@GeneratedValue
	private long id;
	private String nom;
	private String prenom;

	@ManyToMany(mappedBy = "acteurs")
	private List<Film> films;

	public Participant() {
		super();
	}

	public Participant(long id, String nom, String prenom) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
	}

	public Participant(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public List<Film> getFilms() {
		return films;
	}

	public void setFilms(List<Film> films) {
		this.films = films;
	}

}
