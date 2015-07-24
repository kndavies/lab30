package mySqlConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlConnection {
    public static Connection getConnection() throws Exception {
        //String driver = "com.mysql.jdbc.Driver";
    	try{
    		Class.forName("com.mysql.jdbc.Driver");
    	}
    	catch(ClassNotFoundException e){
    		e.printStackTrace();
    	}
        String url = "jdbc:mysql://localhost:3306/movies";
        String username = "root";
        String password = myPassword.p;
        //Class.forName(driver);
        Connection con = DriverManager.getConnection(url, username, password);
        return con;
}
}
