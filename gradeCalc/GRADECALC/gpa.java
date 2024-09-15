package GRADECALC;

import java.sql.*;
import java.util.Scanner;

public class gpa {
    public void gpa_register() throws SQLException{
        int average =0;
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.println("enter student_id");
        int id_check = sc.nextInt();
        String query1 = " select average from student where stu_id = "+id_check;
        Connection con = Dbconnection.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query1);
         if (rs.next()) {
                average = rs.getInt("average");
            }
           int gppa =  gpaConv(average);
            String query6 = "UPDATE student SET gpa = ? WHERE stu_id = ?";
            PreparedStatement pstmt1 = con.prepareStatement(query6);
            pstmt1.setInt(1, gppa);  
            pstmt1.setInt(2,id_check);
            pstmt1.executeUpdate();
            System.out.println("gpa seted succesfully");
    }
    public static int  gpaConv(int average){
        if(average >50 && average <= 70)return 6;
        else if(average >20 && average<=50)return 4;
        else if(average >=1 && average <=20)return 2;
        else if(average >70 && average <= 90)return 8;
        else if (average >90 && average <= 100) return 10;
        return 0;
    }
    
}
