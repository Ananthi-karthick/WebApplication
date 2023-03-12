package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.RankDao;
import model.Score;

public class ScoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("application/json");
			Gson gson=new Gson();
		
		ArrayList<Score> rank =RankDao.showRanklist();
		
		 PrintWriter pw = response.getWriter();
		    
		    String json =gson.toJson(rank);
		    System.out.println(json);
		    
		    pw.write(json);
	}

	
	

}
