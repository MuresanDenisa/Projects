package dataAccessObjects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;

import dataAccessLayer.ConnectionFactory;
import model.Client;

public class ClientDAO extends AbstractDAO<Client> {

	/**
	 * A specific query to identify a client by his name
	 * 
	 * @return a string containing a query
	 */
	private String createFindByNameQuery(String name) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * FROM Client");
		sb.append(" WHERE client LIKE \"");
		sb.append(name + "\"");

		return sb.toString();
	}

	/**
	 * Calls and executes the FindByName query
	 * 
	 * @return
	 */
	public ArrayList<Client> findByName(String name) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = createFindByNameQuery(name);
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			resultSet = statement.executeQuery();
			return createObject(resultSet);
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "Find by name Client Error" + e.getMessage());
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return null;
	}
}
