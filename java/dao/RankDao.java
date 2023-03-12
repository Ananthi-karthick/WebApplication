package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import model.JDBC;
import model.Score;

public class RankDao {

     public static ArrayList<Score> showRanklist() {
    	ArrayList<Score> list=new ArrayList<>();
    	 try {

  			Connection con = JDBC.createConnection();
  			String sql = "select DISTINCT user_name,score,gender from score order by score desc ";
  			PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs=pst.executeQuery();
  			
  			while(rs.next()) {
  				 Score score=new Score();
  				 score.setUser_name(rs.getString(1));
  				 score.setScore(rs.getInt(2));
  				 score.setGender(rs.getString(3));
  				 list.add(score);
  			} 

  		} catch (Exception e) {
  			e.printStackTrace();
  		}
  		
		
     return list;	
}
     public static boolean addScore(Score score)throws SQLIntegrityConstraintViolationException
 	{
 		boolean status = false;
 		try {

 			Connection con = JDBC.createConnection();
 			String sql = "insert into score values(?,?,?,?)";
 			PreparedStatement pst = con.prepareStatement(sql);
 			pst.setString(1,score.getAttendDate());
 			pst.setInt(2,score.getUser_id());
 			pst.setString(3,score.getUser_name());
 			pst.setInt(4, score.getScore());
             int val = pst.executeUpdate();
 			
 			if (val > 0) {
 				status = true;
 				
 			} else {
 				status = false;
 			}

 		} catch (Exception e) {
 			e.printStackTrace();
 		}
 		return status;
 	}
 	public static  int checkCount(int user_id)
 	{
 		
 		int count=0;
 		
 		try {

 			Connection con = JDBC.createConnection();
 			String sql = "SELECT count( * )  FROM score WHERE user_id =?";		
 			PreparedStatement pst = con.prepareStatement(sql);
 			pst.setInt(1,user_id);
 			ResultSet rs = pst.executeQuery();
  				while(rs.next()) {
 					count=rs.getInt(1);
 				} 
 				
 		
 	}catch(Exception e)
 		{
 		e.printStackTrace();
 		}
 		
 		return count;
 }
 	
 	
     public static String[] getDates(int user_id)
 	{
 		String[] dates=new String[3];
 		try {
 			 int i=0;
 		Connection con = JDBC.createConnection();
 		String sql = "select attend_date from score where user_id=?";
 		PreparedStatement pst = con.prepareStatement(sql);
 		pst.setInt(1, user_id);
 		ResultSet rs = pst.executeQuery();
 		while (rs.next()) {
 			dates[i]=rs.getString(1);
 			i++;
 			
 		}

 		}catch (Exception e2) {
 		e2.printStackTrace();
 	}
 		return dates;
 	}
}
