package GRADECALC;
import java.sql.*;
import java.util.Scanner;

public class Course {
    String course_name;
    int course_id;
    int credit;

    @SuppressWarnings("resource")
    public void  Get_course_details() throws SQLException{
        System.out.println("course_name");
        Scanner sc = new Scanner(System.in);
        course_name = sc.nextLine();
        System.out.println("Enter course_id");
        course_id = sc.nextInt();
        System.out.println("Enter credit");
        credit = sc.nextInt();
        
        String querry = " insert into course values(?,?,?);";
        Connection con = Dbconnection.getConnection();
        PreparedStatement pst = con.prepareStatement(querry);
        pst.setString(1,course_name);
        pst.setInt(2, course_id);
        pst.setInt(3, credit);
        pst.executeUpdate();
        con.close();
        System.out.println("your course record updated successfully");
    }
}
