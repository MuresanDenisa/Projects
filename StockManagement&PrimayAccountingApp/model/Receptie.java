package model;

public class Receptie {

	private int idReceptie;
	private String unitate;
	private int nrReceptie;
	private String dataReceptie;
	private int nrFactura;
	private float totalFactura;
	private String dataFactura;
	private int idFurnizor;
	private float totalReceptie;

	// Constructors
	public Receptie() {

	}

	public Receptie(int id, String unitate, int nrRec, String dataRec, int nrfact, float totalFact, String dataFact,
			int idFurn, float total) {

		this.setIdReceptie(id);
		this.setUnitate(unitate);
		this.setNrReceptie(nrRec);
		this.setDataReceptie(dataRec);
		this.setNrFactura(nrfact);
		this.setTotalFactura(totalFact);
		this.setDataFactura(dataFact);
		this.setIdFurnizor(idFurn);
		this.setTotalReceptie(total);
	}

	public String toString() {

		return "" + idReceptie + " " + unitate + " " + nrReceptie + " " + dataReceptie + " " + nrFactura + " "
				+ totalFactura + " " + dataFactura + " " + idFurnizor + " " + totalReceptie;
	}

	// getters and setters

	public int getIdReceptie() {
		return idReceptie;
	}

	public void setIdReceptie(int idReceptie) {
		this.idReceptie = idReceptie;
	}

	public String getUnitate() {
		return unitate;
	}

	public void setUnitate(String unitate) {
		this.unitate = unitate;
	}

	public int getNrReceptie() {
		return nrReceptie;
	}

	public void setNrReceptie(int nrReceptie) {
		this.nrReceptie = nrReceptie;
	}

	public String getDataReceptie() {
		return dataReceptie;
	}

	public void setDataReceptie(String dataReceptie) {
		this.dataReceptie = dataReceptie;
	}

	public int getNrFactura() {
		return nrFactura;
	}

	public void setNrFactura(int nrFactura) {
		this.nrFactura = nrFactura;
	}

	public float getTotalFactura() {
		return totalFactura;
	}

	public void setTotalFactura(float totalFactura) {
		this.totalFactura = totalFactura;
	}

	public String getDataFactura() {
		return dataFactura;
	}

	public void setDataFactura(String dataFactura) {
		this.dataFactura = dataFactura;
	}

	public int getIdFurnizor() {
		return idFurnizor;
	}

	public void setIdFurnizor(int idFurnizor) {
		this.idFurnizor = idFurnizor;
	}

	public float getTotalReceptie() {
		return totalReceptie;
	}

	public void setTotalReceptie(float totalReceptie) {
		this.totalReceptie = totalReceptie;
	}

}
