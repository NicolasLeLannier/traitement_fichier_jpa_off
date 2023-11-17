/**
 * 
 */
package fr.diginamic.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.diginamic.dao.CategorieDao;
import fr.diginamic.entite.Categorie;

/**
 * @author lelan
 *
 */
public class CategorieDaoJdbc implements CategorieDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("open-food-facts");
	EntityManager em = entityManagerFactory.createEntityManager();
	EntityTransaction transaction = em.getTransaction();

	// ----------------------------------------------- SELECT -----------------------------------------
	@Override
	public List<Categorie> extraire() {		
		transaction.begin();
		
		TypedQuery<Categorie> categSelect = em.createQuery("SELECT c FROM Categorie c", Categorie.class);
		List<Categorie> listCategorie = categSelect.getResultList();
		
		transaction.commit();
		em.close();

		return listCategorie;
	}

	// ----------------------------------------------- INSERT -----------------------------------------
	@Override
	public void insert(Categorie categorie) {
		transaction.begin();
	
		Categorie categorieNom = new Categorie();
		
		// Test si la catégortie existe déjà
		TypedQuery<Categorie> categSelect = em.createQuery("SELECT c FROM Categorie c WHERE c.nom=:param1", Categorie.class);
		categSelect.setParameter("param1", categorie.getNom());
		List<Categorie> ifCategExist = categSelect.getResultList();
		
		// Insert si elle n'existe pas
		if(ifCategExist.isEmpty()) {
			categorieNom.setNom(categorie.getNom());
			em.persist(categorieNom);
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
		TypedQuery<Categorie> categSelect = em.createQuery("SELECT c FROM Categorie c WHERE c.nom=:param1", Categorie.class);
		categSelect.setParameter("param1", ancienNom);
		List<Categorie> categorie = categSelect.getResultList();
		
//		System.out.println(categorie);
		
		if(!categorie.isEmpty()) {
			Categorie categFind = null;
			for(Categorie c : categorie) {
				categFind = c;
			}
			categFind.setNom(nouveauNom);
			em.persist(categFind);
			returnModif = 1;
		}

		transaction.commit();
		em.close();
		entityManagerFactory.close();
		
		return returnModif;
	}

	// ----------------------------------------------- DELETE -----------------------------------------
	@Override
	public boolean delete(Categorie categorie) {
		transaction.begin();
		
		boolean returnDelete = false;
		
		Categorie categDelete = em.find(Categorie.class, categorie.getId());
		if(categDelete != null) {
			em.remove(categDelete);
			returnDelete = true;
		}
		
		transaction.commit();
		em.close();
		entityManagerFactory.close();
		
		return returnDelete;
	}

}
