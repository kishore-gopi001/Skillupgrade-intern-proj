package GRADECALC;

import java.sql.*;
import java.util.Scanner;

//import java.sql.SQLException;

public class Student{
    
     public static void student_reg() throws SQLException{
          Connection con = Dbconnection.getConnection(); 
          @SuppressWarnings("resource")
          Scanner sc = new Scanner(System.in);
          System.out.println("Enter the name of the student");
          String name = sc.nextLine();
          System.out.println("Enter the id of the student");
          int stu_id = sc.nextInt();
          String query4 = "select stu_id from student";
          Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(query4);
          while(rs.next()){
            int check_id = rs.getInt("stu_id");
            if(check_id == stu_id ) {
              System.out.println("the student was already registerd");
              return;
            }
          }
          String query = "INSERT INTO student (stu_name, stu_id) VALUES (?, ?)";
          PreparedStatement preparedStatement = con.prepareStatement(query);
          preparedStatement.setString(1, name); 
          preparedStatement.setInt(2, stu_id);
          int rowsInserted = preparedStatement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("A new student was inserted successfully!");
            } 
     
     }
     public static void  read_stu() throws SQLException{
          System.out.println("----------------------------------------------------------------------");
          @SuppressWarnings("resource")
          Scanner sc = new Scanner(System.in);
          Connection con = Dbconnection.getConnection(); 
          System.out.println("enter stu_id");
          int id1 = sc.nextInt();
          String query = "SELECT * FROM student WHERE stu_id = ?";
          PreparedStatement preparedStatement = con.prepareStatement(query);
          preparedStatement.setInt(1, id1);
          ResultSet resultSet = preparedStatement.executeQuery();
          if (resultSet.next()) {
               int stu_id = resultSet.getInt("stu_id");
               System.out.println("your_id:"+stu_id);
               String name = resultSet.getString("stu_name");
               System.out.println("your_name:"+name);
               int tm = resultSet.getInt("toc_mark" );
               System.out.println("TOC_MARK:"+tm);
               int tm1 = resultSet.getInt("AIML_mark" );
               System.out.println("aiml_MARk:"+tm1);
               int tm2 = resultSet.getInt("Networking_mark" );
               System.out.println("network_MARK:"+tm2);
               int tm3 = resultSet.getInt("CD_mark" );
               System.out.println("compilerDesign_MARK:"+tm3);
               int tm4 = resultSet.getInt("total" );
               System.out.println("GRAND_TOTAL:"+tm4);
               int tm5 = resultSet.getInt("average" );
               System.out.println("AVERAGE:"+tm5);
               int tm6 = resultSet.getInt("gpa" );
               System.out.println("GPA:"+tm6);
               String tm7 = resultSet.getString("grade" );
               System.out.println("GRADE:"+tm7);
               System.out.println("----------------------------------------------------------------------");
          }

     }
     public static void main(String[] args) {
     int choice =0;
     @SuppressWarnings("resource")
     Scanner sc = new Scanner(System.in);   
     do{  
     System.out.println("welcome to board results");
     System.out.println("press 1 if you are teacher");
     System.out.println("press 2 if you are student");
     System.out.println("press 7 for exit");
      choice = sc.nextInt();
     switch(choice){
          case 1: 
          System.out.println("press 1 for course register");
          System.out.println("press 2 for Teacher register and entering marks");
          System.out.println("press 3 for enter grade");
          System.out.println("press 4 for calculate gpa");
          System.out.println("press 5 for student register");
          int choice1 = sc.nextInt();
          if(choice1 == 1){
               Course cr = new Course();
              try {
               cr. Get_course_details();
          } catch (SQLException e) {
               e.printStackTrace();
          }
          }
          if (choice1 == 5){
               try {
                    student_reg();
               } catch (SQLException e) {
                    e.printStackTrace();
               }
          }
               if(choice1 == 2){
                    Teacher tr = new Teacher();
                    tr.teacher();
               }
               else if(choice1 == 3){
                    Grade gr = new Grade();
                    try {
                         gr.find_grade();
                    } catch (SQLException e) {
                         e.printStackTrace();
                    }
               }
               else if(choice1 == 4){
                    gpa gp = new gpa();
                    try {
                         gp.gpa_register();
                    } catch (SQLException e) {
                         e.printStackTrace();
                    }
               }else
               System.out.println("enter num b/w 1 to 4");     
          break;
          case 2:
               try {
                    read_stu();
               } catch (SQLException e){
                    e.printStackTrace();
               }
     }
     }while(choice != 7);
     }

}
