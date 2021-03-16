package model;

public class Delegat {

	private int idDelegat;
	private String nume;
	private String serie;
	private String numar;

	// Constructors
	public Delegat() {

	}

	public Delegat(int id, String nume, String serie, String numar) {
		setIdDelegat(id);
		setNume(nume);
		setSerie(serie);
		setNumar(numar);
	}

	public String toString() {

		return "" + nume + " " + serie + " " + numar + "\n";
	}

	// getters and setters
	public int getIdDelegat() {
		return idDelegat;
	}

	public void setIdDelegat(int idDelegat) {
		this.idDelegat = idDelegat;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getNumar() {
		return numar;
	}

	public void setNumar(String numar) {
		this.numar = numar;
	}

}
