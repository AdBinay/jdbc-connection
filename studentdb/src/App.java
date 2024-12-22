//step1 : import required package
import java.sql.*;

public class App {
    public static void main(String[] args) throws Exception {
        //step 2 : Loading the Driver 
        Class.forName("com.mysql.cj.jdbc.Driver");

        //step 3: Connecting to database
        String url = "jdbc:mysql://localhost:3306/student_db";
        String user = "root";
        String password = "0935";

        //Step 4 : Creating connection object
        Connection con = DriverManager.getConnection(url, user, password);

        //step 5: creating statement object
        Statement stat = con.createStatement();
        //SQL query
        String str = "INSERT INTO tbl_student(id,name,address,phone) VALUES (1,'Ram','Pokhara','12345')";
        //Step 6: execute sql query
        stat.executeUpdate(str);
        System.out.println("Successfully connected to database");

        //step 7: Close the connection
        stat.close();
        con.close();
    }
}
