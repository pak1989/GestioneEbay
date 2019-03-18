package it.prova.gestioneebay.service.utente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import it.prova.gestioneebay.dao.utente.UtenteDAO;
import it.prova.gestioneebay.model.Utente;

@Component
public class UtenteServiceImpl implements UtenteService {
	
	@Autowired
	private UtenteDAO utenteDAO;
	
//	@Autowired
//	private RuoloDAO ruoloDAO;
//	
//	@Autowired
//	private AcquistoDAO acquistoDAO;
//	
//	@Autowired
//	private AnnuncioDAO annuncioDAO;
	

	@Transactional(readOnly=true)
	public List<Utente> listAllUtenti() {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional(readOnly=true)
	public Utente caricaSingoloUtente(long id) {
		return utenteDAO.get(id);
	}

	@Transactional
	public void aggiorna(Utente utenteInstance) {
		utenteDAO.update(utenteInstance);

	}

	@Transactional
	public void inserisciNuovo(Utente utenteInstance) {
		utenteDAO.insert(utenteInstance);
	}

	@Transactional
	public void rimuovi(Utente utenteInstance) {
		utenteDAO.delete(utenteInstance);
	}

	@Transactional(readOnly=true)
	public List<Utente> findByExample(Utente example) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Transactional(readOnly=true)
	public Utente eseguiAccesso(String username, String password) {
		return utenteDAO.executeLogin(username, password);
	}

	@Override
	public List<Utente> findByAttributes(Utente example) {
		return utenteDAO.findByAllByAttribute(example);
	}
}
