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

import fr.diginamic.dao.AllergeneDao;
import fr.diginamic.entite.Allergene;
import fr.diginamic.entite.Marque;

/**
 * @author lelan
 *
 */
public class AllergeneDaoJdbc implements AllergeneDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("open-food-facts");
	EntityManager em = entityManagerFactory.createEntityManager();
	EntityTransaction transaction = em.getTransaction();

	// ----------------------------------------------- SELECT -----------------------------------------
	@Override
	public List<Allergene> extraire() {		
		transaction.begin();
		
		TypedQuery<Allergene> alleSelect = em.createQuery("SELECT a FROM Allergene a", Allergene.class);
		List<Allergene> listAllergene = alleSelect.getResultList();
		
		transaction.commit();
		em.close();

		return listAllergene;
	}

	// ----------------------------------------------- INSERT -----------------------------------------
	@Override
	public void insert(Allergene allergene) {
		transaction.begin();
		Allergene allergeneNom = new Allergene();
		
		String[] tokensAllergene = allergene.getNom().split(",");
		
		for(String ta : tokensAllergene) {
			
			if(ta.contains("en:") || ta.contains("fr:")) {
				ta = ta.substring(3);
			}
			
			ta = ta.toLowerCase();
			
			// Test si la marque existe déjà
			TypedQuery<Allergene> alleSelect = em.createQuery("SELECT a FROM Allergene a WHERE a.nom=:param1", Allergene.class);
			alleSelect.setParameter("param1", ta);
			List<Allergene> ifAlleExist = alleSelect.getResultList();
			
			// Insert si elle n'existe pas
			if(ifAlleExist.isEmpty()) {
				allergeneNom.setNom(ta);
				em.persist(allergeneNom);
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
		TypedQuery<Allergene> alleSelect = em.createQuery("SELECT a FROM Allergene a WHERE a.nom=:param1", Allergene.class);
		alleSelect.setParameter("param1", ancienNom);
		List<Allergene> allergene = alleSelect.getResultList();
		
//		System.out.println(allergene);
		
		if(!allergene.isEmpty()) {
			Allergene alleFind = null;
			for(Allergene a : allergene) {
				alleFind = a;
			}
			alleFind.setNom(nouveauNom);
			em.persist(alleFind);
			returnModif = 1;
		}

		transaction.commit();
		em.close();
		entityManagerFactory.close();
		
		return returnModif;
	}

	// ----------------------------------------------- DELETE -----------------------------------------
	@Override
	public boolean delete(Allergene allergene) {
		transaction.begin();
		
		boolean returnDelete = false;
		
		Allergene alleDelete = em.find(Allergene.class, allergene.getId());
		if(alleDelete != null) {
			em.remove(alleDelete);
			returnDelete = true;
		}
		
		transaction.commit();
		em.close();
		entityManagerFactory.close();
		
		return returnDelete;
	}

}
