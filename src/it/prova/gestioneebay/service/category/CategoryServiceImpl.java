package it.prova.gestioneebay.service.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import it.prova.gestioneebay.dao.category.CategoryDAO;
import it.prova.gestioneebay.model.Category;
@Component
public class CategoryServiceImpl implements CategoryService {
	
//	@Autowired
//	private AnnuncioDAO annuncioDAO;
	
	@Autowired
	private CategoryDAO categoryDAO;

	@Transactional(readOnly=true)
	public List<Category> listAllCategory() {
		return categoryDAO.list();
	}

	@Transactional(readOnly=true)
	public Category caricaSingoloCategory(long id) {
		return categoryDAO.get(id);
	}

	@Transactional
	public void aggiorna(Category categoryInstance) {
		// TODO Auto-generated method stub

	}

	@Transactional
	public void inserisciNuovoCategory(Category categoryInstance) {
		// TODO Auto-generated method stub

	}

	@Transactional
	public void rimuovi(Category categoryInstance) {
		// TODO Auto-generated method stub

	}

	@Transactional(readOnly=true)
	public List<Category> findByExample(Category example) {
		// TODO Auto-generated method stub
		return null;
	}

}
