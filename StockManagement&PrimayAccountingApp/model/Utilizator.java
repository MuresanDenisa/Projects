package model;

public class Utilizator {

	private int idUtilizator;
	private String id;
	private String nume;
	private String parola;
	private int administrator;

	// Constructors
	public Utilizator() {

	}

	public Utilizator(int idUtil, String id, String nume, String parola, int adm) {
		setIdUtilizator(idUtil);
		setId(id);
		setNume(nume);
		setParola(parola);
		setAdministrator(adm);
	}

	// getters and setters

	public int getIdUtilizator() {
		return idUtilizator;
	}

	public String getId() {
		return id;
	}

	public int getAdministrator() {
		return administrator;
	}

	public void setAdministrator(int administrator) {
		this.administrator = administrator;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setIdUtilizator(int idUtilizator) {
		this.idUtilizator = idUtilizator;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getParola() {
		return parola;
	}

	public void setParola(String parola) {
		this.parola = parola;
	}
}
