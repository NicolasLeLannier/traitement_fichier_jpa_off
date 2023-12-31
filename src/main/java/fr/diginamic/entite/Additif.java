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
@Table(name = "Additif")
public class Additif {

	/** id */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	/** nom */
	private String nom;
	/** code */
	private String code;
	
	/** produit */
	@ManyToMany(mappedBy = "additifs")
	private List<Produit> produit;
	
	/** Constructor
	 * 
	 */
	public Additif() {
		super();
	}

	/** Constructor
	 * @param nom
	 */
	public Additif(String nom) {
		super();
		this.nom = nom;
	}

	/** toString
	 * @return Additif affichage
	 */
	@Override
	public String toString() {
		return "Additif [id=" + id + ", nom=" + nom + ", code=" + code + "]";
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
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/** Setter
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
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
