package it.prova.gestioneebay.service.acquisto;

import java.util.List;

import it.prova.gestioneebay.model.Acquisto;
import it.prova.gestioneebay.model.Annuncio;
import it.prova.gestioneebay.model.Utente;

public interface AcquistoService {
	
	public List<Acquisto> listAllAcquisto();

	public Acquisto caricaSingoloAcquisto(long id);

	public void aggiorna(Acquisto acquistoInstance);

	public void inserisciNuovoAcquisto(Acquisto acquistoInstance);

	public void rimuovi(Acquisto acquistoInstance);

	public List<Acquisto> findByExample(Acquisto example);
	
	public void eseguiAcquisto(Utente utente, Annuncio annuncio);

	public List<Acquisto> listByIdUtente(long id);
}
