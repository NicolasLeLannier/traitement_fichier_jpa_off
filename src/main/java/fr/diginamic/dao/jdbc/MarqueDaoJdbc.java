/**
 * 
 */
package fr.diginamic.dao.jdbc;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.diginamic.dao.MarqueDao;
import fr.diginamic.entite.Marque;

/**
 * @author lelan
 *
 */
public class MarqueDaoJdbc implements MarqueDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("open-food-facts");
	EntityManager em = entityManagerFactory.createEntityManager();
	EntityTransaction transaction = em.getTransaction();

	// ----------------------------------------------- SELECT -----------------------------------------
	@Override
	public List<Marque> extraire() {		
		transaction.begin();
		
		TypedQuery<Marque> marqSelect = em.createQuery("SELECT m FROM Marque m", Marque.class);
		List<Marque> listMarque = marqSelect.getResultList();
		
		transaction.commit();
		em.close();

		return listMarque;
	}

	// ----------------------------------------------- INSERT -----------------------------------------
	@Override
	public void insert(Marque marque) {
		transaction.begin();
		Marque marqueNom = new Marque();
		
		String[] tokensMarque = marque.getNom().split(",");
		
		for(String tm : tokensMarque) {
			
			// Test si la marque existe déjà
			TypedQuery<Marque> marqSelect = em.createQuery("SELECT m FROM Marque m WHERE m.nom=:param1", Marque.class);
			marqSelect.setParameter("param1", tm);
			List<Marque> ifMarqExist = marqSelect.getResultList();
			
			// Insert si elle n'existe pas
			if(ifMarqExist.isEmpty()) {
				marqueNom.setNom(tm);
				em.persist(marqueNom);
			}
		}

		transaction.commit();
		em.close();
		entityManagerFactory.close();
	}

	// ----------------------------------------------- UPDATE -----------------------------------------
	@Override
	public int update(String ancienNom, String nouveauNom) {
		transaction.begin();
		
		int returnModif = 0;
		
		// Test si la catégortie existe déjà
		TypedQuery<Marque> marqSelect = em.createQuery("SELECT m FROM Marque m WHERE m.nom=:param1", Marque.class);
		marqSelect.setParameter("param1", ancienNom);
		List<Marque> marque = marqSelect.getResultList();
		
//		System.out.println(marque);
		
		if(!marque.isEmpty()) {
			Marque marqFind = null;
			for(Marque m : marque) {
				marqFind = m;
			}
			marqFind.setNom(nouveauNom);
			em.persist(marqFind);
			returnModif = 1;
		}

		transaction.commit();
		em.close();
		entityManagerFactory.close();
		
		return returnModif;
	}

	// ----------------------------------------------- DELETE -----------------------------------------
	@Override
	public boolean delete(Marque marque) {
		transaction.begin();
		
		boolean returnDelete = false;
		
		Marque marqDelete = em.find(Marque.class, marque.getId());
		if(marqDelete != null) {
			em.remove(marqDelete);
			returnDelete = true;
		}
		
		transaction.commit();
		em.close();
		entityManagerFactory.close();
		
		return returnDelete;
	}

}
