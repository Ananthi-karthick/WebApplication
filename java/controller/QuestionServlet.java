package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.google.gson.Gson;

import dao.QuestionDao;
import dao.RankDao;
import model.Question;

public class QuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter writer=response.getWriter();
		
		 BufferedReader reader=request.getReader();
		 Gson gson=new Gson();

		Question question=gson.fromJson(reader, Question.class);
		JSONObject js=new JSONObject();
		
		
		boolean status=QuestionDao.insertQuestion(question);
		if(status)
		{
			js.put("message","successfully added");
		}
		else
			js.put("message","failed to add question!");
		
		
		writer.print(js);
	
}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
		{
		    PrintWriter out=response.getWriter();
			HttpSession session=request.getSession();
			int count=RankDao.checkCount(Integer.parseInt(String.valueOf(session.getAttribute("userId"))));
			JSONObject js=new JSONObject();
			if(count<=3) {
				js.put("message","ok");
			}
			else {
				js.put("message","Sorry,You were already attend the test 3 times.Can't attend anymore.");
			}
			out.print(js);
		}
}