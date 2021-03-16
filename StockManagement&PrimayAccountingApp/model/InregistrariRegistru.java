package model;

public class InregistrariRegistru {

	private int nrCurent;
	private String denumire;
	private float incasari;
	private float plati;

	// Constructors
	public InregistrariRegistru() {

	}

	public InregistrariRegistru(int nr, String nume, float incasari, float plati) {
		this.setNrCurent(nr);
		this.setDenumire(nume);
		this.setIncasari(incasari);
		this.setPlati(plati);
	}

	// getters and setters

	public int getNrCurent() {
		return nrCurent;
	}

	public void setNrCurent(int nrCurent) {
		this.nrCurent = nrCurent;
	}

	public String getDenumire() {
		return denumire;
	}

	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}

	public float getIncasari() {
		return incasari;
	}

	public void setIncasari(float incasari) {
		this.incasari = incasari;
	}

	public float getPlati() {
		return plati;
	}

	public void setPlati(float plati) {
		this.plati = plati;
	}
}
