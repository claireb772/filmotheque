package fr.eni.filmotheque.bo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Genre {

	@Id
	@GeneratedValue
	private long id;
	private String libelle;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "genre")
	private List<Film> films;

	public Genre() {
	}

	public Genre(String libelle) {
		super();
		this.libelle = libelle;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

}
