//load data from DB to show on article key-list(getIDFromDB), and to make bibtex file(getALLFromDB)

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBLoader {
	Connection conn;
	Statement stmt = null;
	String data[] = new String[1000];
	
	public String[] getIDFromDB(){

		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb","root","1307");
			System.out.println("DB connection completed");
			
			stmt = conn.createStatement();

			String sql = "select * from bib;";
			ResultSet rs = stmt.executeQuery(sql);
		
			int i=0;
			while(rs.next()){
				//System.out.println(i);
				data[i]  = rs.getString(1);
				//System.out.println(data[i]);

				i++;
			}
			conn.close();
			
		}catch(ClassNotFoundException e){
			System.out.println("class not found");
		}catch(SQLException e){
			System.out.println("sql error");
		}
		
		return data;
	}
	
	public String[] getAllFromDB(){

		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb","root","1307");
			System.out.println("DB connection completed");
			
			stmt = conn.createStatement();

			String sql = "select * from bib;";
			ResultSet rs = stmt.executeQuery(sql);
		
			int i=0;
			
			while(rs.next()){
				data[i]  = rs.getString(1);
				data[i+1] = rs.getString(2);
				data[i+2] = rs.getString(3);
				data[i+3] = rs.getString(4);
			  //  System.out.println(data[i]+"\n"+data[i+1]+"\n"+data[i+2]+"\n"+data[i+3]);

				i+=4; 
			}
		
			
			conn.close();
			
		}catch(ClassNotFoundException e){
			System.out.println("class not found");
		}catch(SQLException e){
			System.out.println("sql error");
		}
		
		return data;
	}
	
	public String[] getOneFromDB(String key){

		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb","root","1307");
			System.out.println("DB connection completed");	
			stmt = conn.createStatement();
			String sql = "select * from bib where id="+"'"+key+"'"+";";
			ResultSet rs = stmt.executeQuery(sql);
		
			int i=0;
			
			while(rs.next()){
				data[i]  = rs.getString(2);
				data[i+1] = rs.getString(3);
				data[i+2] = rs.getString(4);
			}
		
			
			conn.close();
			
		}catch(ClassNotFoundException e){
			System.out.println("class not found");
		}catch(SQLException e){
			System.out.println("sql error");
		}
		
		return data;
	}
	DBLoader(){
		
		
	}

}
