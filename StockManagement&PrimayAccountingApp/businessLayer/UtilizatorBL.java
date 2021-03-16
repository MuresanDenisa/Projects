package businessLayer;

import java.util.ArrayList;

import dataAccessObjects.UtilizatorDAO;
import model.Utilizator;

public class UtilizatorBL {

	private UtilizatorDAO utilizatorDAO;
	private int maxUtilizatorId;

	// constructor
	public UtilizatorBL() {

		utilizatorDAO = new UtilizatorDAO();
		maxUtilizatorId = utilizatorDAO.findMaxId();
	}

	/**
	 * insert function
	 * 
	 * @param user
	 */
	public void insert(Utilizator user) {
		utilizatorDAO.insert(user);
	}

	public int findMaxId() {
		return utilizatorDAO.findMaxId();
	}

	/**
	 * list all function
	 * 
	 * @return
	 */
	public ArrayList<Utilizator> listAll() {

		return utilizatorDAO.findAll();
	}

	/**
	 * find by idName function
	 * 
	 * @param idName
	 * @return
	 */
	public Utilizator findByIdName(String idName) {
		ArrayList<Utilizator> users = utilizatorDAO.findByName(idName);

		if (users.size() == 0) {
			// System.out.println("Clientul cu numele " + name + " nu exista.");
			return null;
		} else
			return users.get(0);
	}

	// getters and setters
	public int getMaxUtilizatorId() {
		return maxUtilizatorId;
	}

	public void setMaxUtilizatorId(int maxUtilizatorId) {
		this.maxUtilizatorId = maxUtilizatorId;
	}

}