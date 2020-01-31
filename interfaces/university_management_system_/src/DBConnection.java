import java.sql.*;
import javax.swing.*;
import jdk.nashorn.internal.parser.TokenType;
import sun.java2d.d3d.D3DRenderQueue;
import sun.security.rsa.RSACore;

import static com.sun.deploy.uitoolkit.ToolkitStore.dispose;

public class DBConnection {

    private Connection conn;


    //creating database connection
    public DBConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/university_management_system","root","");
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null,"Failed to Connect to the Database or Connector Error","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }

    //creating student signup
    public void student_signup(String FirstName,String LastName,String UserName,String password,String Age,String id,String Email){
        try {
            Statement stmt1 = conn.createStatement();
            String dbop ="INSERT INTO student_signup VALUES('"+FirstName+"','"+LastName+"','"+UserName+"','"+password+"','"+Age+"','"+id+"','"+Email+"')";
            stmt1.execute(dbop);
            stmt1.close();

            JOptionPane.showMessageDialog(null, "You Have Succesfully Registered","INFORMATION",JOptionPane.INFORMATION_MESSAGE);
            dispose();



            Home_Page home=new Home_Page();
            home.setVisible(true);

        }catch(Exception e) {
            JOptionPane.showMessageDialog(null, "User name early exists","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
    public void lecture_signup(String FirstName,String LastName,String UserName,String password,String Age,String email,String id){
        try {
            Statement stmt1 = conn.createStatement();
            String dbop ="INSERT INTO lecture_signup VALUES('"+FirstName+"','"+LastName+"','"+UserName+"','"+password+"','"+Age+"','"+email+"','"+id+"')";
            stmt1.execute(dbop);
            stmt1.close();
            JOptionPane.showMessageDialog(null, "You Have Succesfully Registered","INFORMATION",JOptionPane.INFORMATION_MESSAGE);
            Home_Page home =new Home_Page();
            home.setVisible(true);
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null, "User name early exists","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }

    public void check_student(String name, String password,int j) {
        if(j==2){
            try {
                String insertion_query="SELECT First_Name,Last_Name,Age,Student_NO,Email FROM student_signup WHERE User_Name ='"+name+"' AND pasword ='"+password+"'";
                Statement st=conn.createStatement();
                ResultSet rs=st.executeQuery(insertion_query);
                if(rs.next()) {
                    lecture_details db=new lecture_details();
                    db.setVisible(true);
                    String fname=rs.getString("First_Name");
                    String lname=rs.getString("Last_Name");
                    String age=rs.getString("Age");
                    String id=rs.getString("Student_NO");
                    String email=rs.getString("Email");
                    db.show_details(fname, lname, age, id, email,name,j,password);
                    st.close();

                    try {
                        insertion_query="SELECT user_name,course_id FROM student_course WHERE user_Name ='"+name+"' AND course_id ='"+1+"'";
                        st=conn.createStatement();
                        ResultSet rs1=st.executeQuery(insertion_query);
                        if(rs1.next()) {
                            int i=1;
                            db.cause_details(name, i);

                        }
                    }catch(Exception e) {
                        JOptionPane.showMessageDialog(null, "Error","ERROR",JOptionPane.ERROR_MESSAGE);
                    }
                    try {
                        insertion_query="SELECT user_name,course_id FROM student_course WHERE User_Name ='"+name+"' AND course_id ='"+2+"'";
                        st=conn.createStatement();
                        ResultSet rs1=st.executeQuery(insertion_query);
                        if(rs1.next()) {
                            int i=2;
                            db.cause_details(name, i);
                        }
                    }catch(Exception e) {
                        JOptionPane.showMessageDialog(null, "Error","ERROR",JOptionPane.ERROR_MESSAGE);
                    }
                    try {
                        insertion_query="SELECT user_name,course_id FROM student_course WHERE User_Name ='"+name+"' AND course_id ='"+3+"'";
                        st=conn.createStatement();
                        ResultSet rs1=st.executeQuery(insertion_query);
                        if(rs1.next()) {
                            int i=3;
                            db.cause_details(name, i);
                        }
                    }catch(Exception e) {
                        JOptionPane.showMessageDialog(null, "Error","ERROR",JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid user name or passowrd","ERROR",JOptionPane.ERROR_MESSAGE);
                }
            }catch(Exception e) {
                JOptionPane.showMessageDialog(null, "Error","ERROR",JOptionPane.ERROR_MESSAGE);
            }

        }
    }



    public void check_lectureSignUp(String name, String password,int j) {
        if(j==1){
            try {
                String insertion_query="SELECT First_Name,Last_Name,Age,Lecture_Id,Email FROM lecture_signup WHERE User_name ='"+name+"' AND password ='"+password+"'";
                Statement st=conn.createStatement();
                ResultSet rs=st.executeQuery(insertion_query);
                if(rs.next()) {
                    lecture_details lecture=new lecture_details();
                    lecture.setVisible(true);
                    String fname=rs.getString("First_Name");
                    String lname=rs.getString("Last_Name");
                    String age=rs.getString("Age");
                    String id=rs.getString("Lecture_Id");
                    String email=rs.getString("Email");
                    lecture.show_details(fname, lname, age, id, email,name,j,password);
                    try {
                        insertion_query="SELECT user_name,course_id FROM lecture_course WHERE user_Name ='"+name+"' AND course_id ='"+1+"'";
                        st=conn.createStatement();
                        ResultSet rs1=st.executeQuery(insertion_query);
                        if(rs1.next()) {
                            int i=1;
                            lecture.cause_details(name, i);

                        }
                    }catch(Exception e) {
                        JOptionPane.showMessageDialog(null, "Error","ERROR",JOptionPane.ERROR_MESSAGE);
                    }
                    try {
                        insertion_query="SELECT user_name,course_id FROM lecture_course WHERE User_Name ='"+name+"' AND course_id ='"+2+"'";
                        st=conn.createStatement();
                        ResultSet rs1=st.executeQuery(insertion_query);
                        if(rs1.next()) {
                            int i=2;
                            lecture.cause_details(name, i);
                        }
                    }catch(Exception e) {
                        JOptionPane.showMessageDialog(null, "Error","ERROR",JOptionPane.ERROR_MESSAGE);
                    }
                    try {
                        insertion_query="SELECT user_name,course_id FROM lecture_course WHERE User_Name ='"+name+"' AND course_id ='"+3+"'";
                        st=conn.createStatement();
                        ResultSet rs1=st.executeQuery(insertion_query);
                        if(rs1.next()) {
                            int i=3;
                            lecture.cause_details(name, i);
                        }
                    }catch(Exception e) {
                        JOptionPane.showMessageDialog(null, "Error","ERROR",JOptionPane.ERROR_MESSAGE);
                    }


                }else{
                    JOptionPane.showMessageDialog(null,"Invalid user name or passowrd","ERROR",JOptionPane.ERROR_MESSAGE);
                }
            }catch(Exception e) {
                JOptionPane.showMessageDialog(null, "Error","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void StoreCourses(int i,int j,int k,String CurrentUserName,int person){
        if(person==2){
            try {
                String dbop;
                if(i==1){
                    try {
                        String insertion_query="SELECT user_name,course_id FROM student_course WHERE user_Name ='"+CurrentUserName+"' AND course_id ='"+1+"'";
                        Statement st=conn.createStatement();
                        ResultSet rs=st.executeQuery(insertion_query);
                        if(rs.next()){

                        }
                        else{
                            Statement stmt1 = conn.createStatement();
                            dbop ="INSERT INTO student_course VALUES('"+CurrentUserName+"','"+i+"')";
                            stmt1.execute(dbop);
                            stmt1.close();
                        }
                    }catch(Exception e) {
                        JOptionPane.showMessageDialog(null, "Error","ERROR",JOptionPane.ERROR_MESSAGE);
                    }

                }else{
                    Statement stmt1 = conn.createStatement();
                    dbop ="DELETE FROM student_course WHERE user_name='"+CurrentUserName+"' AND course_id='"+1+"'";
                    stmt1.execute(dbop);
                    stmt1.close();
                }
                if(j==2){
                    try {
                        String insertion_query="SELECT user_name,course_id FROM student_course WHERE user_Name ='"+CurrentUserName+"' AND course_id ='"+2+"'";
                        Statement st=conn.createStatement();
                        ResultSet rs=st.executeQuery(insertion_query);
                        if(rs.next()){

                        }
                        else{
                            Statement stmt1 = conn.createStatement();
                            dbop ="INSERT INTO student_course VALUES('"+CurrentUserName+"','"+j+"')";
                            stmt1.execute(dbop);
                            stmt1.close();
                        }
                    }catch(Exception e) {
                        JOptionPane.showMessageDialog(null, "Error","ERROR",JOptionPane.ERROR_MESSAGE);
                    }

                }else{
                    Statement stmt1 = conn.createStatement();
                    dbop ="DELETE FROM student_course WHERE user_name='"+CurrentUserName+"' AND course_id='"+2+"'";
                    System.out.println(dbop);
                    stmt1.execute(dbop);
                    stmt1.close();
                }
                if(k==3){
                    try {
                        String insertion_query="SELECT user_name,course_id FROM student_course WHERE user_Name ='"+CurrentUserName+"' AND course_id ='"+3+"'";
                        Statement st=conn.createStatement();
                        ResultSet rs=st.executeQuery(insertion_query);
                        if(rs.next()){

                        }
                        else{
                            Statement stmt1 = conn.createStatement();
                            dbop ="INSERT INTO student_course VALUES('"+CurrentUserName+"','"+3+"')";
                            stmt1.execute(dbop);
                            stmt1.close();
                        }
                    }catch(Exception e) {
                        JOptionPane.showMessageDialog(null, "Error","ERROR",JOptionPane.ERROR_MESSAGE);
                    }

                }else{
                    Statement stmt1 = conn.createStatement();
                    dbop ="DELETE FROM student_course WHERE user_name='"+CurrentUserName+"' AND course_id='"+3+"'";
                    stmt1.execute(dbop);
                    stmt1.close();
                }

                JOptionPane.showMessageDialog(null, "Completed","INFORMATION",JOptionPane.INFORMATION_MESSAGE);

                //Home_Page home=new Home_Page();
                // home.setVisible(true);

            }catch(Exception e) {
                JOptionPane.showMessageDialog(null, "Error","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        }else if(person==1){
            try {
                String dbop;
                if(i==1){
                    try {
                        String insertion_query="SELECT user_name,course_id FROM lecture_course WHERE user_Name ='"+CurrentUserName+"' AND course_id ='"+1+"'";
                        Statement st=conn.createStatement();
                        ResultSet rs=st.executeQuery(insertion_query);
                        if(rs.next()){

                        }
                        else{
                            Statement stmt1 = conn.createStatement();
                            dbop ="INSERT INTO lecture_course VALUES('"+CurrentUserName+"','"+i+"')";
                            stmt1.execute(dbop);
                            stmt1.close();
                        }
                    }catch(Exception e) {
                        JOptionPane.showMessageDialog(null, "Error","ERROR",JOptionPane.ERROR_MESSAGE);
                    }

                }else{
                    Statement stmt1 = conn.createStatement();
                    dbop ="DELETE FROM lecture_course WHERE user_name='"+CurrentUserName+"' AND course_id='"+1+"'";
                    stmt1.execute(dbop);
                    stmt1.close();
                }
                if(j==2){
                    try {
                        String insertion_query="SELECT user_name,course_id FROM lecture_course WHERE user_Name ='"+CurrentUserName+"' AND course_id ='"+2+"'";
                        Statement st=conn.createStatement();
                        ResultSet rs=st.executeQuery(insertion_query);
                        if(rs.next()){

                        }
                        else{
                            Statement stmt1 = conn.createStatement();
                            dbop ="INSERT INTO lecture_course VALUES('"+CurrentUserName+"','"+j+"')";
                            stmt1.execute(dbop);
                            stmt1.close();
                        }
                    }catch(Exception e) {
                        JOptionPane.showMessageDialog(null, "Error","ERROR",JOptionPane.ERROR_MESSAGE);
                    }

                }else{
                    Statement stmt1 = conn.createStatement();
                    dbop ="DELETE FROM lecture_course WHERE user_name='"+CurrentUserName+"' AND course_id='"+2+"'";
                    System.out.println(dbop);
                    stmt1.execute(dbop);
                    stmt1.close();
                }
                if(k==3){
                    try {
                        String insertion_query="SELECT user_name,course_id FROM lecture_course WHERE user_Name ='"+CurrentUserName+"' AND course_id ='"+3+"'";
                        Statement st=conn.createStatement();
                        ResultSet rs=st.executeQuery(insertion_query);
                        if(rs.next()){

                        }
                        else{
                            Statement stmt1 = conn.createStatement();
                            dbop ="INSERT INTO lecture_course VALUES('"+CurrentUserName+"','"+3+"')";
                            stmt1.execute(dbop);
                            stmt1.close();
                        }
                    }catch(Exception e) {
                        JOptionPane.showMessageDialog(null, "Error","ERROR",JOptionPane.ERROR_MESSAGE);
                    }

                }else{
                    Statement stmt1 = conn.createStatement();
                    dbop ="DELETE FROM lecture_course WHERE user_name='"+CurrentUserName+"' AND course_id='"+3+"'";
                    stmt1.execute(dbop);
                    stmt1.close();
                }

                JOptionPane.showMessageDialog(null, "Completed","INFORMATION",JOptionPane.INFORMATION_MESSAGE);

                //Home_Page home=new Home_Page();
                // home.setVisible(true);

            }catch(Exception e) {
                JOptionPane.showMessageDialog(null, "Error","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    public static void main(String[] args) {

    }
}

















