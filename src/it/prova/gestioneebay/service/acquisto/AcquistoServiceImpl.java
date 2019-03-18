package it.prova.gestioneebay.service.acquisto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import it.prova.gestioneebay.dao.acquisto.AcquistoDAO;
import it.prova.gestioneebay.dao.annuncio.AnnuncioDAO;
import it.prova.gestioneebay.dao.utente.UtenteDAO;
import it.prova.gestioneebay.model.Acquisto;
import it.prova.gestioneebay.model.Annuncio;
import it.prova.gestioneebay.model.Utente;

@Component
public class AcquistoServiceImpl implements AcquistoService {
	
	@Autowired
	private AcquistoDAO acquistoDAO;
	
	@Autowired
	private UtenteDAO utenteDAO;

	@Autowired
	private AnnuncioDAO annuncioDAO;

	@Transactional(readOnly=true)
	public List<Acquisto> listAllAcquisto() {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional(readOnly=true)
	public Acquisto caricaSingoloAcquisto(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public void aggiorna(Acquisto acquistoInstance) {
		// TODO Auto-generated method stub

	}

	@Transactional
	public void inserisciNuovoAcquisto(Acquisto acquistoInstance) {
		// TODO Auto-generated method stub

	}

	@Transactional
	public void rimuovi(Acquisto acquistoInstance) {
		// TODO Auto-generated method stub

	}

	@Transactional(readOnly=true)
	public List<Acquisto> findByExample(Acquisto example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public void eseguiAcquisto(Utente utente, Annuncio annuncio) {
		
		Acquisto acquisto = new Acquisto();
		
		acquisto.setAnno(2019);
		acquisto.setDescrizioneAcquisto(annuncio.getTestoAnnuncio());
		acquisto.setPrezzo(annuncio.getPrezzo());
		acquisto.setUtente(utente);
		
		acquistoDAO.insert(acquisto);
		
		int creditoUtente = utente.getCreditoResiduo();
		int prezzoAnnuncio = annuncio.getPrezzo();
		
		utente.setCreditoResiduo(creditoUtente - prezzoAnnuncio);
	
		utenteDAO.update(utente);
		
		annuncio.setAperto(false);
		
		annuncioDAO.update(annuncio);
	}
	
	@Override
	public List<Acquisto> listByIdUtente(long id) {
		return acquistoDAO.listByIdUtente(id);
	}
}
