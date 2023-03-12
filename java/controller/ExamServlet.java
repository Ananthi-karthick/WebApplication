package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import dao.QuestionDao;
import dao.RankDao;
import dao.ResultDao;
import model.Question;
import model.Result;
import model.Score;



public class ExamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	
	private List<String> dbAnswer = new ArrayList<String>();
	private List<String> question = new ArrayList<String>();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("application/json");
		Gson gson=new Gson();
	List<Question> allQuestions = QuestionDao.getRandomQuestions();
	
	dbAnswer.clear();
	question.clear();
	for(Question ans:allQuestions) {
		question.add(ans.getQuestion());
		dbAnswer.add(ans.getCorrectAnswer());
	}
	 
	
	request.getSession().setAttribute("myList", dbAnswer);
	request.getSession().setAttribute("question",question);
	
    PrintWriter pw = response.getWriter();
    
    String json =gson.toJson(allQuestions);
    
    
    pw.write(json);
   	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BufferedReader reader = request.getReader();
		  StringBuilder sb = new StringBuilder();
		  String line;
		  while ((line = reader.readLine()) != null) {
		    sb.append(line);
		  }
		  String jsonArr = sb.toString();

		 
		  Gson gson = new Gson();
		  List<String> userAnswer= gson.fromJson(jsonArr, new TypeToken<List<String>>(){}.getType());
		  @SuppressWarnings("unchecked")
		List<String> dbAnswer= (List<String>) request.getSession().getAttribute("myList");
		  @SuppressWarnings("unchecked")
		List<String> questionList = (List<String>) request.getSession().getAttribute("question");
          int correctAnswer=0,unAttempted=0,wrongAnswer=0;
		  
		  for (int i = 0; i <15; i++) {
			  
			  if(userAnswer.get(i).equals(dbAnswer.get(i)))
				{
				  
					correctAnswer++;
				}
				else if(userAnswer.get(i).equals("notAttend"))
				{
					
					unAttempted++;
				}
				else
				{
					
					wrongAnswer++;
				}
		  }
		  System.out.println(correctAnswer);
		  System.out.println(unAttempted);
		  System.out.println(wrongAnswer);
		  
		  
		  int userId=(int) request.getSession().getAttribute("userId");
		  String userName=(String) request.getSession().getAttribute("userName");
		  String gender = (String) request.getSession().getAttribute("gender");
	        
		  LocalDate now= LocalDate.now();
		  String attendDate=now.format(DateTimeFormatter.ISO_DATE);
		  int x=0,y=0,z=0;
		  boolean status=false;
		  while(x<questionList.size() && y<dbAnswer.size() && z<userAnswer.size())
		  {   
		  	String question=questionList.get(x);
		  	String answer=dbAnswer.get(y);
		  	String userAns=userAnswer.get(z);
		 
		  	Result result=new Result(userId,question,answer,userAns,attendDate);
		  	 try {
				status=ResultDao.insertResult(result);
			} catch (Exception e) {
				e.printStackTrace();
			}
		  	
		  	x++;y++;z++;
		  }
		  
		  
		  Score score=new Score(attendDate,userId,userName,gender,correctAnswer);
		  
		  boolean status1=false;
		  try {
				status1=RankDao.addScore(score);
			} catch (Exception e) {
				e.printStackTrace();
			}
		  Map<String,Integer> scoreList=new HashMap<>();
		  if(status1)
			{
				scoreList.put("TotalNoOfQuestions",userAnswer.size());
				scoreList.put("NumberOfQuestionsAttempted",userAnswer.size()-unAttempted);
				scoreList.put("NumberofWrongAnswers",wrongAnswer);
				scoreList.put("NumberofCorrectAnswers",correctAnswer);
			}
		  PrintWriter out=response.getWriter();
		  String json =gson.toJson(scoreList);
		  out.write(json);

}
	

}
