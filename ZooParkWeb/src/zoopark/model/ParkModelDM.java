package zoopark.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;


public class ParkModelDM implements ParkModel<Park> {
	@Override
	public Park doRetrievebyKey(int key) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Park bean = new Park();
		String selectSQL = " SELECT * FROM park WHERE codUnivoco = ?";
		try { 
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, key);
			
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				bean.setCod(rs.getInt(5));
				bean.setLocation(rs.getString(1));
				bean.setName(rs.getString(2));
				bean.setOpening(rs.getString(3));
				bean.setClosure(rs.getString(4));
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
	public Collection<Park> doRetrieveAll(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ArrayList<Park> beanCollection = new ArrayList<Park>();
		String selectSQL = "SELECT * FROM park";
		if(order != null && !order.contentEquals("")) {
			selectSQL += " ORDER BY " + order;
		}
		try { 
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);		
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				Park bean= new Park();
				bean.setCod(rs.getInt(5));
				bean.setLocation(rs.getString(1));
				bean.setName(rs.getString(2));
				bean.setOpening(rs.getString(3));
				bean.setClosure(rs.getString(4));
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
	public void doSave(Park park) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String insertSQL = "INSERT INTO park" +
				" (luogo,nome,orario_apertura,orario_chiusura,codUnivoco) VALUES (?,?,?,?,?)";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, park.getLocation());
			preparedStatement.setString(2, park.getName());
			preparedStatement.setString(3,park.getOpening());
			preparedStatement.setString(4,park.getClosure());
			preparedStatement.setInt(5,park.getCod());
			
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

	@Override
	public void doUpdate(Park park) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String insertSQL = "UPDATE park SET" +
				" luogo = ?, nome = ?,orario_apertura=?,orario_chiusura=? WHERE codUnivoco = ?";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			
			preparedStatement.setString(1, park.getLocation());
			preparedStatement.setString(2, park.getName());
			preparedStatement.setString(3,park.getOpening());
			preparedStatement.setString(4,park.getClosure());
			
			preparedStatement.setInt(5,park.getCod());
			
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

	@Override
	public void doDelete(String key) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String deleteSQL = "DELETE FROM park WHERE codUnivoco = ?";
		
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

}
