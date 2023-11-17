/**
 * 
 */
package fr.diginamic.dao;

import java.util.List;

import fr.diginamic.entite.Additif;

/**
 * @author lelan
 *
 */
public interface AdditifDao {

	List<Additif> extraire();
	void insert(Additif additif);
	int update(String ancienNom, String nouveauNom);
	boolean delete(Additif additif);
}
