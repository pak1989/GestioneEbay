package it.prova.gestioneebay.dao.annuncio;

import java.util.List;

import it.prova.gestioneebay.dao.IBaseDAO;
import it.prova.gestioneebay.model.Acquisto;
import it.prova.gestioneebay.model.Annuncio;

public interface AnnuncioDAO extends IBaseDAO<Annuncio> {

	public List<Annuncio> findByExample2(Annuncio annuncioInstance);

	public Annuncio getEager(Long id);
	
	public List<Annuncio> listByIdUtente(long id);
	
}
