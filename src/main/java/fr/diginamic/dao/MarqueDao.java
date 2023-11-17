/**
 * 
 */
package fr.diginamic.dao;

import java.util.List;

import fr.diginamic.entite.Marque;

/**
 * @author lelan
 *
 */
public interface MarqueDao  {

	List<Marque> extraire();
	void insert(Marque marque);
	int update(String ancienNom, String nouveauNom);
	boolean delete(Marque marque);
}
