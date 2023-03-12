package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import dao.RankDao;

public class DateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session=request.getSession();
		int user_id=(int)session.getAttribute("userId");
		String[] dates=RankDao.getDates(user_id);
		
		Gson gson=new Gson();
		String json =gson.toJson(dates);
		 PrintWriter pw = response.getWriter();
		 pw.write(json);
		 System.out.println(json);
	}

}
