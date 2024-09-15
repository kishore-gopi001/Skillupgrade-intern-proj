package GRADECALC;
import java.sql.*;
import java.util.Scanner;

public class Grade {
    public void find_grade() throws SQLException{
        Connection con = Dbconnection.getConnection();
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.println("enter student_id");
        int id_check = sc.nextInt();
        String query1 = " select toc_mark from student where stu_id = "+id_check;
        String query2 = " select AIML_mark from student where stu_id = "+id_check;
        String query3 = " select Networking_mark from student where stu_id = "+id_check;
        String query4 = " select CD_mark from student where stu_id = "+id_check;  
            Statement statement = con.createStatement();
            int tocMark = 0;
            int aimlMark = 0;
            int networkingMark = 0;
            int cdMark = 0;
            ResultSet rs1 = statement.executeQuery(query1);
            if (rs1.next()) {
                tocMark = rs1.getInt("toc_mark");
            }
            ResultSet rs2 = statement.executeQuery(query2);
            if (rs2.next()) {
                aimlMark = rs2.getInt("AIML_mark");
            }
            ResultSet rs3 = statement.executeQuery(query3);
            if (rs3.next()) {
                networkingMark = rs3.getInt("Networking_mark");
            }
            ResultSet rs4 = statement.executeQuery(query4);
            if (rs4.next()) {
                cdMark = rs4.getInt("CD_mark");
            }
            int total = tocMark+aimlMark+networkingMark+cdMark;
            String query5 = "UPDATE student SET total = ? WHERE stu_id = ?";
            PreparedStatement pstmt = con.prepareStatement(query5);
            pstmt.setInt(1, total);  
            pstmt.setInt(2,id_check);
            pstmt.executeUpdate();
            System.out.println("the total of the student successfully seted");
            //updating average
            int average = total/4;
            String query6 = "UPDATE student SET average = ? WHERE stu_id = ?";
            PreparedStatement pstmt1 = con.prepareStatement(query6);
            pstmt1.setInt(1, average);  
            pstmt1.setInt(2,id_check);
            pstmt1.executeUpdate();
            // updating grade
            String grade = null;
            if(average > 90 && average <=100) grade = "O";
            else if(average > 70 && average <= 90) grade = "A";
            else if(average > 50 && average <=70 ) grade = "B";
            else if(average >0 && average <=50)   grade= "fail";
            else System.out.println("enter a valid mark");

            String query7 = "UPDATE student SET grade = ? WHERE stu_id = ?";
            PreparedStatement pstmt2 = con.prepareStatement(query7);
            pstmt2.setString(1, grade);  
            pstmt2.setInt(2,id_check);
            pstmt2.executeUpdate(); 
            System.out.println("Aditionally average and Grade also successfully seted");
        }
   


    }
    

