package dto_strategy;

import connection.Conexion;
import java.sql.*;
import java.util.*;
import dao.PersonaDAO;

public class PersonaDTO implements IObjectDTO {

    private Connection conexionTransaccional;
    private final static String SQL_SELECT = "SELECT id_persona, nombre, apellido, email, telefono FROM persona";
    private final static String SQL_INSERT = "INSERT INTO persona(id_persona, nombre, apellido, email, telefono) VALUES(?, ?, ?, ?, ?)";
    private final static String SQL_UPDATE = "UPDATE persona SET nombre=?, apellido=?, email=?, telefono=?  WHERE id_persona = ?";
    private final static String SQL_DELETE = "DELETE FROM persona WHERE id_persona=?";

    public PersonaDTO() {
    }

    public PersonaDTO(Connection conexionTransaccional){
        this.conexionTransaccional = conexionTransaccional;
    }

    @Override
    public List select() {
        List<PersonaDAO> listObj = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        PersonaDAO persona;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                persona = new PersonaDAO();
                persona.setId(rs.getInt("id_persona"));
                persona.setNombre(rs.getString("nombre"));
                persona.setApellido(rs.getString("apellido"));
                persona.setEmail(rs.getString("email"));
                persona.setTelefono(rs.getInt("telefono"));

                listObj.add(persona);
                System.out.println("Exito en sentencia SQL SELECT");
            }
        } catch (SQLException ex) {
            System.out.println("Fallo sentencia SQL SELECT");
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            if (this.conexionTransaccional == null) {
                Conexion.close(conn);
            }
        }
        return listObj;
    }

    @Override
    public void insert(Object obj) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        PersonaDAO persona = (PersonaDAO) obj;
        try{
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, persona.getId());
            stmt.setString(2, persona.getNombre());
            stmt.setString(3, persona.getApellido());
            stmt.setString(4, persona.getEmail());
            stmt.setInt(5, persona.getTelefono());
            
            rows = stmt.executeUpdate();
            System.out.println("Filas envueltas: " + rows);
            System.out.println("Exito en sentencia SQL INSERT");
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
        PersonaDAO persona = (PersonaDAO) obj;
        
        try{
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellido());
            stmt.setString(3, persona.getEmail());
            stmt.setInt(4, persona.getTelefono());
            stmt.setInt(5, persona.getId());
            
            rows = stmt.executeUpdate();
            System.out.println("Filas envueltas: " + rows);
            System.out.println("Exito en sentencia SQL UPDATE");
        } catch(SQLException ex){
            System.out.println("Fallo sentencia SQL UPDATE");
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
        PersonaDAO persona = (PersonaDAO) obj;
        try{
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, persona.getId());
            
            rows = stmt.executeUpdate();
            System.out.println("Filas envueltas: " + rows);
            System.out.println("Exito en sentenica SQL DELETE");
        }catch(SQLException ex){
            System.out.println("Fallo sentencia SQL DELETE");
            ex.printStackTrace(System.out);
        } finally{
            Conexion.close(stmt);
            if(this.conexionTransaccional == null ){
                Conexion.close(conn);
            }
        }
    }

}
