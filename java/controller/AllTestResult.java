package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import dao.ResultDao;
import model.Result;

public class AllTestResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		int user_id=(int)session.getAttribute("userId");
		Gson gson=new Gson();
		BufferedReader reader=request.getReader();
		
		Result result=gson.fromJson(reader, Result.class);
		
		String date=result.getDate();
		System.out.println(date);
		ArrayList<Result> resultList=ResultDao.viewResult(user_id,date);
		
		Gson gson1=new Gson();
		String json=gson1.toJson(resultList);
		PrintWriter out=response.getWriter();
		
		out.write(json);
		
	}

}
