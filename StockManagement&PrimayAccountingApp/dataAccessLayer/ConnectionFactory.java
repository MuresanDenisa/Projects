package dataAccessLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactory {

	private static final Logger LOGGER = Logger.getLogger(ConnectionFactory.class.getName());
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String DBURL = "jdbc:mysql://127.0.0.1:3306/nidarom" + "?useSSL=false";
	private static final String USER = "root";
	private static final String PASS = "root";

	private static ConnectionFactory singleInstance = new ConnectionFactory();

	private ConnectionFactory() {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * creates a connection to the database
	 * 
	 * @return connection to the given database
	 */
	private Connection createConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(DBURL, USER, PASS);
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "Error occured while establishing the connection to the database");
		}
		return connection;
	}

	public static Connection getConnection() {
		return singleInstance.createConnection();
	}

	public static void close(Connection connection) {

		if (connection != null)
			try {
				connection.close();
			} catch (SQLException e) {
				LOGGER.log(Level.WARNING, "Error occured while closing the connection to the database");
			}
	}

	public static void close(Statement statement) {

		if (statement != null)
			try {
				statement.close();
			} catch (SQLException e) {
				LOGGER.log(Level.WARNING, "Error occured while closing the statement");
			}
	}

	public static void close(ResultSet resultSet) {

		if (resultSet != null)
			try {
				resultSet.close();
			} catch (SQLException e) {
				LOGGER.log(Level.WARNING, "Error occured while closing the resultSet");
			}
	}

}