package com.ehcache.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

public class ACECacheDAOHelper {

	@Autowired
	DataSource dataSource;
	
	public ACECacheDAOHelper(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public List<ErrorMsg> getErrorMessages()
	{
		// Creating the error message table using h2 database
		createErrorMsgTable();
		insertErrMSG("ec1", "Error Code 1");
		insertErrMSG("ec2", "Error Code 2");
		insertErrMSG("ec3", "Error Code 3");
		insertErrMSG("ec4", "Error Code 4");
		insertErrMSG("ec5", "Error Code 5");
		
		return findAllErrorMessages();
	}
	
	private void insertErrMSG(String errCode, String errMsg){
		
		String sql = "INSERT INTO ERROR_MESSAGE " +
				"(ERR_CODE, ERR_MSG) VALUES (?, ?)";
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			System.out.println("Connection : "+ conn);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, errCode);
			ps.setString(2, errMsg);
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
			
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}
	
	private List<ErrorMsg> findAllErrorMessages(){
		
		String sql = "SELECT ERR_CODE, ERR_MSG FROM ERROR_MESSAGE";
		List<ErrorMsg> errList = new ArrayList<ErrorMsg>();
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ErrorMsg errMsg = null;
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				errMsg = new ErrorMsg(
						rs.getString("ERR_CODE"), 
						rs.getString("ERR_MSG")
				);
				errList.add(errMsg);
			}
			rs.close();
			ps.close();
			return errList;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}
	}
	
	private void createErrorMsgTable()
	{
		String sql = "DROP TABLE IF EXISTS ERROR_MESSAGE";
		Connection conn = null;
		Statement stmt = null;
		
		try {
			conn = dataSource.getConnection();
			System.out.println("Connection : "+ conn);
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			
			sql = "CREATE TABLE ERROR_MESSAGE(ERR_CODE VARCHAR, ERR_MSG VARCHAR)";
			stmt.executeUpdate(sql);
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
			
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}
}
