package fr.diginamic.entite;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author lelan
 *
 */
@Entity
@Table(name = "Allergene")
public class Allergene {

	/** id */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	/** nom */
	private String nom;
	
	/** produit */
	@ManyToMany(mappedBy = "allergenes")
	private List<Produit> produit;
	
	/** Constructor
	 * 
	 */
	public Allergene() {
		super();
	}

	/** toString
	 * @return Allergene affichage
	 */
	@Override
	public String toString() {
		return "Allergene [id=" + id + ", nom=" + nom + "]";
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
	 * @return the produit
	 */
	public List<Produit> getProduit() {
		return produit;
	}

	/** Setter
	 * @param produit the produit to set
	 */
	public void setProduit(List<Produit> produit) {
		this.produit = produit;
	}
}
