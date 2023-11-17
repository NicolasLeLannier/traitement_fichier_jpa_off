/**
 * 
 */
package fr.diginamic.dao;

import java.util.List;

import fr.diginamic.entite.Vitamine;

/**
 * @author lelan
 *
 */
public interface VitamineDao {

	List<Vitamine> extraire();
	void insert(Vitamine vitamine);
	int update(String ancienNom, String nouveauNom);
	boolean delete(Vitamine vitamine);
}
