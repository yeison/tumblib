package tumblib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.GregorianCalendar;

public class TimeStats {
	public static void createTable(String tableName, String keyName, Post[] postArray){
		Statement stat = null;
		Connection conn = null;
		PreparedStatement prep = null;
		try{
			Class.forName("org.sqlite.JDBC");
			conn =
				DriverManager.getConnection("jdbc:sqlite:tumblr.db");
			stat = conn.createStatement();
			stat.executeUpdate("create table if not exists " + tableName + 
					" (" + keyName + " primary key, posts);");
			prep = conn.prepareStatement("insert or replace into " + tableName +
			" values (?, ?);");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
			System.err.println("Verify SQL syntax.  Also verify " +
			"that the database exists.");
		}

		GregorianCalendar calendar = new GregorianCalendar();
		int [] hourOfDay = new int[24];
		for(int i = 0; i < postArray.length; i++){
			calendar.setTime(postArray[i].getDate());
			hourOfDay[calendar.get(calendar.HOUR_OF_DAY)] += 1;
		}
		int i = 0;
		while(i < hourOfDay.length){
			if(hourOfDay[i] != 0){
				try {
					prep.setInt(1, i);
					prep.setInt(2, hourOfDay[i]);
					prep.addBatch();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			i++;
		}
		try {
			conn.setAutoCommit(false);
			prep.executeBatch();
			conn.commit();
			
			ResultSet rs = stat.executeQuery("select * from " + tableName +" ;");
			System.out.println(rs.getString(1));
			rs.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
