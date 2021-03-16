package businessLayer;

import java.util.ArrayList;

import dataAccessObjects.ClientDAO;
import model.Client;

public class ClientBL {

	private ClientDAO clientDAO;
	private int maxClientId;

	// constructor
	public ClientBL() {
		clientDAO = new ClientDAO();
		maxClientId = clientDAO.findMaxId();
	}

	/**
	 * Insert function
	 * 
	 * @param newClient
	 */
	public void insertClient(Client newClient) {

		clientDAO.insert(newClient);
	}

	/**
	 * find by name function
	 * 
	 * @param name
	 * @return
	 */
	public Client findByName(String name) {

		ArrayList<Client> clients = clientDAO.findByName(name);

		if (clients.size() == 0) {
			// System.out.println("Clientul cu numele " + name + " nu exista.");
			return null;
		} else
			return clients.get(0);
	}

	/**
	 * find by id function
	 * 
	 * @param id
	 * @return
	 */
	public Client findById(int id) {

		Client client = clientDAO.findById(id);

		if (client == null) {
			System.out.println("Clientul cu id=" + id + " nu exista.");
			return null;
		} else
			return client;
	}

	/**
	 * find max id function
	 * 
	 * @return
	 */
	public int findMaxId() {

		return clientDAO.findMaxId();
	}

	/**
	 * list all function
	 * 
	 * @return
	 */
	public ArrayList<Client> listAll() {

		return clientDAO.findAll();
	}

	// getters and setters
	public int getMaxClientId() {
		return maxClientId;
	}

	public void setMaxClientId(int maxClientId) {
		this.maxClientId = maxClientId;
	}

}
