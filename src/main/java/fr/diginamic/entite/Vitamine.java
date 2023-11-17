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
@Table(name = "Vitamine")
public class Vitamine {

	/** id */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	/** vitA100g */
	private double vitA100g;
	/** vitD100g */
	private double vitD100g;
	/** vitE100g */
	private double vitE100g;
	/** vitK100g */
	private double vitK100g;
	/** vitC100g */
	private double vitC100g;
	/** vitB1j100g */
	private double vitB1j100g;
	/** vitB2100g */
	private double vitB2100g;
	/** vitPP100g */
	private double vitPP100g;
	/** vitB6100g */
	private double vitB6100g;
	/** vitB9100g */
	private double vitB9100g;
	/** vitB12100g */
	private double vitB12100g;
	
	
	/** Constructor
	 * 
	 */
	public Vitamine() {
		super();
	}

	/** Constructor
	 * @param vitA100g
	 * @param vitD100g
	 * @param vitE100g
	 * @param vitK100g
	 * @param vitC100g
	 * @param vitB1j100g
	 * @param vitB2100g
	 * @param vitPP100g
	 * @param vitB6100g
	 * @param vitB9100g
	 * @param vitB12100g
	 */
	public Vitamine(double vitA100g, double vitD100g, double vitE100g, double vitK100g, double vitC100g,
			double vitB1j100g, double vitB2100g, double vitPP100g, double vitB6100g, double vitB9100g,
			double vitB12100g) {
		super();
		this.vitA100g = vitA100g;
		this.vitD100g = vitD100g;
		this.vitE100g = vitE100g;
		this.vitK100g = vitK100g;
		this.vitC100g = vitC100g;
		this.vitB1j100g = vitB1j100g;
		this.vitB2100g = vitB2100g;
		this.vitPP100g = vitPP100g;
		this.vitB6100g = vitB6100g;
		this.vitB9100g = vitB9100g;
		this.vitB12100g = vitB12100g;
	}

	/** toString
	 * @return Vitamine affichage
	 */
	@Override
	public String toString() {
		return "Vitamine [id=" + id + ", vitA100g=" + vitA100g + ", vitD100g=" + vitD100g + ", vitE100g=" + vitE100g
				+ ", vitK100g=" + vitK100g + ", vitC100g=" + vitC100g + ", vitB1j100g=" + vitB1j100g + ", vitB2100g="
				+ vitB2100g + ", vitPP100g=" + vitPP100g + ", vitB6100g=" + vitB6100g + ", vitB9100g=" + vitB9100g
				+ ", vitB12100g=" + vitB12100g + "]";
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
	 * @return the vitA100g
	 */
	public double getVitA100g() {
		return vitA100g;
	}

	/** Setter
	 * @param vitA100g the vitA100g to set
	 */
	public void setVitA100g(double vitA100g) {
		this.vitA100g = vitA100g;
	}

	/** Getter
	 * @return the vitD100g
	 */
	public double getVitD100g() {
		return vitD100g;
	}

	/** Setter
	 * @param vitD100g the vitD100g to set
	 */
	public void setVitD100g(double vitD100g) {
		this.vitD100g = vitD100g;
	}

	/** Getter
	 * @return the vitE100g
	 */
	public double getVitE100g() {
		return vitE100g;
	}

	/** Setter
	 * @param vitE100g the vitE100g to set
	 */
	public void setVitE100g(double vitE100g) {
		this.vitE100g = vitE100g;
	}

	/** Getter
	 * @return the vitK100g
	 */
	public double getVitK100g() {
		return vitK100g;
	}

	/** Setter
	 * @param vitK100g the vitK100g to set
	 */
	public void setVitK100g(double vitK100g) {
		this.vitK100g = vitK100g;
	}

	/** Getter
	 * @return the vitC100g
	 */
	public double getVitC100g() {
		return vitC100g;
	}

	/** Setter
	 * @param vitC100g the vitC100g to set
	 */
	public void setVitC100g(double vitC100g) {
		this.vitC100g = vitC100g;
	}

	/** Getter
	 * @return the vitB1j100g
	 */
	public double getVitB1j100g() {
		return vitB1j100g;
	}

	/** Setter
	 * @param vitB1j100g the vitB1j100g to set
	 */
	public void setVitB1j100g(double vitB1j100g) {
		this.vitB1j100g = vitB1j100g;
	}

	/** Getter
	 * @return the vitB2100g
	 */
	public double getVitB2100g() {
		return vitB2100g;
	}

	/** Setter
	 * @param vitB2100g the vitB2100g to set
	 */
	public void setVitB2100g(double vitB2100g) {
		this.vitB2100g = vitB2100g;
	}

	/** Getter
	 * @return the vitPP100g
	 */
	public double getVitPP100g() {
		return vitPP100g;
	}

	/** Setter
	 * @param vitPP100g the vitPP100g to set
	 */
	public void setVitPP100g(double vitPP100g) {
		this.vitPP100g = vitPP100g;
	}

	/** Getter
	 * @return the vitB6100g
	 */
	public double getVitB6100g() {
		return vitB6100g;
	}

	/** Setter
	 * @param vitB6100g the vitB6100g to set
	 */
	public void setVitB6100g(double vitB6100g) {
		this.vitB6100g = vitB6100g;
	}

	/** Getter
	 * @return the vitB9100g
	 */
	public double getVitB9100g() {
		return vitB9100g;
	}

	/** Setter
	 * @param vitB9100g the vitB9100g to set
	 */
	public void setVitB9100g(double vitB9100g) {
		this.vitB9100g = vitB9100g;
	}

	/** Getter
	 * @return the vitB12100g
	 */
	public double getVitB12100g() {
		return vitB12100g;
	}

	/** Setter
	 * @param vitB12100g the vitB12100g to set
	 */
	public void setVitB12100g(double vitB12100g) {
		this.vitB12100g = vitB12100g;
	}
	
	
}
