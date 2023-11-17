/**
 * 
 */
package fr.diginamic.dao;

import java.util.List;

import fr.diginamic.entite.ValeurNutritionnelle;

/**
 * @author lelan
 *
 */
public interface ValeurNutritionnelleDao {

	List<ValeurNutritionnelle> extraire();
	void insert(ValeurNutritionnelle valeurNutrionnelle);
	int update(String ancienNom, String nouveauNom);
	boolean delete(ValeurNutritionnelle valeurNutrionnelle);
}
