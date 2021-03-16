package model;

public class Monetar {

	private int idMonetar;
	private int nrMonetar;
	private String data;
	private float total;

	// Constructors
	public Monetar() {

	}

	public Monetar(int id, int numar, String data, float total) {
		this.setIdMonetar(id);
		this.setNrMonetar(numar);
		this.setData(data);
		this.setTotal(total);
	}

	// getters and setters

	public int getIdMonetar() {
		return idMonetar;
	}

	public void setIdMonetar(int idMonetar) {
		this.idMonetar = idMonetar;
	}

	public int getNrMonetar() {
		return nrMonetar;
	}

	public void setNrMonetar(int nrMoentar) {
		this.nrMonetar = nrMoentar;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

}
