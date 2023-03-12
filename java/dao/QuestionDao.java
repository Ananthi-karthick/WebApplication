package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;




import model.JDBC;
import model.Question;

public class QuestionDao {
	public static boolean insertQuestion(Question question) {

		boolean status = false;
		try {

			Connection con = JDBC.createConnection();
			String sql = "insert into questions(question,option_a,option_b,option_c,option_d,correct_answer) values(?,?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, question.getQuestion().trim());
			pst.setString(2, question.getOptions()[0]);
			pst.setString(3, question.getOptions()[1]);
			pst.setString(4, question.getOptions()[2]);
			pst.setString(5, question.getOptions()[3]);
			pst.setString(6, question.getCorrectAnswer());

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


	public static ArrayList<Question> getRandomQuestions() {
		ArrayList<Question> questionList=new ArrayList<>();
		try {

			
			Connection con = JDBC.createConnection();
			String sql = "select question,option_a,option_b,option_c,option_d,correct_answer from questions order by rand() limit 15";

			PreparedStatement pst = con.prepareStatement(sql);

			ResultSet rs = pst.executeQuery(sql);
			while (rs.next()) {
				Question questions=new Question(); 

				 questions.setQuestion(rs.getString(1));
				 String[] options = {rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)};
		         questions.setOptions(options);
				 questions.setCorrectAnswer(rs.getString(6));
                 questionList.add(questions);
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return questionList;
	

}
}
