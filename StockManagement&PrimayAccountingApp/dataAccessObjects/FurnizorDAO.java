package dataAccessObjects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;

import dataAccessLayer.ConnectionFactory;
import model.Furnizor;

public class FurnizorDAO extends AbstractDAO<Furnizor> {

	/**
	 * A specific query to identify a manufacturer by his name
	 * 
	 * @return a string containing a query
	 */
	private String createFindByNameQuery(String name) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * FROM Furnizor");
		sb.append(" WHERE furnizor LIKE \"");
		sb.append(name + "%\"");

		return sb.toString();
	}

	/**
	 * Calls and executes the FindByName query
	 * 
	 * @return
	 */
	public ArrayList<Furnizor> findByName(String name) {
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
			LOGGER.log(Level.WARNING, "Find by name manufacturer Error" + e.getMessage());
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return null;
	}
}
