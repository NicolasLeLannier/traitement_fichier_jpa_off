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

import fr.diginamic.dao.IngredientDao;
import fr.diginamic.entite.Allergene;
import fr.diginamic.entite.Ingredient;

/**
 * @author lelan
 *
 */
public class IngredientDaoJdbc implements IngredientDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("open-food-facts");
	EntityManager em = entityManagerFactory.createEntityManager();
	EntityTransaction transaction = em.getTransaction();

	// ----------------------------------------------- SELECT -----------------------------------------
	@Override
	public List<Ingredient> extraire() {		
		transaction.begin();
		
		TypedQuery<Ingredient> ingreSelect = em.createQuery("SELECT i FROM Ingredient i", Ingredient.class);
		List<Ingredient> listIngredient = ingreSelect.getResultList();
		
		transaction.commit();
		em.close();

		return listIngredient;
	}

	// ----------------------------------------------- INSERT -----------------------------------------
	@Override
	public void insert(Ingredient ingredient) {
		transaction.begin();
		Ingredient ingredientNom = new Ingredient();
		String[] tokensIngredient = null;
		
		System.out.println(ingredient);
		
		if(ingredient.getNom().contains(",")) {
			tokensIngredient = ingredient.getNom().split(",");
		} else {
			tokensIngredient = ingredient.getNom().split("-");
		}
		
		for(String ti : tokensIngredient) {
			System.out.println(ti);
//			ti = ti.replaceAll("[^a-zA-Z]", " ");
//			ti = ti.toLowerCase();
			
			// Test si la marque existe déjà
			TypedQuery<Ingredient> ingreSelect = em.createQuery("SELECT i FROM Ingredient i WHERE i.nom=:param1", Ingredient.class);
			ingreSelect.setParameter("param1", ti);
			List<Ingredient> ifIngreExist = ingreSelect.getResultList();
			
			// Insert si elle n'existe pas
			if(ifIngreExist.isEmpty()) {
				ingredientNom.setNom(ti);
				em.persist(ingredientNom);
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
		TypedQuery<Ingredient> ingreSelect = em.createQuery("SELECT i FROM Ingredient i WHERE i.nom=:param1", Ingredient.class);
		ingreSelect.setParameter("param1", ancienNom);
		List<Ingredient> ingredient = ingreSelect.getResultList();
		
//		System.out.println(allergene);
		
		if(!ingredient.isEmpty()) {
			Ingredient ingreFind = null;
			for(Ingredient a : ingredient) {
				ingreFind = a;
			}
			ingreFind.setNom(nouveauNom);
			em.persist(ingreFind);
			returnModif = 1;
		}

		transaction.commit();
		em.close();
		entityManagerFactory.close();
		
		return returnModif;
	}

	// ----------------------------------------------- DELETE -----------------------------------------
	@Override
	public boolean delete(Ingredient ingredient) {
		transaction.begin();
		
		boolean returnDelete = false;
		
		Ingredient ingreDelete = em.find(Ingredient.class, ingredient.getId());
		if(ingreDelete != null) {
			em.remove(ingreDelete);
			returnDelete = true;
		}
		
		transaction.commit();
		em.close();
		entityManagerFactory.close();
		
		return returnDelete;
	}

}
