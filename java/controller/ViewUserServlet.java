package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.UserDao;
import model.User;

public class ViewUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		ArrayList<User> allUsers =UserDao.getAllRecords();
		Gson gson=new Gson();
		String json=gson.toJson(allUsers);
		System.out.println(json);
		PrintWriter out=response.getWriter();
		out.write(json);
		
	}

}
