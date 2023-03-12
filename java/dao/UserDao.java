package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import model.JDBC;
import model.User;

public class UserDao {
	
	public static Object[]  doValidate(User user) {
       
		Object[] userDetails=new Object[3];
		String username = user.getUserName();
		String password = user.getPassword();

		
		try {

			Connection con = JDBC.createConnection();
			PreparedStatement preparedStatement = con
					.prepareStatement("Select Name,user_id,gender from User where user_name=? And password=?");
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				userDetails[0]=rs.getString(1);
				userDetails[1]=rs.getInt(2);
				userDetails[2]=rs.getString(3);
				System.out.println(rs.getString(1)+" "+rs.getInt(2));
			} else {
				userDetails[0]=null;
				userDetails[1]=0;
			}

			
		} catch (Exception e) {
			System.out.println(e);
		}
		return userDetails;
	}

	public static boolean register(User user) {

		boolean status = false;
		try {
             
			Connection con = JDBC.createConnection();
			PreparedStatement preparedStatement = con
					.prepareStatement("Select * from user where email_id=?");
			preparedStatement.setString(1, user.getEmail());
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				status=false;
			}
			else {
				String sql = "insert into user(Name,email_id,contact_no,user_name,password,gender) values(?,?,?,?,?,?)";
				PreparedStatement pst = con.prepareStatement(sql);
				pst.setString(1, user.getName());
				pst.setString(2, user.getEmail());
				pst.setLong(3, user.getContactNo());
				pst.setString(4, user.getUserName());
				pst.setString(5, user.getPassword());
				pst.setString(6, user.getGender());
				int val = pst.executeUpdate();
				if (val > 0) {
					status = true;
				} 
			}
		}
			catch (Exception e) {
				e.printStackTrace();
			}
		
		return status;
	}

	public static ArrayList<User> getAllRecords() {
		ArrayList<User> allUsers = new ArrayList<User>();
		try {
			
			Connection con = JDBC.createConnection();
			String sql = "select user_id,name,gender,email_id,contact_no from User";
			PreparedStatement pst = con.prepareStatement(sql);

			ResultSet rs = pst.executeQuery(sql);
			while (rs.next()) {
				User user = new User();
				user.setUserId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setGender(rs.getString(4));
				user.setContactNo((rs.getLong(5)));
				allUsers.add(user);
				
			}
			

		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return allUsers;
	}

	

	
	
}
