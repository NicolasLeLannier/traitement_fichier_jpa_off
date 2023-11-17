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

import fr.diginamic.dao.ValeurNutritionnelleDao;
import fr.diginamic.entite.Additif;
import fr.diginamic.entite.ValeurNutritionnelle;

/**
 * @author lelan
 *
 */
public class ValeurNutritionnelleDaoJdbc implements ValeurNutritionnelleDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("open-food-facts");
	EntityManager em = entityManagerFactory.createEntityManager();
	EntityTransaction transaction = em.getTransaction();

	// ----------------------------------------------- SELECT -----------------------------------------
	@Override
	public List<ValeurNutritionnelle> extraire() {
		transaction.begin();

		TypedQuery<ValeurNutritionnelle> valNutSelect = em.createQuery("SELECT vn FROM ValeurNutritionnelle vn", ValeurNutritionnelle.class);
		List<ValeurNutritionnelle> listValNut = valNutSelect.getResultList();

		transaction.commit();
		em.close();

		return listValNut;
	}

	// ----------------------------------------------- INSERT -----------------------------------------
	@Override
	public void insert(ValeurNutritionnelle valeurNutritionnelle) {
		transaction.begin();
		ValeurNutritionnelle additif = new ValeurNutritionnelle();

		additif.setBetaCarotene100g(valeurNutritionnelle.getBetaCarotene100g());
		additif.setCalcium100g(valeurNutritionnelle.getCalcium100g());
		additif.setEnergie100g(valeurNutritionnelle.getEnergie100g());
		additif.setFer100g(valeurNutritionnelle.getFer100g());
		additif.setFibres100g(valeurNutritionnelle.getFibres100g());
		additif.setGraisse100g(valeurNutritionnelle.getGraisse100g());
		additif.setIron100g(valeurNutritionnelle.getIron100g());
		additif.setMagnesium100g(valeurNutritionnelle.getMagnesium100g());
		additif.setProteines100g(valeurNutritionnelle.getProteines100g());
		additif.setSel100g(valeurNutritionnelle.getSel100g());
		additif.setSucres100g(valeurNutritionnelle.getSucres100g());
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
	public boolean delete(ValeurNutritionnelle valeurNutritionnelle) {
		transaction.begin();

		boolean returnDelete = false;

		ValeurNutritionnelle valNutDelete = em.find(ValeurNutritionnelle.class, valeurNutritionnelle.getId());
		if (valNutDelete != null) {
			em.remove(valNutDelete);
			returnDelete = true;
		}

		transaction.commit();
		em.close();
		entityManagerFactory.close();

		return returnDelete;
	}

}
