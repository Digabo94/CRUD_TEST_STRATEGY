package dto_strategy;

import connection.Conexion;
import java.sql.*;
import java.util.*;
import dao.PerroDAO;


public class PerroDTO implements IObjectDTO{
    
    private Connection conexionTransaccional;
    private final static String SQL_SELECT = "SELECT id_perro, raza, comportamiento, edad FROM perro";
    private final static String SQL_INSERT = "INSERT INTO perro(id_perro, raza, comportamiento, edad) VALUES(?, ?, ?, ?)";
    private final static String SQL_UPDATE = "UPDATE perro SET raza=?, comportamiento=?, edad=? WHERE id_perro=?";
    private final static String SQL_DELETE = "DELETE FROM perro WHERE id_perro=?";
    
    public PerroDTO(){
    }

    
    public PerroDTO(Connection conexionTransaccional){
        this.conexionTransaccional = conexionTransaccional;
    }
            
    @Override
    public List select() {
        List list = new ArrayList<>();
        PerroDAO perro;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try{
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while(rs.next()){
                perro = new PerroDAO();
                perro.setId(rs.getInt("id_perro"));
                perro.setRaza(rs.getString("raza"));
                perro.setComportamiento(rs.getString("comportamiento"));
                perro.setEdad(rs.getInt("edad"));
                
                list.add(perro);
                System.out.println("Exito en sentencia SQL SELECT");
            }
        }catch(SQLException ex){
            System.out.println("Fallo sentencia SQL SELECT");
            ex.printStackTrace(System.out);
        } finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            if(this.conexionTransaccional == null){
                Conexion.close(conn);
            }
        }
        return list;
    }
    
    

    @Override
    public void insert(Object obj) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        PerroDAO perro = (PerroDAO) obj;
        try{
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, perro.getId());
            stmt.setString(2, perro.getRaza());
            stmt.setString(3, perro.getComportamiento());
            stmt.setInt(4, perro.getEdad());
            
            rows = stmt.executeUpdate();
            System.out.println("Filas envueltas: " + rows);
            System.out.println("Exito en setencia SQL INSERT");
        }catch(SQLException ex){
            System.out.println("Fallo sentencia SQL INSERT");
            ex.printStackTrace(System.out);
        } finally{
            Conexion.close(stmt);
            if(this.conexionTransaccional == null){
                Conexion.close(conn);
            }
        }
    }

    @Override
    public void update(Object obj) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        PerroDAO perro = (PerroDAO) obj;
        try{
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, perro.getRaza());
            stmt.setString(2, perro.getComportamiento());
            stmt.setInt(3, perro.getEdad());
            stmt.setInt(4, perro.getId());
            
            rows = stmt.executeUpdate();
            System.out.println("Filas envueltas: " + rows);
            System.out.println("Exito en sentencia SQL UPDATE");
        }catch(SQLException ex){
            System.out.println("Fallo en sentencia SQL UPDATE");
            ex.printStackTrace(System.out);
        } finally{
            Conexion.close(stmt);
            if(this.conexionTransaccional == null){
                Conexion.close(conn);
            }
        }
    }

    @Override
    public void delete(Object obj) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        PerroDAO perro = (PerroDAO) obj;
        try{
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, perro.getId());
            
            rows = stmt.executeUpdate();
            System.out.println("Filas envueltas: " + rows);
            System.out.println("Exito en sentencia SQL DELETE");
        } catch(SQLException ex){
            System.out.println("Fallo en sentencia SQL DELETE");;
            ex.printStackTrace(System.out);
        } finally{
            Conexion.close(stmt);
            if(this.conexionTransaccional == null){
                Conexion.close(conn);
            }
        }
    }
    
}
