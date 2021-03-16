package model;

public class Client {

	private int idClient;
	private String client;
	private String reg_com;
	private String cif;
	private String capital;
	private String sediul;
	private String judetul;
	private String cod_iban;
	private String banca;

	// Constructors
	public Client() {

	}

	public Client(int id, String nume, String reg, String cif, String capital, String sediu, String judet, String iban,
			String banca) {

		setIdClient(id);
		setClient(nume);
		setReg_com(reg);
		setCif(cif);
		setCapital(capital);
		setSediul(sediu);
		setJudetul(judet);
		setCod_iban(iban);
		setBanca(banca);

	}

	public String toString() {

//		return "" + idClient + " " + client + " " + reg_com + " " + cif + " " + capital + " " + sediul + " " + cod_iban
//				+ " " + banca + "\n";
		return client;
	}

	// getters and setters
	public String getJudetul() {
		return judetul;
	}

	public void setJudetul(String judetul) {
		this.judetul = judetul;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getReg_com() {
		return reg_com;
	}

	public void setReg_com(String reg_com) {
		this.reg_com = reg_com;
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getSediul() {
		return sediul;
	}

	public void setSediul(String sediul) {
		this.sediul = sediul;
	}

	public String getCod_iban() {
		return cod_iban;
	}

	public void setCod_iban(String cod_iban) {
		this.cod_iban = cod_iban;
	}

	public String getBanca() {
		return banca;
	}

	public void setBanca(String banca) {
		this.banca = banca;
	}

}
