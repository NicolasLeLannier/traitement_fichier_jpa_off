/**
 * 
 */
package fr.diginamic.dao;

import java.util.List;

import fr.diginamic.entite.Ingredient;

/**
 * @author lelan
 *
 */
public interface IngredientDao {

	List<Ingredient> extraire();
	void insert(Ingredient ingredient);
	int update(String ancienNom, String nouveauNom);
	boolean delete(Ingredient ingredient);
}
