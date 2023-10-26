package fr.diginamic.entite;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * @author lelan
 *
 */
@Entity
@Table(name = "Produit")
public class Produit {

	/** id */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	/** nom */
	private String nom;
	
	/** presenceHuilePalme */
	@Column(name = "presence_huile_palme")
	private boolean presenceHuilePalme;
	
	/** nutritionGrade */
	@Column(name = "nutrition_grade")
	private String nutritionGrade;
	
	/** categorie */
	@ManyToOne
	@JoinColumn(name = "ID_CATEGORIE")
	private Categorie categorie;
	
	/** marques */
	@ManyToMany
	@JoinTable(name = "PRODUIT_MARQUE",joinColumns = @JoinColumn(name = "ID_PRODUIT", referencedColumnName = "ID"), 
								inverseJoinColumns = @JoinColumn(name = "ID_MARQUE", referencedColumnName = "ID"))
	private List<Marque> marques;
	
	/** ingredients */
	@ManyToMany
	@JoinTable(name = "PRODUIT_INGREDIENT",joinColumns = @JoinColumn(name = "ID_PRODUIT", referencedColumnName = "ID"), 
								inverseJoinColumns = @JoinColumn(name = "ID_INGREDIENT", referencedColumnName = "ID"))
	private List<Ingredient> ingredients;
	
	/** allergenes */
	@ManyToMany
	@JoinTable(name = "PRODUIT_ALLERGENE",joinColumns = @JoinColumn(name = "ID_PRODUIT", referencedColumnName = "ID"), 
								inverseJoinColumns = @JoinColumn(name = "ID_ALLERGENE", referencedColumnName = "ID"))
	private List<Allergene> allergenes;
	
	/** additifs */
	@ManyToMany
	@JoinTable(name = "PRODUIT_ADDITIF",joinColumns = @JoinColumn(name = "ID_PRODUIT", referencedColumnName = "ID"), 
								inverseJoinColumns = @JoinColumn(name = "ID_ADDITIF", referencedColumnName = "ID"))
	private List<Additif> additifs;
	
	/** valeurNutrionnelle */
	@OneToOne  @JoinColumn( name="ID_VALEUR_NUTRITIONNELLE" )
    private ValeurNutrionnelle valeurNutrionnelle;
	
	@OneToOne  @JoinColumn( name="ID_VITAMINE" )
    private Vitamine vitamine;
	
	/** Constructor
	 * 
	 */
	public Produit() {
		super();
	}

	/** toString
	 * @return Produit affichage
	 */
	@Override
	public String toString() {
		return "Produit [id=" + id + ", nom=" + nom + ", presenceHuilePalme=" + presenceHuilePalme + ", nutritionGrade="
				+ nutritionGrade + "]";
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
	 * @return the presenceHuilePalme
	 */
	public boolean isPresenceHuilePalme() {
		return presenceHuilePalme;
	}

	/** Setter
	 * @param presenceHuilePalme the presenceHuilePalme to set
	 */
	public void setPresenceHuilePalme(boolean presenceHuilePalme) {
		this.presenceHuilePalme = presenceHuilePalme;
	}

	/** Getter
	 * @return the nutritionGrade
	 */
	public String getNutritionGrade() {
		return nutritionGrade;
	}

	/** Setter
	 * @param nutritionGrade the nutritionGrade to set
	 */
	public void setNutritionGrade(String nutritionGrade) {
		this.nutritionGrade = nutritionGrade;
	}

	/** Getter
	 * @return the categorie
	 */
	public Categorie getCategorie() {
		return categorie;
	}

	/** Setter
	 * @param categorie the categorie to set
	 */
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	/** Getter
	 * @return the marques
	 */
	public List<Marque> getMarques() {
		return marques;
	}

	/** Setter
	 * @param marques the marques to set
	 */
	public void setMarques(List<Marque> marques) {
		this.marques = marques;
	}

	/** Getter
	 * @return the ingredients
	 */
	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	/** Setter
	 * @param ingredients the ingredients to set
	 */
	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	/** Getter
	 * @return the allergenes
	 */
	public List<Allergene> getAllergenes() {
		return allergenes;
	}

	/** Setter
	 * @param allergenes the allergenes to set
	 */
	public void setAllergenes(List<Allergene> allergenes) {
		this.allergenes = allergenes;
	}

	/** Getter
	 * @return the additifs
	 */
	public List<Additif> getAdditifs() {
		return additifs;
	}

	/** Setter
	 * @param additifs the additifs to set
	 */
	public void setAdditifs(List<Additif> additifs) {
		this.additifs = additifs;
	}

	/** Getter
	 * @return the valeurNutrionnelle
	 */
	public ValeurNutrionnelle getValeurNutrionnelle() {
		return valeurNutrionnelle;
	}

	/** Setter
	 * @param valeurNutrionnelle the valeurNutrionnelle to set
	 */
	public void setValeurNutrionnelle(ValeurNutrionnelle valeurNutrionnelle) {
		this.valeurNutrionnelle = valeurNutrionnelle;
	}

	/** Getter
	 * @return the vitamine
	 */
	public Vitamine getVitamine() {
		return vitamine;
	}

	/** Setter
	 * @param vitamine the vitamine to set
	 */
	public void setVitamine(Vitamine vitamine) {
		this.vitamine = vitamine;
	}

	
	
}
