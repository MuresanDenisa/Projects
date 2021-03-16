package businessLayer;

import dataAccessObjects.Produse_FacturiDAO;
import model.Produse_Facturi;

public class Produse_FacturiBL {

	private Produse_FacturiDAO produse_facturiDAO;

	// constructor
	public Produse_FacturiBL() {

		produse_facturiDAO = new Produse_FacturiDAO();
	}

	/**
	 * Insert function
	 * 
	 * @param inregistrare
	 */
	public void insert(Produse_Facturi inregistrare) {

		produse_facturiDAO.insert(inregistrare);
	}
}
