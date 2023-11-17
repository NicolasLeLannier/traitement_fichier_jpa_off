/**
 * 
 */
package fr.diginamic.dao.jdbc;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.QueryHint;
import javax.persistence.TypedQuery;

import fr.diginamic.dao.MarqueDao;
import fr.diginamic.dao.ProduitDao;
import fr.diginamic.entite.Additif;
import fr.diginamic.entite.Allergene;
import fr.diginamic.entite.Categorie;
import fr.diginamic.entite.Ingredient;
import fr.diginamic.entite.Marque;
import fr.diginamic.entite.Produit;
import fr.diginamic.entite.ValeurNutritionnelle;
import fr.diginamic.entite.Vitamine;

/**
 * @author lelan
 *
 */
public class ProduitDaoJdbc implements ProduitDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("open-food-facts");
	EntityManager em = entityManagerFactory.createEntityManager();
	EntityTransaction transaction = em.getTransaction();

	// ----------------------------------------------- SELECT -----------------------------------------
	@Override
	public List<Produit> extraire() {		
//		transaction.begin();
//		
//		TypedQuery<Marque> marqSelect = em.createQuery("SELECT m FROM Marque m", Marque.class);
//		List<Marque> listMarque = marqSelect.getResultList();
//		
//		transaction.commit();
//		em.close();
//
//		return listMarque;
		return null;
	}

	// ----------------------------------------------- INSERT -----------------------------------------
	@Override
	public void insert(Produit produit) {
		transaction.begin();
		Produit produitNom = new Produit();
		
//		String[] tokensProduit = produit.getNom().split(",");
//		
//		for(String tp : tokensProduit) {
			
			// Test si la marque existe déjà
//			TypedQuery<Marque> marqSelect = em.createQuery("SELECT m FROM Marque m WHERE m.nom=:param1", Marque.class);
//			marqSelect.setParameter("param1", tp);
//			List<Marque> ifMarqExist = marqSelect.getResultList();
			
			// Insert si elle n'existe pas
//			if(ifMarqExist.isEmpty()) {
//				produitNom.setNom(tp);
//				em.persist(produitNom);
//			}
//		}
		
//		produitNom.setNom(produit.getNom());
//		produitNom.setNutritionGrade(produit.getNutritionGrade());
//		

		
//		Query select = em.createQuery("SELECT c FROM Categorie c WHERE c.nom=:param1");
//		select.setParameter("param1", produit.getCategorie().getNom());
//		List<Categorie> categorie = select.getResultList();
//		Categorie idCategorie = em.find(Categorie.class, categorie.get(0).getId());

		int idCateg = findIdByName(Categorie.class, produit.getCategorie().getNom());
		int idVitamine = findIdByClass(Vitamine.class);
		int idValeurNutrionnelle = findIdByClass(ValeurNutritionnelle.class);
//		Categorie idCategorie = em.find(Categorie.class, idCateg);
		
//		MarqueDao marqueDAO = new MarqueDaoJdbc();
//		marqueDAO.insert(produit.getMarques().get(0));
//		System.out.println(produit.getMarques());
		
		produit.getCategorie().setId(idCateg);
		produit.getVitamine().setId(idVitamine);
		produit.getValeurNutrionnelle().setId(idValeurNutrionnelle);
		
		int cpt = 0;
		String[] tokensMarque = produit.getMarques().get(0).getNom().split(",");
		for(String str : tokensMarque) {
			int idMarque = findIdByName(Marque.class, str);
			if(cpt == 0) {
				produit.getMarques().get(cpt).setId(idMarque);
				produit.getMarques().get(cpt).setNom(str);
			} else {
				Marque m = new Marque();
				m.setId(idMarque);
				m.setNom(str);
				produit.getMarques().add(m);
			}
			cpt ++;
		}
		

		cpt = 0;
		String[] tokensIngredient = null;
		if(produit.getIngredients().get(0).getNom().contains(",")) {
			tokensIngredient = produit.getIngredients().get(0).getNom().split(",");
		} else {
			tokensIngredient = produit.getIngredients().get(0).getNom().split("-");
		}
		for(String str : tokensIngredient) {
			str = str.replaceAll("[^a-zA-Z]", " ");
			str = str.toLowerCase();
			System.out.println(str);
			int idIngredient = findIdByName(Ingredient.class, str);
			if(cpt == 0) {
				produit.getIngredients().get(cpt).setId(idIngredient);
				produit.getIngredients().get(cpt).setNom(str);
			} else {
				Ingredient i = new Ingredient();
				i.setId(idIngredient);
				i.setNom(str);
				produit.getIngredients().add(i);
			}
			cpt ++;
		}
		System.out.println(produit.getIngredients());
		
		
		cpt = 0;
		if(produit.getAllergenes() != null) {
			String[] tokensAllergene = produit.getAllergenes().get(0).getNom().split(",");
			for(String str : tokensAllergene) {
				int idAllergene = findIdByName(Allergene.class, str);
				if(cpt == 0) {
					produit.getAllergenes().get(cpt).setId(idAllergene);
					produit.getAllergenes().get(cpt).setNom(str);
				} else {
					Allergene a = new Allergene();
					a.setId(idAllergene);
					a.setNom(str);
					produit.getAllergenes().add(a);
				}
				cpt ++;
			}
		}
		System.out.println(produit.getAllergenes());
		
		
		cpt = 0;
		if(produit.getAdditifs() != null) {
			String[] tokensAdditif = produit.getAdditifs().get(0).getNom().split(",");
			for(String str : tokensAdditif) {
				String[] tAddi = str.split("-");
				System.out.println("Ici : " + tAddi[1]);
				int idAdditif = findIdByCode(Additif.class, tAddi[0]);
				if(cpt == 0) {
					produit.getAdditifs().get(cpt).setId(idAdditif);
					produit.getAdditifs().get(cpt).setNom(tAddi[1]);
					produit.getAdditifs().get(cpt).setCode(tAddi[0]);
				} else {
					Additif a = new Additif();
					a.setId(idAdditif);
					a.setNom(tAddi[1]);
					a.setCode(tAddi[0]);
					produit.getAdditifs().add(a);
				}
				cpt ++;
			}
		}
		System.out.println(produit.getAdditifs());
		
		
		produitNom.setCategorie(produit.getCategorie());
		produitNom.setNom(produit.getNom());
		produitNom.setNutritionGrade(produit.getNutritionGrade());
		produitNom.setPresenceHuilePalme(produit.getPresenceHuilePalme());
		produitNom.setValeurNutrionnelle(produit.getValeurNutrionnelle());
		produitNom.setVitamine(produit.getVitamine());
		produitNom.setMarques(produit.getMarques());
		produitNom.setIngredients(produit.getIngredients());
		produitNom.setAllergenes(produit.getAllergenes());
		produitNom.setAdditifs(produit.getAdditifs());
		em.persist(produitNom);

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
//		TypedQuery<Marque> marqSelect = em.createQuery("SELECT m FROM Marque m WHERE m.nom=:param1", Marque.class);
//		marqSelect.setParameter("param1", ancienNom);
//		List<Marque> marque = marqSelect.getResultList();
//		
////		System.out.println(marque);
//		
//		if(!marque.isEmpty()) {
//			Marque marqFind = null;
//			for(Marque m : marque) {
//				marqFind = m;
//			}
//			marqFind.setNom(nouveauNom);
//			em.persist(marqFind);
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
	public boolean delete(Produit produit) {
//		transaction.begin();
//		
//		boolean returnDelete = false;
//		
//		Marque marqDelete = em.find(Marque.class, marque.getId());
//		if(marqDelete != null) {
//			em.remove(marqDelete);
//			returnDelete = true;
//		}
//		
//		transaction.commit();
//		em.close();
//		entityManagerFactory.close();
//		
//		return returnDelete;
		return false;
	}

	
	public <T> int findIdByName(Class<T> entityClass, String name) {
		TypedQuery<Integer> query = em.createQuery("SELECT c.id FROM " + entityClass.getSimpleName() + " c WHERE c.nom=:param1", Integer.class);
		query.setParameter("param1", name);
		Integer id = query.getSingleResult();
		
		return id;
	}
	
	public <T> int findIdByCode(Class<T> entityClass, String code) {
		TypedQuery<Integer> query = em.createQuery("SELECT c.id FROM " + entityClass.getSimpleName() + " c WHERE c.code=:param1", Integer.class);
		query.setParameter("param1", code);
		Integer id = query.getSingleResult();
		
		return id;
	}
	
	public <T> int findIdByClass(Class<T> entityClass) {
//		System.out.println(entityClass.getSimpleName());
		TypedQuery<Integer> query = em.createQuery("SELECT c.id FROM " + entityClass.getSimpleName() + " c ORDER BY c.id DESC", Integer.class);
//		query.setParameter("param1", entityClass.getSimpleName());
		List<Integer> idList = query.setMaxResults(1).getResultList();
		
		int id = idList.get(0);
//		System.out.println(id);
		
		return id;
	}
	
}
