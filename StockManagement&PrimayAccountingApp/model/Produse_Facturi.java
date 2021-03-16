package model;

public class Produse_Facturi {

	private int idFactura;
	private int idProdus;
	private int cantitate;
	private float valoare;

	// Constructors
	public Produse_Facturi() {

	}

	public Produse_Facturi(int idF, int idP, int cant, float val) {

		setIdFactura(idF);
		setIdProdus(idP);
		setCantitate(cant);
		setValoare(val);
	}
	// getters and setters

	public int getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
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
