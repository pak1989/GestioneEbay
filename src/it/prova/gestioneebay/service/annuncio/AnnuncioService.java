package it.prova.gestioneebay.service.annuncio;

import java.util.List;

import it.prova.gestioneebay.model.Annuncio;

public interface AnnuncioService {
	
	public List<Annuncio> listAllAnnuncio();

	public Annuncio caricaSingoloAnnuncio(long id);

	public Annuncio caricaSingoloAnnuncioEager(long id);

	public void aggiorna(Annuncio annuncioInstance);

	public void inserisciNuovoAnnuncio(Annuncio annuncioInstance);

	public void rimuovi(Annuncio annuncioInstance);

	public List<Annuncio> findByExample(Annuncio example);
	
	public List<Annuncio> findByExample2(Annuncio annuncioInstance);
	
	public List<Annuncio> listByIdUtente(long id);

}
