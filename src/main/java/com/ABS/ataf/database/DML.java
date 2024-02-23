package com.ABS.ataf.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DML {
	
	
	 public static void main(String args[]) throws SQLException
	 {
		 selectQuery("192.168.1.15:5432","postgres","postgres","postgres","Select * from public.accounts;");
	 }
	public static void selectQuery(String urlport, String dbname, String username, String password,String query) throws SQLException{

	      
	      Connection c = DBConnection.getConnection(urlport,dbname,username,password);
	      Statement stmt = null;
	      stmt = c.createStatement();
	      ResultSet rs = stmt.executeQuery( query );
	      while ( rs.next() ) {
	         int id = rs.getInt("user_id");
	         String  name = rs.getString("username");
	         String pass  = rs.getString("password");
	         String  email = rs.getString("email");
	        
	         System.out.println( "ID = " + id );
	         System.out.println( "USERNAME = " + name );
	         System.out.println( "PASSWORD = " + pass );
	         System.out.println( "EMAIL = " + email );
	         
	         System.out.println();
	      }
	      rs.close();
	      stmt.close();
	      c.close();
	   
	}

	
	public static void selectQueryStepDef(String query) throws SQLException{

	      
	     // Connection c = DBConnection.getConnection(urlport,dbname,username,password);
	      Statement stmt = null;
	      stmt = DBConnection.c.createStatement();
	      ResultSet rs = stmt.executeQuery( query );
	      while ( rs.next() ) {
	         int id = rs.getInt("user_id");
	         String  name = rs.getString("username");
	         String pass  = rs.getString("password");
	         String  email = rs.getString("email");
	        
	         System.out.println( "ID = " + id );
	         System.out.println( "USERNAME = " + name );
	         System.out.println( "PASSWORD = " + pass );
	         System.out.println( "EMAIL = " + email );
	         
	         System.out.println();
	      }
	      rs.close();
	      stmt.close();
	      DBConnection.c.close();
	   
	}
	
	
	public static void insertQueryStepDef(String query) throws SQLException{

	      
	     // Connection c = DBConnection.getConnection(urlport,dbname,username,password);
	      Statement stmt = null;
	      stmt = DBConnection.c.createStatement();
	      stmt.executeUpdate( query );
	     /* while ( rs.next() ) {
	         int id = rs.getInt("user_id");
	         String  name = rs.getString("username");
	         String pass  = rs.getString("password");
	         String  email = rs.getString("email");
	        
	         System.out.println( "ID = " + id );
	         System.out.println( "USERNAME = " + name );
	         System.out.println( "PASSWORD = " + pass );
	         System.out.println( "EMAIL = " + email );
	         
	         System.out.println();
	      }
	      rs.close();*/
	      stmt.close();
	      DBConnection.c.close();
	   
	}

}
