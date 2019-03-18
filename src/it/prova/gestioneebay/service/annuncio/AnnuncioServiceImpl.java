package it.prova.gestioneebay.service.annuncio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import it.prova.gestioneebay.dao.annuncio.AnnuncioDAO;
import it.prova.gestioneebay.model.Annuncio;

@Component
public class AnnuncioServiceImpl implements AnnuncioService {
	@Autowired
	private AnnuncioDAO annuncioDAO;

	// @Autowired
	// private UtenteDAO utenteDAO;

	@Transactional(readOnly = true)
	public List<Annuncio> listAllAnnuncio() {
		return annuncioDAO.list();
	}

	@Transactional(readOnly = true)
	public Annuncio caricaSingoloAnnuncio(long id) {
		return annuncioDAO.get(id);
	}

	public Annuncio caricaSingoloAnnuncioEager(long id) {
		return annuncioDAO.getEager(id);
	}

	@Transactional
	public void aggiorna(Annuncio annuncioInstance) {
		annuncioDAO.update(annuncioInstance);
	}

	@Transactional
	public void inserisciNuovoAnnuncio(Annuncio annuncioInstance) {
		annuncioDAO.insert(annuncioInstance);
	}

	@Transactional
	public void rimuovi(Annuncio annuncioInstance) {
		annuncioDAO.delete(annuncioInstance);
	}

	@Transactional(readOnly = true)
	public List<Annuncio> findByExample(Annuncio example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional(readOnly = true)
	public List<Annuncio> findByExample2(Annuncio annuncioInstance) {
		return annuncioDAO.findByExample2(annuncioInstance);
	}

	@Transactional(readOnly = true)
	public List<Annuncio> listByIdUtente(long id) {
		return annuncioDAO.listByIdUtente(id);
	}

}
