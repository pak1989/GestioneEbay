package it.prova.gestioneebay.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Annuncio implements Serializable {
	private static final long serialVersionUID = 4000618329909480037L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private boolean aperto;
	private String testoAnnuncio;
	private int prezzo;
	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.MERGE })
	@JoinTable(name = "annuncio_category", joinColumns = @JoinColumn(name = "annuncio_id", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "ID"))
	private Set<Category> category = new HashSet<>(0);
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "utente_id", nullable = true)
	private Utente utente;

	public Annuncio() {
	}

	public Annuncio(boolean aperto, String testoAnnuncio, int prezzo, Set<Category> category) {
		super();
		this.aperto = aperto;
		this.testoAnnuncio = testoAnnuncio;
		this.prezzo = prezzo;
		this.category = category;
	}

	public Annuncio(String testoAnnuncio, int prezzo) {
		super();
		this.testoAnnuncio = testoAnnuncio;
		this.prezzo = prezzo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isAperto() {
		return aperto;
	}

	public void setAperto(boolean aperto) {
		this.aperto = aperto;
	}

	public String getTestoAnnuncio() {
		return testoAnnuncio;
	}

	public void setTestoAnnuncio(String testoAnnuncio) {
		this.testoAnnuncio = testoAnnuncio;
	}

	public int getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(int prezzo) {
		this.prezzo = prezzo;
	}

	public Set<Category> getCategory() {
		return category;
	}

	public void setCategory(Set<Category> category) {
		this.category = category;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

}
