package it.prova.gestioneebay.dao.category;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import it.prova.gestioneebay.model.Category;

@Component
public class CategoryDAOImpl implements CategoryDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> list() {
		return entityManager.createQuery("from Category").getResultList();
	}

	@Override
	public Category get(long id) {
		Category result = (Category) entityManager.find(Category.class, id);
		return result;
	}

	@Override
	public void update(Category o) {
		// TODO Auto-generated method stub

	}

	@Override
	public void insert(Category o) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Category o) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Category> findByExample(Category o) {
		// TODO Auto-generated method stub
		return null;
	}

}
