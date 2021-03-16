package businessLayer;

import java.util.ArrayList;

import dataAccessObjects.FurnizorDAO;
import model.Furnizor;

public class FurnizorBL {

	private FurnizorDAO furnizorDAO;
	private int maxFurnizorId;

	// constructor
	public FurnizorBL() {
		furnizorDAO = new FurnizorDAO();
		maxFurnizorId = furnizorDAO.findMaxId();
	}

	/**
	 * insert function
	 * 
	 * @param furnizor
	 */
	public void insertFurnizor(Furnizor furnizor) {

		furnizorDAO.insert(furnizor);
	}

	/**
	 * find by name function
	 * 
	 * @param name
	 * @return
	 */
	public Furnizor findByName(String name) {

		ArrayList<Furnizor> furnizor = null;
		furnizor = furnizorDAO.findByName(name);

		if (furnizor.size() == 0) {
			System.out.println("Furnizorul cu numele " + name + " nu exista.");
			return null;
		} else
			return furnizor.get(0);
	}

	/**
	 * find by id function
	 * 
	 * @param id
	 * @return
	 */
	public Furnizor findById(int id) {

		Furnizor furnizor = furnizorDAO.findById(id);

		if (furnizor == null) {
			System.out.println("Furnizorul cu id=" + id + " nu exista.");
			return null;
		} else
			return furnizor;
	}

	/**
	 * find max id
	 * 
	 * @return
	 */
	public int findMaxId() {

		return furnizorDAO.findMaxId();
	}

	/**
	 * list all function
	 * 
	 * @return
	 */
	public ArrayList<Furnizor> listAll() {
		return furnizorDAO.findAll();
	}

	// setters and getters
	public int getMaxFurnizorId() {
		return maxFurnizorId;
	}

	public void setMaxFurnizorId(int maxFurnizorId) {
		this.maxFurnizorId = maxFurnizorId;
	}

}
