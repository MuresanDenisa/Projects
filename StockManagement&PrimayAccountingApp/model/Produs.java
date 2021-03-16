package model;

public class Produs {

	private int idProdus;
	private String denumire;
	private String um;
	private int cantitate;
	private int procent;
	private float pret_fara_TVA;
	private float pret_vanzare;

	// Constructors
	public Produs() {

	}

	public Produs(int id, String nume, String um, int cantitate, int procent, float pret, float pret_vanzare) {

		setIdProdus(id);
		setDenumire(nume);
		setUm(um);
		setCantitate(cantitate);
		setProcent(procent);
		setPret_fara_TVA(pret);
		setPret_vanzare(pret_vanzare);
	}

	public String toString() {

		return this.idProdus + " " + this.denumire + " " + this.um + " " + this.cantitate + " " + this.procent + " "
				+ this.pret_fara_TVA + " " + this.pret_vanzare + "\n";
	}

//	public String toString() {
//		return "" + this.denumire + " " + this.pret_vanzare;
//	}

	// getters and setters

	public int getIdProdus() {
		return idProdus;
	}

	public void setIdProdus(int idProdus) {
		this.idProdus = idProdus;
	}

	public int getProcent() {
		return procent;
	}

	public void setProcent(int procent) {
		this.procent = procent;
	}

	public String getDenumire() {
		return denumire;
	}

	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}

	public String getUm() {
		return um;
	}

	public void setUm(String um) {
		this.um = um;
	}

	public int getCantitate() {
		return cantitate;
	}

	public void setCantitate(int cantitate) {
		this.cantitate = cantitate;
	}

	public float getPret_fara_TVA() {
		return pret_fara_TVA;
	}

	public void setPret_fara_TVA(float pret_fara_TVA) {
		this.pret_fara_TVA = pret_fara_TVA;
	}

	public float getPret_vanzare() {
		return pret_vanzare;
	}

	public void setPret_vanzare(float pret_vanzare) {
		this.pret_vanzare = pret_vanzare;
	}
}
