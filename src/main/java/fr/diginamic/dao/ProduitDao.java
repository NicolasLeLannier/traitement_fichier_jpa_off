/**
 * 
 */
package fr.diginamic.dao;

import java.util.List;

import fr.diginamic.entite.Produit;

/**
 * @author lelan
 *
 */
public interface ProduitDao {

	List<Produit> extraire();
	void insert(Produit produit);
	int update(String ancienNom, String nouveauNom);
	boolean delete(Produit produit);
}
