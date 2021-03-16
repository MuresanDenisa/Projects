package dataAccessObjects;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import dataAccessLayer.ConnectionFactory;

public class AbstractDAO<T> {

	protected static final Logger LOGGER = Logger.getLogger(AbstractDAO.class.getName());

	private final Class<T> type;

	/**
	 * Public constructor
	 */
	@SuppressWarnings("unchecked")
	public AbstractDAO() {
		this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	/**
	 * Creates a string for a SELECT query
	 * 
	 * @param field
	 * @return a string containing the query
	 */
	public String createSelectQuery(String field) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * FROM ");
		sb.append(type.getSimpleName());
		sb.append(" WHERE " + field + " =?");

		return sb.toString();
	}

	/**
	 * Creates a string for a SELECT MAX query
	 * 
	 * @param field
	 * @return
	 */
	public String createSelectMaxQuery(String field) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT  * FROM ");
		sb.append(type.getSimpleName());
		sb.append(" WHERE " + field + "=( SELECT max(" + field + ") FROM " + type.getSimpleName() + ") ");

		return sb.toString();
	}

	/**
	 * Creates an INSERT query
	 * 
	 * @param object
	 * @return a string containing a query
	 */
	public String createInsertQuery(Object object) {
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO ");
		sb.append(type.getSimpleName() + "(");
		for (Field field : type.getDeclaredFields()) {
			field.setAccessible(true);
			sb.append(field.getName() + ",");
		}
		sb.deleteCharAt(sb.length() - 1);
		sb.append(") VALUES (");
		for (Field field : type.getDeclaredFields()) {
			field.setAccessible(true);
			try {
				Object value = field.get(object);
				if (value.equals(false))
					sb.append(value + ",");
				else
					sb.append("'" + value + "',");
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		sb.deleteCharAt(sb.length() - 1);
		sb.append(")");

		return sb.toString();
	}

	/**
	 * A specific SELECT ALL from table query, listing the entire content of the
	 * table
	 * 
	 * @return a string containing a query
	 */
	private String createSelectAllQuery() {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * FROM ");
		sb.append(type.getSimpleName());

		return sb.toString();
	}

	/**
	 * Creates a specific OBJECT with it's properties from the DataBase
	 * 
	 * @param resultSet
	 * @return
	 */
	public ArrayList<T> createObject(ResultSet resultSet) {
		ArrayList<T> list = new ArrayList<T>();

		try {
			while (resultSet.next()) {
				@SuppressWarnings("deprecation")
				T instance = type.newInstance();
				for (Field field : type.getDeclaredFields()) {
					Object value = resultSet.getObject(field.getName());
					PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(), type);
					Method method = propertyDescriptor.getWriteMethod();
					method.invoke(instance, value);
				}
				list.add(instance);
			}
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (IntrospectionException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	/**
	 * Finds an elements in a table based on it's id
	 * 
	 * @param id
	 * @return an object with element's properties
	 */
	public T findById(int id) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = createSelectQuery(type.getDeclaredFields()[0].getName());
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			return createObject(resultSet).get(0);
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}

		return null;
	}

	/**
	 * Calls and executes the SelectAll query
	 * 
	 * @return
	 */
	public ArrayList<T> findAll() {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = createSelectAllQuery();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			resultSet = statement.executeQuery();
			return createObject(resultSet);
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, type.getName() + "List All Error" + e.getMessage());
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return null;
	}

	/**
	 * Calls and executes the INSERT query
	 * 
	 * @param object
	 */
	public void insert(Object object) {
		Connection connection = null;
		PreparedStatement statement = null;
		String query = createInsertQuery(object);
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, type.getName() + "Insert error" + e.getMessage());
		} finally {
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
	}

	/**
	 * Calls and executes the SELECT MAX ID query
	 * 
	 * @return
	 */
	public int findMaxId() {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = createSelectMaxQuery(type.getDeclaredFields()[0].getName());
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			resultSet = statement.executeQuery();
			if (resultSet.next())
				return resultSet.getInt(1);
			else
				return 0;
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, type.getName() + "DAO: Find max id " + e.getMessage());
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}

		return -1;
	}
}
