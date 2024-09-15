package GRADECALC;
import java.sql.*;
import java.util.Scanner;
public class Teacher {
      int choice ;
      String name ;
      String Course_Name;
      int course_id;  
      Scanner sc = new Scanner(System.in);
      public void teacher(){
        System.out.println("Welcome Teacher!!");
        System.out.println("press 1 for TEACHER registration");
        System.out.println("press 2 for entering student marks");
        choice = sc.nextInt();
        switch (choice) {
          case 1:
            try {
              teacher_register();
            } catch (SQLException e) {
              e.printStackTrace();
            }
            break;
           case 2:
             try {
              Entering_marks();
            } catch (SQLException e) {
              e.printStackTrace();
            } 
          default:
          System.out.println("enter valid no");
            break;
        }
      }
      public void teacher_register() throws SQLException{
        System.out.println("name");
        name = sc.nextLine();
        System.out.println("Enter course_Name");
        Course_Name = sc.nextLine();
        System.out.println("Enter course_id");
        course_id = sc.nextInt();

        String querry = " insert into teacher values(?,?,?);";
        Connection con = Dbconnection.getConnection();
        PreparedStatement pst = con.prepareStatement(querry);
        pst.setString(1,name);
        pst.setString(2, Course_Name);
        pst.setInt(3, course_id);
        pst.executeUpdate();
        con.close();
        System.out.println("your course record updated successfully");
      }
      public void Entering_marks() throws SQLException{
        Connection con = Dbconnection.getConnection();
        System.out.println("Enter student id");
        int id = sc.nextInt();
        System.out.println("Enter toc_mark");
        int  mark1 = sc.nextInt();
        System.out.println("enter AIML_mark:");
        int mark2 = sc.nextInt();
        System.out.println("Enter Networking_mark:");
        int mark3 = sc.nextInt();
        System.out.println("Enter CD_mark:");
        int mark4 = sc.nextInt();
        //inserting mark1
        String query = "UPDATE student SET toc_mark = ? WHERE stu_id = ?";
        PreparedStatement pstmt = con.prepareStatement(query);
        pstmt.setInt(1, mark1);  
        pstmt.setInt(2,id);
        pstmt.executeUpdate();
        //inserting mark2
        String query1 = "UPDATE student SET AIML_mark = ? WHERE stu_id = ?";
        pstmt = con.prepareStatement(query1);
        pstmt.setInt(1, mark2);  
        pstmt.setInt(2,id);
        pstmt.executeUpdate();
        //inserting mark3
        String query2 = "UPDATE student SET Networking_mark = ? WHERE stu_id = ?";
        pstmt = con.prepareStatement(query2);
        pstmt.setInt(1, mark3);  
        pstmt.setInt(2,id);
        pstmt.executeUpdate();
        //inserting mark4
        String query3 = "UPDATE student SET CD_mark = ? WHERE stu_id = ?";
        pstmt = con.prepareStatement(query3);
        pstmt.setInt(1, mark4);  
        pstmt.setInt(2,id);
        pstmt.executeUpdate();
        con.close();
        System.out.println("inserted successfully");
      }

}
