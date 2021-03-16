package model;

public class Produse_Receptie {

	private int idReceptie;
	private int idProdus;
	private int cantitate;
	private float valoare;

	// Constructors
	public Produse_Receptie() {

	}

	public Produse_Receptie(int idR, int idP, int cant, float val) {
		setIdReceptie(idR);
		setIdProdus(idP);
		setCantitate(cant);
		setValoare(val);
	}

	// getters and setters

	public int getIdReceptie() {
		return idReceptie;
	}

	public void setIdReceptie(int idReceptie) {
		this.idReceptie = idReceptie;
	}

	public int getIdProdus() {
		return idProdus;
	}

	public void setIdProdus(int idProdus) {
		this.idProdus = idProdus;
	}

	public int getCantitate() {
		return cantitate;
	}

	public void setCantitate(int cantitate) {
		this.cantitate = cantitate;
	}

	public float getValoare() {
		return valoare;
	}

	public void setValoare(float valoare) {
		this.valoare = valoare;
	}

}
