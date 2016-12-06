package org.openshift.quickstarts.todolist.common;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.SQLException;  
  
public class DBHelper {  
    public static  String url = "jdbc:mysql://10.1.41.4:3306/sampledb";  
    public static  String name = "com.mysql.jdbc.Driver";  
    public static  String user = "myuser";  
    public static  String password = "root";  
//    public static  String url = "jdbc:mysql://192.168.102.101:3306/09bao?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&autoReconnect=true&allowMultiQueries=true";  
//    public static  String name = "com.mysql.jdbc.Driver";  
//    public static  String user = "root";  
//    public static  String password = "root";  
  
    public Connection conn = null;  
    public PreparedStatement pst = null;  
  
    public DBHelper() {  
        try {  
            Class.forName(name);//指定连接类型  
            conn = DriverManager.getConnection(url, user, password);//获取连接    
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
    
    public boolean test(){
        try {  
            conn.prepareStatement("SELECT 1 FROM DUAL").executeQuery();
            return true;
        } catch (Exception e) {  
            e.printStackTrace(); 
            return false;
        } 
    }
  
    public void close() {  
        try {  
            this.conn.close();  
            this.pst.close();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
    }  
}