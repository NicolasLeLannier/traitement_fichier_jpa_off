package fr.diginamic.essaie;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class IntegrationOpenFoodFacts {

	public static void main(String[] args) throws IOException {

//		int enlevePremierLigne = 0;
//		
//		// Chemin du fichier
//		Path pathFichierDeBase = Paths.get("C:/temp/Open Food Fact/open-food-facts.csv");
//		
//		// Initialisations des listes
//		List<String> lectureFichier = Files.readAllLines(pathFichierDeBase);
//		
//		// Ajout des données que l'on veux dans la liste listeVilleDeBase d'après la classe Recensement 
//		for(String afficherFichier : lectureFichier) {
//			String[] tokens = afficherFichier.replace("|", ";").split(";");
//			if(enlevePremierLigne == 0) {
//				for(int i = 0; i < tokens.length; i++) {
//					System.out.println(i + " - " + tokens[i]);
//				}
//				enlevePremierLigne ++;
//			} else {
//			}
//		}
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("open-food-facts");
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		
		transaction.begin();
		transaction.commit();
	}

}
