package businessLayer;

import java.util.ArrayList;

import dataAccessObjects.DelegatDAO;
import model.Delegat;

public class DelegatBL {

	private DelegatDAO delegatDAO;
	private int maxDelegatId;

	// constructor
	public DelegatBL() {
		delegatDAO = new DelegatDAO();
		maxDelegatId = delegatDAO.findMaxId();
	}

	/**
	 * insert function
	 * 
	 * @param delegat
	 */
	public void insertDelegat(Delegat delegat) {

		delegatDAO.insert(delegat);
	}

	/**
	 * Find by name function
	 * 
	 * @param name
	 * @return
	 */
	public Delegat findByName(String name) {

		ArrayList<Delegat> delegat = null;
		delegat = delegatDAO.findByName(name);

		if (delegat.size() == 0) {
			System.out.println("Delegatul cu numele " + name + " nu exista.");
			return null;
		} else
			return delegat.get(0);

	}

	/**
	 * find by id function
	 * 
	 * @param id
	 * @return
	 */
	public Delegat findById(int id) {

		Delegat delegat = delegatDAO.findById(id);

		if (delegat == null) {
			System.out.println("Delegatul cu id=" + id + " nu exista.");
			return null;
		} else
			return delegat;
	}

	/**
	 * find max id function
	 * 
	 * @return
	 */
	public int findMaxId() {

		return delegatDAO.findMaxId();
	}

	/**
	 * list all function
	 * 
	 * @return
	 */
	public ArrayList<Delegat> listAll() {

		return delegatDAO.findAll();
	}

	// getters and setters
	public int getMaxDelegatId() {
		return maxDelegatId;
	}

	public void setMaxDelegatId(int maxDelegatId) {
		this.maxDelegatId = maxDelegatId;
	}

}
