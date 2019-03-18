package it.prova.gestioneebay.web.dto.annuncio;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import it.prova.gestioneebay.model.Category;
import it.prova.gestioneebay.model.Utente;

public class AnnuncioDTO {
	private long id;
	private boolean apertoChiuso;
	private String testoAnnuncio;
	private int prezzo;
	private Set<Category> category = new HashSet<>(0);
	private Utente utente;

	public AnnuncioDTO(long id, boolean apertoChiuso, String testoAnnuncio, int prezzo, Set<Category> category,
			Utente utente) {
		super();
		this.id = id;
		this.apertoChiuso = apertoChiuso;
		this.testoAnnuncio = testoAnnuncio;
		this.prezzo = prezzo;
		this.category = category;
		this.utente = utente;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isApertoChiuso() {
		return apertoChiuso;
	}

	public void setApertoChiuso(boolean apertoChiuso) {
		this.apertoChiuso = apertoChiuso;
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

	public List<String> validate() {

		List<String> messagesList = new ArrayList<String>();

		if (StringUtils.isEmpty(testoAnnuncio) || StringUtils.isEmpty(prezzo + "")) {
			messagesList.add("E' necessario riempire tutti i campi!");
		}

		// if (!nome.matches("[A-Za-z]+") || !cognome.matches("[A-Za-z]+")) {
		// messagesList.add("I campi nome e cognome devono contenere solo caratteri
		// alfabetici!");
		// }
		return messagesList;
	}
}
