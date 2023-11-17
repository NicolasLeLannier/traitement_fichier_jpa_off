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

import fr.diginamic.dao.VitamineDao;
import fr.diginamic.entite.ValeurNutritionnelle;
import fr.diginamic.entite.Vitamine;

/**
 * @author lelan
 *
 */
public class VitamineDaoJdbc implements VitamineDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("open-food-facts");
	EntityManager em = entityManagerFactory.createEntityManager();
	EntityTransaction transaction = em.getTransaction();

	// ----------------------------------------------- SELECT -----------------------------------------
	@Override
	public List<Vitamine> extraire() {
		transaction.begin();

		TypedQuery<Vitamine> vitaSelect = em.createQuery("SELECT v FROM Vitamine v", Vitamine.class);
		List<Vitamine> listVitamine = vitaSelect.getResultList();

		transaction.commit();
		em.close();

		return listVitamine;
	}

	// ----------------------------------------------- INSERT -----------------------------------------
	@Override
	public void insert(Vitamine vitamine) {
		transaction.begin();
		Vitamine additif = new Vitamine();

		additif.setVitA100g(vitamine.getVitA100g());
		additif.setVitB12100g(vitamine.getVitB12100g());
		additif.setVitB1j100g(vitamine.getVitB1j100g());
		additif.setVitB2100g(vitamine.getVitB2100g());
		additif.setVitB6100g(vitamine.getVitB6100g());
		additif.setVitB9100g(vitamine.getVitB9100g());
		additif.setVitC100g(vitamine.getVitC100g());
		additif.setVitD100g(vitamine.getVitD100g());
		additif.setVitE100g(vitamine.getVitE100g());
		additif.setVitK100g(vitamine.getVitK100g());
		additif.setVitPP100g(vitamine.getVitPP100g());
		em.persist(additif);

		transaction.commit();
		em.close();
		entityManagerFactory.close();
	}

	// ----------------------------------------------- UPDATE -----------------------------------------
	@Override
	public int update(String ancienNom, String nouveauNom) {
//		transaction.begin();
//
//		int returnModif = 0;
//
//		// Test si la catégortie existe déjà
//		TypedQuery<ValeurNutritionnelle> addiSelect = em.createQuery("SELECT vn FROM ValeurNutritionnelle vn WHERE vn.nom=:param1", ValeurNutritionnelle.class);
//		addiSelect.setParameter("param1", ancienNom);
//		List<ValeurNutritionnelle> additif = addiSelect.getResultList();
//
////		System.out.println(additif);
//
//		if (!additif.isEmpty()) {
//			ValeurNutritionnelle addiFind = null;
//			for (ValeurNutritionnelle a : additif) {
//				addiFind = a;
//			}
//			addiFind.setNom(nouveauNom);
//			em.persist(addiFind);
//			returnModif = 1;
//		}
//
//		transaction.commit();
//		em.close();
//		entityManagerFactory.close();
//
//		return returnModif;
		return 0;
	}

	// ----------------------------------------------- DELETE -----------------------------------------
	@Override
	public boolean delete(Vitamine vitamine) {
		transaction.begin();

		boolean returnDelete = false;

		Vitamine vitaDelete = em.find(Vitamine.class, vitamine.getId());
		if (vitaDelete != null) {
			em.remove(vitaDelete);
			returnDelete = true;
		}

		transaction.commit();
		em.close();
		entityManagerFactory.close();

		return returnDelete;
	}

}
