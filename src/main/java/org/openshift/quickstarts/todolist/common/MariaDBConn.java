package org.openshift.quickstarts.todolist.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class MariaDBConn {  
    final String DBDRIVER = "org.mariadb.jdbc.Driver";  
    final String DBURL = "jdbc:mariadb://localhost:3306/test";  
    //final String DBDRIVER = "com.mysql.jdbc.Driver"; //if you use mysql  
    //final String DBURL = "jdbc:mysql://localhost:3306/test";//if you use mysql  
    final String DBUSER = "root";  
    final String DBPWD = "123";  
    Connection conn = null;//数据库连接  
  
    public MariaDBConn() {  
        try {  
            Class.forName(DBDRIVER);// load the Connecting class  
            conn = DriverManager.getConnection(DBURL, DBUSER, DBPWD);             
        }catch (ClassNotFoundException | SQLException e){  
            e.printStackTrace();  
        }  
    }  
    //another version to initialize with new parameters but not defautl parameters  
    public MariaDBConn(String dbUrl, String dbUser, String dbPwd) {  
        try {  
            Class.forName(DBDRIVER);  
            conn = DriverManager.getConnection(dbUrl, dbUrl, dbPwd);  
        }catch (ClassNotFoundException | SQLException e) {  
            e.printStackTrace();  
        }  
    }  
      
    public Connection getConn() {  
        return conn;  
    }  
    public void setConn(Connection conn) {  
        this.conn = conn;  
    }  
    public void closeConn(){  
        try {  
            conn.close();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
    }  
}