package businessLayer;

import dataAccessObjects.Produse_ReceptieDAO;
import model.Produse_Receptie;

public class Produse_ReceptieBL {

	private Produse_ReceptieDAO produse_receptieDAO;

	// constructor
	public Produse_ReceptieBL() {

		produse_receptieDAO = new Produse_ReceptieDAO();

	}

	/**
	 * insert function
	 * 
	 * @param inregistrare
	 */
	public void insert(Produse_Receptie inregistrare) {

		produse_receptieDAO.insert(inregistrare);
	}
}
