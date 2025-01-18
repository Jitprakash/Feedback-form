package com.feedback;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.Console;
import java.sql.Connection;
;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/FeedbackServlet")
public class FeedbackServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Receiving / Getting data from Form
        String email=req.getParameter("email");
        String message=req.getParameter("message");
        //DataBase connectivity
        Connection connection = FeedbackDB.dbConnection();
        if (connection == null){
            System.out.println("Database connection failed");
            System.exit(0);
        }
        try{
            String query = "INSERT INTO feedback(email,feedback) values(?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,email);
            preparedStatement.setString(2,message);
            int rowsAffected= preparedStatement.executeUpdate();
          if (rowsAffected>0){
              System.out.println("Data inserted successfully");
          }else{
              System.out.println("Data is not inserted");
          }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        //Printing data
        resp.setContentType("text/html");
        PrintWriter writer= resp.getWriter();
        writer.println("""
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
                  </head>
                  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
                """);
        writer.println(String.format("""
                <table class="table table-dark table-hover">
                  <tr>
                  <th>Email</th>
                  <th>Feedback</th>
                  </tr>
                  <tr>
                  <td>%s</td>
                  <td>%s</td>
                  </tr>
                </table>
                
                """,email,message ));
    }
}
