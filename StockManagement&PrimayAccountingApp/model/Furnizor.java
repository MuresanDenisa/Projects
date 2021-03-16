package model;

public class Furnizor {

	private int idFurnizor;
	private String furnizor;
	private String reg_com;
	private String cif;
	private String capital;
	private String sediul;
	private String judetul;
	private String cod_iban;
	private String banca;

	// Constructors
	public Furnizor() {

	}

	public Furnizor(int id, String nume, String reg, String cif, String capital, String sediu, String judet,
			String iban, String banca) {

		setIdFurnizor(id);
		setFurnizor(nume);
		setReg_com(reg);
		setCif(cif);
		setCapital(capital);
		setJudetul(judet);
		setSediul(sediu);
		setCod_iban(iban);
		setBanca(banca);

	}

//	public String toString() {
//
//		return "" + idFurnizor + " " + furnizor + " " + reg_com + " " + cif + " " + capital + " " + sediul + " "
//				+ cod_iban + " " + banca + "\n";
//	}

	public String toString() {
		return furnizor;

	}
	// getters and setters

	public int getIdFurnizor() {
		return idFurnizor;
	}

	public String getJudetul() {
		return judetul;
	}

	public void setJudetul(String judet) {
		this.judetul = judet;
	}

	public void setIdFurnizor(int idFurnizor) {
		this.idFurnizor = idFurnizor;
	}

	public String getFurnizor() {
		return furnizor;
	}

	public void setFurnizor(String furnizor) {
		this.furnizor = furnizor;
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
