package fr.diginamic.essaie;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.diginamic.dao.AdditifDao;
import fr.diginamic.dao.AllergeneDao;
import fr.diginamic.dao.CategorieDao;
import fr.diginamic.dao.IngredientDao;
import fr.diginamic.dao.MarqueDao;
import fr.diginamic.dao.ProduitDao;
import fr.diginamic.dao.ValeurNutritionnelleDao;
import fr.diginamic.dao.VitamineDao;
import fr.diginamic.dao.jdbc.AdditifDaoJdbc;
import fr.diginamic.dao.jdbc.AllergeneDaoJdbc;
import fr.diginamic.dao.jdbc.CategorieDaoJdbc;
import fr.diginamic.dao.jdbc.IngredientDaoJdbc;
import fr.diginamic.dao.jdbc.MarqueDaoJdbc;
import fr.diginamic.dao.jdbc.ProduitDaoJdbc;
import fr.diginamic.dao.jdbc.ValeurNutritionnelleDaoJdbc;
import fr.diginamic.dao.jdbc.VitamineDaoJdbc;
import fr.diginamic.entite.Additif;
import fr.diginamic.entite.Allergene;
import fr.diginamic.entite.Categorie;
import fr.diginamic.entite.Ingredient;
import fr.diginamic.entite.Marque;
import fr.diginamic.entite.Produit;
import fr.diginamic.entite.ValeurNutritionnelle;
import fr.diginamic.entite.Vitamine;

public class IntegrationOpenFoodFacts {

	public static void main(String[] args) throws IOException {

		int enlevePremierLigne = 0;
	
		// Chemin du fichier
		Path pathFichierDeBase = Paths.get("C:/temp/Open Food Fact/open-food-facts.csv");

		// Initialisations des listes
		List<String> lectureFichier = Files.readAllLines(pathFichierDeBase);

		// Ajout des données que l'on veux dans la liste listeVilleDeBase d'après la
		// classe Recensement
		for (String afficherFichier : lectureFichier) {
			String[] tokens = afficherFichier.split("\\|", -1);
			if (enlevePremierLigne != 0) {

				CategorieDao categorieDAOTest = new CategorieDaoJdbc();
				Categorie categ = new Categorie(tokens[0]);
				categorieDAOTest.insert(categ);

//				MarqueDao marqueDAOTest = new MarqueDaoJdbc();
//				Marque marq = new Marque(tokens[1]);
//				marqueDAOTest.insert(marq);

//				if (!(tokens[28] == "")) {
//					AllergeneDao allergeneDAO = new AllergeneDaoJdbc();
//					allergeneDAO.insert(tokens[28]);
//				}
				
//				if (!(tokens[29] == "")) {
//					AdditifDao additifDao = new AdditifDaoJdbc();
//					additifDao.insert(tokens[29]);
//				}
				
//				System.out.println(tokens[4]);
//				
//				IngredientDao ingredientDAOTest = new IngredientDaoJdbc();
//				Ingredient ing = new Ingredient(tokens[4]);
//				ingredientDAOTest.insert(ing);
				
				
				
				// Certains utilisateurs ont utilisé des pipes dans leurs ingrédients, ce qui ajoute une colonne.
				// Je n'arrive pas à gérer ce problème donc je supprime ces lignes pour le moment
//				Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
				
				// Check si la valeur de energie est bien un chiffre
//				if(pattern.matcher(tokens[5]).matches()) {
				
				if(tokens.length == 31) {
					
					// Evite les empty vide pour les valeurs nutritionnelle et vitamine
					for(int i = 5; i < (tokens.length - 3); i++) {
						if(tokens[i].isEmpty()) {
							tokens[i] = "0";
						} 
					}
					

					ValeurNutritionnelle valeurNutritionnelle = new ValeurNutritionnelle(Double.parseDouble(tokens[5]), Double.parseDouble(tokens[6]), Double.parseDouble(tokens[7]), Double.parseDouble(tokens[8]), Double.parseDouble(tokens[9]), Double.parseDouble(tokens[10]), Double.parseDouble(tokens[22]), Double.parseDouble(tokens[23]), Double.parseDouble(tokens[24]), Double.parseDouble(tokens[25]), Double.parseDouble(tokens[26]));
					ValeurNutritionnelleDao valNutDAO = new ValeurNutritionnelleDaoJdbc();
//					valNutDAO.insert(valeurNutritionnelle);

					Vitamine vitamine = new Vitamine(Double.parseDouble(tokens[11]), Double.parseDouble(tokens[12]), Double.parseDouble(tokens[13]), Double.parseDouble(tokens[14]), Double.parseDouble(tokens[15]), Double.parseDouble(tokens[16]), Double.parseDouble(tokens[17]), Double.parseDouble(tokens[18]), Double.parseDouble(tokens[19]), Double.parseDouble(tokens[20]), Double.parseDouble(tokens[21]));
					VitamineDao vitamineDAO = new VitamineDaoJdbc();
//					vitamineDAO.insert(vitamine);
					
					Categorie categorie = new Categorie(tokens[0]);
					CategorieDao categorieDAO = new CategorieDaoJdbc();
//					categorieDAO.insert(categorie);
					
					List<Marque> marque = new ArrayList<>();
					marque.add(new Marque(tokens[1]));
					MarqueDao marqueDAO = new MarqueDaoJdbc();
//					marqueDAO.insert(marque);
					
					List<Ingredient> ingredient = new ArrayList<>();
					ingredient.add(new Ingredient(tokens[4]));
					IngredientDao ingredientDAO = new IngredientDaoJdbc();
//					ingredientDAO.insert(ingredient);
					
					List<Allergene> allergene = null;
					if (!(tokens[28] == "")) {
						allergene = new ArrayList<>();
						allergene.add(new Allergene(tokens[28]));
						AllergeneDao allergeneDAO = new AllergeneDaoJdbc();
//						allergeneDAO.insert(allergene);
					}
					
					List<Additif> additif = null;
					if (!(tokens[29] == "")) {
						additif = new ArrayList<>();
						additif.add(new Additif(tokens[29]));
						AdditifDao additifDao = new AdditifDaoJdbc();
//						additifDao.insert(additif);
					}
					
					Produit produit = new Produit();
					produit.setValeurNutrionnelle(valeurNutritionnelle);
					produit.setVitamine(vitamine);
					produit.setCategorie(categorie);
					produit.setMarques(marque);
//					produit.setIngredients(ingredient);
					produit.setAllergenes(allergene);
					produit.setAdditifs(additif);
					produit.setNom(tokens[2]);
					produit.setNutritionGrade(tokens[3]);
					produit.setPresenceHuilePalme(Integer.parseInt(tokens[27]));
					
					ProduitDao prod = new ProduitDaoJdbc();
//					prod.insert(produit);
				}
					
			} else {
				enlevePremierLigne++;
			}
		}
//		MarqueDao marqueDao = new MarqueDaoJdbc();
//		System.out.println(marqueDao.extraire());
//		System.out.println(marqueDao.update("Uni", "aaaaaa"));
//		System.out.println(marqueDao.update("aaaaaa", "Uni"));

//		CategorieDao categorieDAO = new CategorieDaoJdbc();
//		Categorie cDelete = new Categorie();
//		cDelete.setId(404);
//		cDelete.setNom("Œufs de poisson");
//		System.out.println(categorieDAO.delete(cDelete));

//		categorieDAO.insert(tokens[0]);
//		System.out.println(categorieDAO.extraire());
//		System.out.println(categorieDAO.update("Œufs de poisson", "oaze"));
//		System.out.println(categorieDAO.update("oaze", "Œufs de poisson"));

	}

}
