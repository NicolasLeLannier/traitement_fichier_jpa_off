/**
 * 
 */
package fr.diginamic.dao;

import java.util.List;

import fr.diginamic.entite.Allergene;

/**
 * @author lelan
 *
 */
public interface AllergeneDao {

	List<Allergene> extraire();
	void insert(Allergene allergene);
	int update(String ancienNom, String nouveauNom);
	boolean delete(Allergene allergene);
}
