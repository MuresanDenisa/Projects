package model;

public class Facturi {

	private int idFactura;
	private int nrFactura;
	private String data;
	private int idClient;
	private int idDelegat;
	private float valoare;
	private float valoareTVA;
	private float total;

	// Constructors
	public Facturi() {

	}

	public Facturi(int idFact, int nrFact, String data, int idClient, int idDelegat, float valoare, float valoareTVA,
			float total) {
		this.setIdFactura(idFact);
		this.setNrFactura(nrFact);
		this.setData(data);
		this.setIdClient(idClient);
		this.setIdDelegat(idDelegat);
		this.setValoare(valoare);
		this.setValoareTVA(valoareTVA);
		this.setTotal(total);
	}

	public String toString() {

		return "" + idFactura + " " + nrFactura + " " + data + " " + idClient + " " + idDelegat + " " + valoare + " "
				+ valoareTVA + " " + total;
	}

	// getters and settters

	public int getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(int idFacturi) {
		this.idFactura = idFacturi;
	}

	public int getNrFactura() {
		return nrFactura;
	}

	public void setNrFactura(int nrFactura) {
		this.nrFactura = nrFactura;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public int getIdDelegat() {
		return idDelegat;
	}

	public void setIdDelegat(int idDelegat) {
		this.idDelegat = idDelegat;
	}

	public float getValoare() {
		return valoare;
	}

	public void setValoare(float valoare) {
		this.valoare = valoare;
	}

	public float getValoareTVA() {
		return valoareTVA;
	}

	public void setValoareTVA(float valoareTVA) {
		this.valoareTVA = valoareTVA;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public void generatePDF(Facturi factura, Produs products, Delegat delegat, Furnizor furnizor) {

	}
}
