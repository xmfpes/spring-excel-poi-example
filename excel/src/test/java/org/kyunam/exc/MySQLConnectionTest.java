package org.kyunam.exc;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class MySQLConnectionTest {

   private static final String DRIVER="com.mysql.cj.jdbc.Driver";
   private static final String URL=
         "jdbc:mysql://localhost:3306/jsp?useSSL=false&serverTimezone=UTC";
   private static final String USER="root";
   private static final String PW="1111";
   
   @Test
   public void MySQLConnectionTest() throws Exception{
      Class.forName(DRIVER);
      
      try(Connection con = DriverManager.getConnection(URL, USER, PW)){
         System.out.println("good");
      }catch(Exception e){
         e.printStackTrace();
      }
   }
}