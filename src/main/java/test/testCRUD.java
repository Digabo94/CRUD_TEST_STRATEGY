package test;

import client.*;
import connection.*;
import dao.*;
import dto_strategy.*;
import java.sql.*;
import java.util.*;

public class testCRUD {

    public static void main(String[] args) {

        PerroDAO[] perros = new PerroDAO[10];
        PersonaDAO[] personas= new PersonaDAO[10];;
        IObjectDTO objectDto;
        Connection conn = null;
        Contexto contexto, contexto2;
        List lista;

        try {
            conn = Conexion.getConnection();
            if (conn.getAutoCommit()) {
                conn.setAutoCommit(false);
            }

            objectDto = new PersonaDTO(conn);
            contexto = new Contexto(objectDto);
            personas[0] = new PersonaDAO(12, "Arnolcdsd", "Swarzenncaeger", "arz1dddddddd@outlook.com", 0332323);
            perros[0] = new PerroDAO(3, "frfr", "frwfrr", 32);
            contexto.executeUpdate(personas[0]);
            
            
            
            lista = contexto.executeSelect();
            for (Object item : lista) {
                System.out.println(item);
            }
            contexto.executeDelete(personas[0]);
            
            objectDto = new PerroDTO(conn);
            contexto = new Contexto(objectDto);
            contexto.executeUpdate(perros[0]);
            lista = contexto.executeSelect();
            
            for (Object item : lista) {
                System.out.println(item);
            }
            contexto.executeDelete(perros[0]);

            conn.commit();
            System.out.println("Commit con exito");
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            try {
                System.out.println("Entrando rollback...");
                conn.rollback();
            } catch (SQLException exx) {
                System.out.println("Fallo rollback...");
                exx.printStackTrace();
            }
        }

    }
}
