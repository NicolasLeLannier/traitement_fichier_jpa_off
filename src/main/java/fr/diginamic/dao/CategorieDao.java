/**
 * 
 */
package fr.diginamic.dao;

import java.util.List;

import fr.diginamic.entite.Categorie;

/**
 * @author lelan
 *
 */
public interface CategorieDao {

	List<Categorie> extraire();
	void insert(Categorie categorieNom);
	int update(String ancienNom, String nouveauNom);
	boolean delete(Categorie categorie);
}
