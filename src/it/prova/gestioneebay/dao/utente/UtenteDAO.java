package it.prova.gestioneebay.dao.utente;

import java.util.List;

import it.prova.gestioneebay.dao.IBaseDAO;
import it.prova.gestioneebay.model.Utente;

public interface UtenteDAO extends IBaseDAO<Utente> {
	
	public Utente executeLogin(String username, String password);
	
	public List<Utente> findByAllByAttribute(Utente utenteInstance);

}
