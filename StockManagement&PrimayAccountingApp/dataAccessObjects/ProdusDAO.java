package dataAccessObjects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;

import dataAccessLayer.ConnectionFactory;
import model.Produs;

public class ProdusDAO extends AbstractDAO<Produs> {

	/**
	 * A specific query to identify the products in a given reception
	 * 
	 * @return a string containing a query
	 */
	private String findProductsRQuery() {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT p.idProdus, p.denumire, p.um, pr.cantitate, p.procent, p.pret_fara_TVA, p.pret_vanzare ");
		sb.append("FROM produs as p INNER JOIN produse_receptie as pr ON p.idProdus= pr.idProdus ");
		sb.append("WHERE pr.idReceptie=? ;");

		return sb.toString();
	}

	/**
	 * Calls and executes the findProducts in reception Query
	 * 
	 * @param idF
	 * @return
	 */
	public ArrayList<Produs> findProductsR(int idF) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = findProductsRQuery();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, idF);
			resultSet = statement.executeQuery();
			return createObject(resultSet);
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "Find products in a recepption error" + e.getMessage());
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return null;
	}

	/**
	 * A specific query to identify the products in a given invoice
	 * 
	 * @return a string containing a query
	 */
	private String findProductsFQuery() {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT p.idProdus, p.denumire, p.um, pf.cantitate, p.procent, p.pret_fara_TVA, p.pret_vanzare ");
		sb.append("FROM produs as p INNER JOIN produse_facturi as pf ON p.idProdus= pf.idProdus ");
		sb.append("WHERE pf.idFactura=? ;");

		return sb.toString();
	}

	/**
	 * Calls and executes the FindProducts in an Invoice query
	 * 
	 * @param idF
	 * @return
	 */
	public ArrayList<Produs> findProductsF(int idF) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = findProductsFQuery();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, idF);
			resultSet = statement.executeQuery();
			return createObject(resultSet);
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "Find products in an invoice error" + e.getMessage());
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return null;
	}

	/**
	 * A specific increase query for a products's quantity
	 * 
	 * @return a string containing a query
	 */
	private String createUpdatePlusQuery(String name) {
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE Produs");
		sb.append(" SET cantitate=cantitate+?");
		sb.append(" WHERE CAST(pret_fara_TVA AS DECIMAL) = CAST(? AS DECIMAL) AND denumire LIKE \"");
		sb.append(name + "\"");

		return sb.toString();
	}

	/**
	 * Calls and executes the increase query for quantity
	 * 
	 * @param id
	 * @param newQuantity
	 */
	public void updatePlus(String name, float price, int newQuantity) {
		Connection connection = null;
		PreparedStatement statement = null;
		String query = createUpdatePlusQuery(name);
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, newQuantity);
			statement.setFloat(2, price);
			statement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "Update product error" + e.getMessage());
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
	}

	/**
	 * A specific decrease query for a products's quantity
	 * 
	 * @return a string containing a query
	 */
	private String createUpdateMinusQuery(String name) {
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE Produs");
		sb.append(" SET cantitate=cantitate-?");
		sb.append(" WHERE idProdus=? AND CAST(pret_fara_TVA AS DECIMAL) = CAST(? AS DECIMAL) AND denumire LIKE \"");
		sb.append(name + "\"");

		return sb.toString();
	}

	/**
	 * Calls and executes the decrease query for quantity
	 * 
	 * @param id
	 * @param newQuantity
	 */
	public void updateMinus(int id, String name, float price, int newQuantity) {
		Connection connection = null;
		PreparedStatement statement = null;
		String query = createUpdateMinusQuery(name);
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, newQuantity);
			statement.setInt(2, id);
			statement.setFloat(3, price);
			statement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "Update product error" + e.getMessage());
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
	}

	/**
	 * A specific query to identify a produs by his name
	 * 
	 * @return a string containing a query
	 */
	private String createFindByNameQuery(String name) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * FROM Produs");
		sb.append(" WHERE denumire LIKE \"");
		sb.append(name + "%\"");

		return sb.toString();
	}

	/**
	 * Calls and executes the findByName query
	 * 
	 * @return
	 */
	public ArrayList<Produs> findByName(String name) {
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
