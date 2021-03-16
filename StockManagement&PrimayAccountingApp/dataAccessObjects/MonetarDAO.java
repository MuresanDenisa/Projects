package dataAccessObjects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;

import dataAccessLayer.ConnectionFactory;
import model.Monetar;

public class MonetarDAO extends AbstractDAO<Monetar> {

	/**
	 * A specific query to identify a monetary by his number
	 * 
	 * @return a string containing a query
	 */
	private String createFindByNumberQuery() {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * FROM Monetar");
		sb.append(" WHERE nrMonetar=?");

		return sb.toString();
	}

	/**
	 * Calls and executes the findByNumber query
	 * 
	 * @return
	 */
	public ArrayList<Monetar> findByNumber(int number) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = createFindByNumberQuery();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, number);
			resultSet = statement.executeQuery();
			return createObject(resultSet);
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "Find monetary by number Error" + e.getMessage());
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return null;
	}
}
