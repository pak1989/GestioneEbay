package it.prova.gestioneebay.dao.annuncio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import it.prova.gestioneebay.model.Annuncio;
import it.prova.gestioneebay.model.Category;

@Component
public class AnnuncioDAOImpl implements AnnuncioDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Annuncio> list() {
		return entityManager.createQuery("from Annuncio").getResultList();
	}

	@Override
	public Annuncio get(long id) {
		Annuncio result = (Annuncio) entityManager.find(Annuncio.class, id);
		return result;
	}

	@Override
	public void update(Annuncio annuncioInstance) {
		annuncioInstance = entityManager.merge(annuncioInstance);
	}

	@Override
	public void insert(Annuncio annuncioInstance) {
		entityManager.persist(annuncioInstance);
	}

	@Override
	public void delete(Annuncio annuncioInstance) {
		 entityManager.remove(entityManager.merge(annuncioInstance));
	}

	@Override
	public List<Annuncio> findByExample(Annuncio annuncioInstance) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Annuncio> findByExample2(Annuncio annuncioInstance) {
		Query query;
		String domandaAlDb = "SELECT DISTINCT a FROM Annuncio a LEFT JOIN FETCH a.category c WHERE a.aperto = 1";

		if (StringUtils.isNotEmpty(annuncioInstance.getTestoAnnuncio())) {
			domandaAlDb += " AND a.testoAnnuncio LIKE '" + annuncioInstance.getTestoAnnuncio() + "'";
		}
		if (StringUtils.isNotEmpty(annuncioInstance.getPrezzo() + "".trim())) {
			domandaAlDb += " AND a.prezzo > '" + annuncioInstance.getPrezzo() + "'";
		}

		List<Long> ids = new ArrayList<Long>();
		if (!annuncioInstance.getCategory().isEmpty()) {
			for (Category categoryItem : annuncioInstance.getCategory()) {
				ids.add(categoryItem.getId());
			}
			domandaAlDb += " AND c.id IN :idCategory ";
		}
		query = entityManager.createQuery(domandaAlDb);

		if (!ids.isEmpty())
			query.setParameter("idCategory", ids);

		return (List<Annuncio>) query.getResultList();
	}

	@Override
	public Annuncio getEager(Long id) {
		return (Annuncio) entityManager
				.createQuery("SELECT DISTINCT a FROM Annuncio a JOIN FETCH a.utente WHERE a.id = :id")
				.setParameter("id", id).getSingleResult();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Annuncio> listByIdUtente(long id) {
		return (List<Annuncio>) entityManager.createQuery("SELECT a FROM Annuncio a WHERE a.utente.id = :id")
				.setParameter("id", id).getResultList();
	}

}
