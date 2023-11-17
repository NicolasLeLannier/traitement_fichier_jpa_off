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
@Table(name = "Marque")
public class Marque {

	/** id */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	/** nom */
	private String nom;
	
	/** produit */
	@ManyToMany(mappedBy = "marques")
	private List<Produit> produit;
	
	/** Constructor
	 * 
	 */
	public Marque() {
		super();
	}

	/** Constructor
	 * @param nom
	 */
	public Marque(String nom) {
		super();
		this.nom = nom;
	}

	/** toString
	 * @return Marque affichage
	 */
	@Override
	public String toString() {
		return "Marque [id=" + id + ", nom=" + nom + "]";
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
