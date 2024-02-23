package com.ABS.ataf.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBConnection {
	public static Connection c = null;
   public static Statement stmt = null;
    
    public static Connection getConnection(String urlport, String dbname, String username, String password)
    {
    	try {
    		if(c != null )
    		{
    			if(!(c.isClosed()))
    			return c;
    		}
            Class.forName("org.postgresql.Driver");
            c = DriverManager
               .getConnection("jdbc:postgresql://" + urlport + "/" + dbname, username , password);
         } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
         }
         System.out.println("Opened database successfully");
         return c;
    }
   
   }
