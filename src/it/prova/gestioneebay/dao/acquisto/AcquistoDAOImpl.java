package it.prova.gestioneebay.dao.acquisto;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Query;
import org.springframework.stereotype.Component;

import it.prova.gestioneebay.model.Acquisto;

@Component
public class AcquistoDAOImpl implements AcquistoDAO {
	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Acquisto> list() {
		// return entityManager.createQuery("from Acquisto").getResultList();
		return null;
	}

	@Override
	public Acquisto get(long id) {
		// Acquisto result = (Acquisto) entityManager.find(Acquisto.class, id);
		// return result;
		return null;
	}

	@Override
	public void update(Acquisto acquistoInstance) {
		// acquistoInstance = entityManager.merge(acquistoInstance);
	}

	@Override
	public void insert(Acquisto acquistoInstance) {
		entityManager.persist(acquistoInstance);
	}

	@Override
	public void delete(Acquisto acquistoInstance) {
		// entityManager.remove(entityManager.merge(acquistoInstance));
	}

	@Override
	public List<Acquisto> findByExample(Acquisto acquistoInstance) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Acquisto> listByIdUtente(long id) {
		return (List<Acquisto>) entityManager.createQuery("SELECT a FROM Acquisto a WHERE a.utente.id = :id")
				.setParameter("id", id).getResultList();
	}

}
