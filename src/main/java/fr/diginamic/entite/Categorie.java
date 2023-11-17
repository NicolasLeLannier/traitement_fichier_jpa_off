package fr.diginamic.entite;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author lelan
 *
 */
@Entity
@Table(name = "Categorie")
public class Categorie {

	/** id */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	/** nom */
	private String nom;
	
	/** produit */
	@OneToMany(mappedBy = "categorie")
	private List<Produit> produit;
	
	/** Constructor
	 * 
	 */
	public Categorie() {
		super();
	}

	/** Constructor
	 * @param nom
	 */
	public Categorie(String nom) {
		super();
		this.nom = nom;
	}

	/** toString
	 * @return Categorie affichage
	 */
	@Override
	public String toString() {
		return "Categorie [id=" + id + ", nom=" + nom + "]";
	}

	/** Getter
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/** Setter
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/** Getter
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/** Setter
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/** Getter
	 * @return the plats
	 */
	public List<Produit> getProduit() {
		return produit;
	}

	/** Setter
	 * @param plats the plats to set
	 */
	public void setProduit(List<Produit> produit) {
		this.produit = produit;
	}
	
	
}
