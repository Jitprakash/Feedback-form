package com.feedback;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class FeedbackDB {
    private static final String url ="jdbc:mysql://localhost:3306/feedback_form";
    private static final String username= "root";
    private static final String password="Jit@2004";
    private static final String password="Your-Password";

    public static Connection dbConnection()  {
      try {
      //Load Necessary drivers
          Class.forName("com.mysql.cj.jdbc.Driver");
      } catch (ClassNotFoundException e) {
          System.out.println(e.getMessage());
      }
      Connection connection = null;
      try{
         connection = DriverManager.getConnection(url,username,password);
      }catch (SQLException e){
          System.out.println(e.getMessage());
      }
        return connection;
    }

}
