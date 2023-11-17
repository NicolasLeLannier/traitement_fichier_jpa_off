package fr.diginamic.entite;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author lelan
 *
 */
@Entity
@Table(name = "ValeurNutrionnelle")
public class ValeurNutritionnelle {

	/** id */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	/** energie100g */
	private Double energie100g;
	/** graisse100g */
	private double graisse100g;
	/** sucres100g */
	private double sucres100g;
	/** fibres100g */
	private double fibres100g;
	/** proteines100g */
	private double proteines100g;
	/** sel100g */
	private double sel100g;
	/** calcium100g */
	private double calcium100g;
	/** magnesium100g */
	private double magnesium100g;
	/** iron100g */
	private double iron100g;
	/** fer100g */
	private double fer100g;
	/** betaCarotene100g */
	private double betaCarotene100g;
	
	/** Constructor
	 * 
	 */
	public ValeurNutritionnelle() {
		super();
	}

	/** Constructor
	 * @param energie100g
	 * @param graisse100g
	 * @param sucres100g
	 * @param fibres100g
	 * @param proteines100g
	 * @param sel100g
	 * @param calcium100g
	 * @param magnesium100g
	 * @param iron100g
	 * @param fer100g
	 * @param betaCarotene100g
	 */
	public ValeurNutritionnelle(Double energie100g, double graisse100g, double sucres100g, double fibres100g,
			double proteines100g, double sel100g, double calcium100g, double magnesium100g, double iron100g,
			double fer100g, double betaCarotene100g) {
		super();
		this.energie100g = energie100g;
		this.graisse100g = graisse100g;
		this.sucres100g = sucres100g;
		this.fibres100g = fibres100g;
		this.proteines100g = proteines100g;
		this.sel100g = sel100g;
		this.calcium100g = calcium100g;
		this.magnesium100g = magnesium100g;
		this.iron100g = iron100g;
		this.fer100g = fer100g;
		this.betaCarotene100g = betaCarotene100g;
	}

	/** toString
	 * @return ValeurNutrionnelle affichage
	 */
	@Override
	public String toString() {
		return "ValeurNutrionnelle [id=" + id + ", energie100g=" + energie100g + ", graisse100g=" + graisse100g
				+ ", sucres100g=" + sucres100g + ", fibres100g=" + fibres100g + ", proteines100g=" + proteines100g
				+ ", sel100g=" + sel100g + ", calcium100g=" + calcium100g + ", magnesium100g=" + magnesium100g
				+ ", iron100g=" + iron100g + ", fer100g=" + fer100g + ", betaCarotene100g=" + betaCarotene100g + "]";
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
	 * @return the energie100g
	 */
	public Double getEnergie100g() {
		return energie100g;
	}

	/** Setter
	 * @param energie100g the energie100g to set
	 */
	public void setEnergie100g(Double energie100g) {
		this.energie100g = energie100g;
	}

	/** Getter
	 * @return the graisse100g
	 */
	public double getGraisse100g() {
		return graisse100g;
	}

	/** Setter
	 * @param graisse100g the graisse100g to set
	 */
	public void setGraisse100g(double graisse100g) {
		this.graisse100g = graisse100g;
	}

	/** Getter
	 * @return the sucres100g
	 */
	public double getSucres100g() {
		return sucres100g;
	}

	/** Setter
	 * @param sucres100g the sucres100g to set
	 */
	public void setSucres100g(double sucres100g) {
		this.sucres100g = sucres100g;
	}

	/** Getter
	 * @return the fibres100g
	 */
	public double getFibres100g() {
		return fibres100g;
	}

	/** Setter
	 * @param fibres100g the fibres100g to set
	 */
	public void setFibres100g(double fibres100g) {
		this.fibres100g = fibres100g;
	}

	/** Getter
	 * @return the proteines100g
	 */
	public double getProteines100g() {
		return proteines100g;
	}

	/** Setter
	 * @param proteines100g the proteines100g to set
	 */
	public void setProteines100g(double proteines100g) {
		this.proteines100g = proteines100g;
	}

	/** Getter
	 * @return the sel100g
	 */
	public double getSel100g() {
		return sel100g;
	}

	/** Setter
	 * @param sel100g the sel100g to set
	 */
	public void setSel100g(double sel100g) {
		this.sel100g = sel100g;
	}

	/** Getter
	 * @return the calcium100g
	 */
	public double getCalcium100g() {
		return calcium100g;
	}

	/** Setter
	 * @param calcium100g the calcium100g to set
	 */
	public void setCalcium100g(double calcium100g) {
		this.calcium100g = calcium100g;
	}

	/** Getter
	 * @return the magnesium100g
	 */
	public double getMagnesium100g() {
		return magnesium100g;
	}

	/** Setter
	 * @param magnesium100g the magnesium100g to set
	 */
	public void setMagnesium100g(double magnesium100g) {
		this.magnesium100g = magnesium100g;
	}

	/** Getter
	 * @return the iron100g
	 */
	public double getIron100g() {
		return iron100g;
	}

	/** Setter
	 * @param iron100g the iron100g to set
	 */
	public void setIron100g(double iron100g) {
		this.iron100g = iron100g;
	}

	/** Getter
	 * @return the fer100g
	 */
	public double getFer100g() {
		return fer100g;
	}

	/** Setter
	 * @param fer100g the fer100g to set
	 */
	public void setFer100g(double fer100g) {
		this.fer100g = fer100g;
	}

	/** Getter
	 * @return the betaCarotene100g
	 */
	public double getBetaCarotene100g() {
		return betaCarotene100g;
	}

	/** Setter
	 * @param betaCarotene100g the betaCarotene100g to set
	 */
	public void setBetaCarotene100g(double betaCarotene100g) {
		this.betaCarotene100g = betaCarotene100g;
	}
	
}
