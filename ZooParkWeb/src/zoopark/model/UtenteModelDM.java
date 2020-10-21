package zoopark.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class UtenteModelDM implements UtenteModel<Utente> {

	@Override
	public Utente doRetrievebyKey(String key) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Utente bean = new Utente();
		String selectSQL = " SELECT * FROM user WHERE email = ?";
		try { 
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, key);
			System.out.println("Search: "+ preparedStatement.toString());
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				bean.setEmail(rs.getString(1));
				bean.setPassword(rs.getString(2));
				bean.setIDRuolo(rs.getString(3));
				bean.setNome(rs.getString(4));
				bean.setCognome(rs.getString(5));
				bean.setHaveTicket(rs.getBoolean(6));
			}
		}
		finally {
			try {
				if(preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return bean;
	}
	
	public Utente doRetrievebyName(String key) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Utente bean = new Utente();
		String selectSQL = " SELECT * FROM user WHERE name = ?";
		try { 
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, key);
			System.out.println("Search: "+ preparedStatement.toString());
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				bean.setEmail(rs.getString(1));
				bean.setPassword(rs.getString(2));
				bean.setIDRuolo(rs.getString(3));
				bean.setNome(rs.getString(4));
				bean.setCognome(rs.getString(5));
				bean.setHaveTicket(rs.getBoolean(6));
			}
		}
		finally {
			try {
				if(preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return bean;
	}

	@Override
	public Collection<Utente> doRetrieveAll(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ArrayList<Utente> beanCollection = new ArrayList<Utente>();
		String selectSQL = " SELECT * FROM user";
		if(order != null && !order.contentEquals("")) {
			selectSQL += " ORDER BY " + order;
		}
		try { 
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);		
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				Utente bean = new Utente();
				bean.setEmail(rs.getString(1));
				bean.setPassword(rs.getString(2));
				bean.setIDRuolo(rs.getString(3));
				bean.setNome(rs.getString(4));
				bean.setCognome(rs.getString(5));
				bean.setHaveTicket(rs.getBoolean(6));
				beanCollection.add(bean);
			}
		}
		finally {
			try {
				if(preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return beanCollection;
	}

	@Override
	public void doSave(Utente utente) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String insertSQL = "INSERT INTO user" +
				" (email, password, role_id, name, surname, ticket) VALUES (?, ?, ?, ?, ?, ?)";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			
			preparedStatement.setString(1, utente.getEmail());
			preparedStatement.setString(2, utente.getPassword());
			preparedStatement.setString(3, utente.getIDRuolo());
			preparedStatement.setString(4, utente.getNome());
			preparedStatement.setString(5, utente.getCognome());
			preparedStatement.setBoolean(6, utente.getHaveTicket());
			
			
			System.out.println("doSave: "+ preparedStatement.toString());
			preparedStatement.executeUpdate();
			
			connection.commit();
			System.out.println("Fatto la save");

		} finally {
				try {
					if(preparedStatement != null) 
						preparedStatement.close();
				} finally {
					DriverManagerConnectionPool.releaseConnection(connection);
				}
			}	
	}

	@Override
	public void doUpdate(Utente utente) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String insertSQL = "UPDATE user SET" +
				" email = ?, password = ?, role_id = ?, name = ?, surname = ? WHERE email = ?";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			
			preparedStatement.setString(1, utente.getEmail());
			preparedStatement.setString(2, utente.getPassword());
			preparedStatement.setString(3,  utente.getIDRuolo());
			preparedStatement.setString(4, utente.getNome());
			preparedStatement.setString(5, utente.getCognome());
			
			preparedStatement.setString(6, utente.getEmail());
			
			System.out.println("doSave: "+ preparedStatement.toString());
			preparedStatement.executeUpdate();
		
			connection.commit();

		} finally {
				try {
					if(preparedStatement != null) 
						preparedStatement.close();
				} finally {
					DriverManagerConnectionPool.releaseConnection(connection);
				}
			}
	}
	
	public void doUpdateTicket(Utente utente) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String insertSQL = "UPDATE user SET" +
				" ticket= ? WHERE name = ?";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			
			preparedStatement.setBoolean(1, utente.getHaveTicket());
			preparedStatement.setString(2, utente.getNome());
			
			System.out.println("doSave: "+ preparedStatement.toString());
			preparedStatement.executeUpdate();
		
			connection.commit();
			System.out.println("Fatto!");

		} finally {
				try {
					if(preparedStatement != null) 
						preparedStatement.close();
				} finally {
					DriverManagerConnectionPool.releaseConnection(connection);
				}
			}
	}

	@Override
	public void doDelete(String key) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String deleteSQL = "DELETE FROM user WHERE email = ?";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setString(1, key);
			
			System.out.println("doDelete: "+ preparedStatement.toString());
			preparedStatement.executeUpdate();
			
			connection.commit();
			
		} finally {
			try {
				if(preparedStatement != null) 
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}	
	}
	
	public boolean exists(String email) throws SQLException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String selectSQL = " SELECT * FROM user WHERE email = ?";
		try { 
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, email);
			
			ResultSet rs = preparedStatement.executeQuery();
			if(rs.next()) {
				return true;
			}
			else return false;
		}
		finally {
			try {
				if(preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
	}

}
