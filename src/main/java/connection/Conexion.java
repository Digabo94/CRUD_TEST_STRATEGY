package connection;

import java.sql.*;

public class Conexion {
    
    private static final String JDBC_URL = "jdbc:mysql://localhost/team?useSSL=false&serverTimezone=UTC";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASS = "myROOTpassword12345_";
            
    public static Connection getConnection(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally{
            return conn;
        }
    }
    
    
    public static void close(ResultSet rs){
        try {
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    
    public static void close(PreparedStatement stmt){
        try{
            stmt.close();
        } catch(SQLException ex){
            ex.printStackTrace(System.out);
        }
    }
    
    
    public static void close(Connection conn){
        try{
            conn.close();
        } catch(SQLException ex){
            ex.printStackTrace(System.out);
        }
    }
}
