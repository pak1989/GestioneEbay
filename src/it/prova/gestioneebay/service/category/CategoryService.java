package it.prova.gestioneebay.service.category;

import java.util.List;

import it.prova.gestioneebay.model.Category;

public interface CategoryService {
	
	public List<Category> listAllCategory();

	public Category caricaSingoloCategory(long id);

	public void aggiorna(Category categoryInstance);

	public void inserisciNuovoCategory(Category categoryInstance);

	public void rimuovi(Category categoryInstance);

	public List<Category> findByExample(Category example);

}
