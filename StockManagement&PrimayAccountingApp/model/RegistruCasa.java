package model;

public class RegistruCasa {

	private int idRegistru;
	private String data;
	private int nrPoz;
	private float soldInitial;
	private float incasari;
	private float plati;
	private float soldFinal;
	private int nrCurent;
	private int nextNrCurent;

	// Constructors
	public RegistruCasa() {

	}

	public RegistruCasa(int idRegistru, String data, int nrPoz, float soldInitial, float incasari, float plati,
			float soldF, int nrC, int nextNrC) {
		this.setIdRegistru(idRegistru);
		this.setData(data);
		this.setNrPoz(nrPoz);
		this.setSoldInitial(soldInitial);
		this.setIncasari(incasari);
		this.setPlati(plati);
		this.setSoldFinal(soldF);
		this.setNrCurent(nrC);
		this.setNextNrCurent(nextNrC);
	}

	// getters and setters

	public int getIdRegistru() {
		return idRegistru;
	}

	public int getNextNrCurent() {
		return nextNrCurent;
	}

	public void setNextNrCurent(int nextNrCurent) {
		this.nextNrCurent = nextNrCurent;
	}

	public int getNrCurent() {
		return nrCurent;
	}

	public void setNrCurent(int nrCurent) {
		this.nrCurent = nrCurent;
	}

	public void setIdRegistru(int idRegistru) {
		this.idRegistru = idRegistru;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getNrPoz() {
		return nrPoz;
	}

	public void setNrPoz(int nrPoz) {
		this.nrPoz = nrPoz;
	}

	public float getSoldInitial() {
		return soldInitial;
	}

	public void setSoldInitial(float soldInitial) {
		this.soldInitial = soldInitial;
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

	public float getSoldFinal() {
		return soldFinal;
	}

	public void setSoldFinal(float soldFinal) {
		this.soldFinal = soldFinal;
	}

}
