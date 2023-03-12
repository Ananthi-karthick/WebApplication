package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import com.google.gson.Gson;
import dao.UserDao;
import model.User;

public class UserRegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");

        PrintWriter writer = response.getWriter();
        BufferedReader reader = request.getReader();
        Gson gson = new Gson();
        User user = gson.fromJson(reader, User.class);

        JSONObject jsonResponse = new JSONObject();
        boolean status = UserDao.register(user);

        if (status) 
           
        	 jsonResponse.put("message", "Success");

        else 
        	 jsonResponse.put("message", "The Username you were entered is already registered");
        	   
       

        writer.println(jsonResponse);
        System.out.println(jsonResponse);
        
        writer.close();
        reader.close();
    }
}
