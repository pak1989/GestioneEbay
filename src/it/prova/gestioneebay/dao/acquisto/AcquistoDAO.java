package it.prova.gestioneebay.dao.acquisto;

import java.util.List;

import it.prova.gestioneebay.dao.IBaseDAO;
import it.prova.gestioneebay.model.Acquisto;

public interface AcquistoDAO extends IBaseDAO<Acquisto> {
	
	public List<Acquisto> listByIdUtente(long id);

}
