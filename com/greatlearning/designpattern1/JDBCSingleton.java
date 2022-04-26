package com.greatlearning.designpattern1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCSingleton {
	//create a singleton class for JDBC.
	
		//Static member holds only one instance of JDBC class.
		private static JDBCSingleton jdbc;
		
		//private JDBCSingleton prevents the instantiation from any other class.
		private JDBCSingleton() {}
		
		//Providing global access using static function
		public static JDBCSingleton getinstance() {
			if(jdbc==null) {
				jdbc = new JDBCSingleton();
			}
			return jdbc;
		}
		
		//Connection from method Insert, view etc..
		public static Connection getConnection()throws ClassNotFoundException, SQLException
		{
			Connection conn =null;
			Class.forName("com.mysql.jdbc.Driver");
			conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase","root","Vishal12345*");
			return conn;
		}
		
		//Insert the record
		public int insert(String name, String pass) throws SQLException
		{
			Connection con = null;
			PreparedStatement ps = null;
			int CountRecord = 0;
			try {
					con = this.getConnection();
					ps=con.prepareStatement("insert into userdata(username,u_password)values(?,?)");
					ps.setString(1, name);
					ps.setString(2, pass);
					CountRecord=ps.executeUpdate();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				if(ps!=null) {
					ps.close();
				}
				if(con!=null) {
					con.close();
				}
			}
			return CountRecord;
		}
		
		//View the record
		public void view(String name) throws SQLException
		{
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
					con = this.getConnection();
					ps=con.prepareStatement("select * from userdata where username = ?");
					ps.setString(1, name);
					rs = ps.executeQuery();
					while(rs.next()) {
						System.out.println("Name= "+rs.getString(1)+"\t"+"Paasword= "+rs.getString(2));
					}
			}catch(Exception e) {
				System.out.println(e);
			}
			finally {
				if(ps!=null) {
					ps.close();
				}
				if(con!=null) {
					con.close();
				}
			}
		}
			
			//update password
		public int update(String name, String password) throws SQLException
		{
		    Connection con = null;  
		    PreparedStatement ps = null;
		    int recordCounter = 0;
		    
		    try{
		    	con=this.getConnection();
		        ps=con.prepareStatement("update userdata set u_password=? where username='"+name+"' ");
		        ps.setString(1, password);
		        recordCounter=ps.executeUpdate();
		    } catch(Exception e){   
		        e.printStackTrace();    
		    } 
		    finally{ 
		        if (ps!=null){
		            ps.close();
		        }if(con!=null){
		            con.close();
		        }     
		    }
		    return recordCounter;
		 }
		          
		// Delete the data from the database 
	    public int delete(String username) throws SQLException
	    {
	          Connection con=null;
	          PreparedStatement ps=null;           
	          int recordCounter=0;
	           
	          try {
	                con=this.getConnection();
	                ps=con.prepareStatement(" delete from userdata where username='"+username+"' ");
	                recordCounter=ps.executeUpdate();
	          } catch (Exception e) {    
	               e.printStackTrace();    
	           } finally{   
	               if (ps!=null){
	                   ps.close();
	               }if(con!=null){
	                   con.close();
	               }   
	           }   
	          return recordCounter;
	       }
	}
