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

import fr.diginamic.dao.AdditifDao;
import fr.diginamic.entite.Additif;
import fr.diginamic.entite.Allergene;

/**
 * @author lelan
 *
 */
public class AdditifDaoJdbc implements AdditifDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("open-food-facts");
	EntityManager em = entityManagerFactory.createEntityManager();
	EntityTransaction transaction = em.getTransaction();

	// ----------------------------------------------- SELECT -----------------------------------------
	@Override
	public List<Additif> extraire() {		
		transaction.begin();
		
		TypedQuery<Additif> addiSelect = em.createQuery("SELECT a FROM Additif a", Additif.class);
		List<Additif> listAdditif = addiSelect.getResultList();
		
		transaction.commit();
		em.close();

		return listAdditif;
	}

	// ----------------------------------------------- INSERT -----------------------------------------
	@Override
	public void insert(Additif additif) {
		transaction.begin();
		Additif additifNom = new Additif();
		
		String[] tokensAdditif = additif.getNom().split(",");
		
		for(String ta : tokensAdditif) {
			
			String[] tAddi = ta.split("-");
			
			// Test si la marque existe déjà
			TypedQuery<Additif> addiSelect = em.createQuery("SELECT a FROM Additif a WHERE a.code=:param1", Additif.class);
			addiSelect.setParameter("param1", tAddi[0]);
			List<Additif> ifAddiExist = addiSelect.getResultList();
			
			// Insert si elle n'existe pas
			if(ifAddiExist.isEmpty()) {
				additifNom.setCode(tAddi[0]);
				additifNom.setNom(tAddi[1]);
				em.persist(additifNom);
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
		TypedQuery<Additif> addiSelect = em.createQuery("SELECT a FROM Additif a WHERE a.nom=:param1", Additif.class);
		addiSelect.setParameter("param1", ancienNom);
		List<Additif> additif = addiSelect.getResultList();
		
//		System.out.println(additif);
		
		if(!additif.isEmpty()) {
			Additif addiFind = null;
			for(Additif a : additif) {
				addiFind = a;
			}
			addiFind.setNom(nouveauNom);
			em.persist(addiFind);
			returnModif = 1;
		}

		transaction.commit();
		em.close();
		entityManagerFactory.close();
		
		return returnModif;
	}

	// ----------------------------------------------- DELETE -----------------------------------------
	@Override
	public boolean delete(Additif additif) {
		transaction.begin();
		
		boolean returnDelete = false;
		
		Additif addiDelete = em.find(Additif.class, additif.getId());
		if(addiDelete != null) {
			em.remove(addiDelete);
			returnDelete = true;
		}
		
		transaction.commit();
		em.close();
		entityManagerFactory.close();
		
		return returnDelete;
	}

}
