package dataAccessObjects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;

import dataAccessLayer.ConnectionFactory;
import model.Utilizator;

public class UtilizatorDAO extends AbstractDAO<Utilizator> {

	/**
	 * A specific query to identify an user by his nameId
	 * 
	 * @return a string containing a query
	 */
	private String createFindByNameIdQuery(String name) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * FROM Utilizator");
		sb.append(" WHERE id LIKE \"");
		sb.append(name + "\"");

		return sb.toString();
	}

	/**
	 * Calls and executes the FindByNameID query
	 * 
	 * @return
	 */
	public ArrayList<Utilizator> findByName(String name) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = createFindByNameIdQuery(name);
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
