package controller;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import org.json.JSONObject;

import com.google.gson.Gson;

import model.Admin;
import dao.AdminDao;


public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		
		 PrintWriter writer=response.getWriter();
		 BufferedReader reader=request.getReader();
		 Gson gson=new Gson();
		 Admin admin=gson.fromJson(reader, Admin.class);
		 System.out.println(admin.getUserName());
		 System.out.println(admin.getPassword());
		 boolean status=AdminDao.validate(admin);
		
		
		 JSONObject jsonResponse=new JSONObject();
		 if(status) {
			jsonResponse.put("message","Success");
		 }
		 else {
			jsonResponse.put("message","Invalid username or password");
		 }
		
		 writer.println(jsonResponse);
		 System.out.println(jsonResponse);
		 
		 
		 writer.close();
		 reader.close();
	  }
	

	

	
	}
