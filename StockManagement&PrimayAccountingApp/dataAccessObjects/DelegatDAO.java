package dataAccessObjects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;

import dataAccessLayer.ConnectionFactory;
import model.Delegat;

public class DelegatDAO extends AbstractDAO<Delegat> {

	/**
	 * A specific query to identify a delegate by his name
	 * 
	 * @return a string containing a query
	 */
	private String createFindByNameQuery(String name) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * FROM Delegat");
		sb.append(" WHERE nume LIKE \"");
		sb.append(name + "%\"");

		return sb.toString();
	}

	/**
	 * Calls and executes the FindByName query
	 * 
	 * @return
	 */
	public ArrayList<Delegat> findByName(String name) {
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
			LOGGER.log(Level.WARNING, "Find by name Delegate Error" + e.getMessage());
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return null;
	}
}
