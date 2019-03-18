package it.prova.gestioneebay.service.ruolo;

import java.util.List;

import it.prova.gestioneebay.model.Ruolo;

public interface RuoloService {
	
	public List<Ruolo> listAllRuoli();

	public Ruolo caricaSingoloRuolo(long id);

	public void aggiorna(Ruolo ruoloInstance);

	public void inserisciNuovoRuolo(Ruolo ruoloInstance);

	public void rimuovi(Ruolo ruoloInstance);

	public List<Ruolo> findByExample(Ruolo example);

}
