import java.io.*;
import java.sql.*;

public class DBManager {
	Connection conn;
	Statement stmt = null;
	
	DBManager(){
		
	}
	
	DBManager(String []s){
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb","root","1307");
			System.out.println("DB connection completed");
			stmt =  conn.createStatement();
			stmt.executeUpdate("insert into bib (id, authors, title, year) values('"+s[0]+"','"+s[1]+"','"+s[2]+"','"+s[3]+"');");
			
		}catch(ClassNotFoundException e){
			System.out.println("class not found");
		}catch(SQLException e){
			System.out.println("sql error");
		}
		
	}
	
	public String[] changeItem(String[] s){
		String data[]= new String[5];
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb","root","1307");
			System.out.println("DB connection completed");
			stmt =  conn.createStatement();
			stmt.executeUpdate("update bib set authors='"+s[1]+"' where id='"+s[0]+"';");
			stmt.executeUpdate("update bib set title='"+s[2]+"' where id='"+s[0]+"';");
			stmt.executeUpdate("update bib set year='"+s[3]+"' where id='"+s[0]+"';");
			
		}catch(ClassNotFoundException e){
			System.out.println("class not found");
		}catch(SQLException e){
			System.out.println("sql error");
		}
		
		return data;
	}
	
	
	public void deleteItem(String s){
	
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb","root","1307");
			System.out.println("DB connection completed");
			stmt =  conn.createStatement();
			stmt.executeUpdate("delete from bib where id='"+s+"';");
	
		}catch(ClassNotFoundException e){
			System.out.println("class not found");
		}catch(SQLException e){
			System.out.println("sql error");
		}
	
	}
}
