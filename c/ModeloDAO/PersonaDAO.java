package ModeloDAO;

import Config.Conexion;
import Interfaces.CRUD;
import Modelo.Persona;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PersonaDAO implements CRUD{
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    Persona p = new Persona();

    @Override
    public List listar() {
       List<Persona>lista = new ArrayList<>(); 
       String sql = "select * from persona";
       
       try{
           con = cn.getConnection();
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           
           while(rs.next()){
               Persona p = new Persona();
               
               p.setId(rs.getInt("id"));
               p.setDNI(rs.getString("DNI"));
               p.setNom(rs.getString("Nombres"));
               
               lista.add(p);
           }
       }catch(Exception e){
           System.out.println("Error:" + e);
       }
       return lista;
    }

    @Override
    public Persona list(int id) {
        String sql = "select * from persona WHERE id =" +id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                p.setId(rs.getInt("id"));
                p.setDNI(rs.getString("DNI"));
                p.setNom(rs.getString("Nombres"));
            }
        } catch (Exception e) {
        }
        return p;
    }

    @Override
    public boolean add(Persona per) {
        String sql = "INSERT INTO persona(DNI, Nombres) VALUES (?, ?)";
        
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            
            ps.setString(1, per.getDNI());
            ps.setString(2, per.getNom());
            
            int filaAfectadas = ps.executeUpdate();
            
            return filaAfectadas > 0;    
        }catch(Exception e){
            // Imprime el mensaje de la excepción para facilitar la depuración
            e.printStackTrace();
            // Puedes lanzar una excepción personalizada o devolver false aquí
            return false;

        }
    }

    @Override
    public boolean edit(Persona per) {
        String sql = "UPDATE persona SET DNI = ?, Nombres = ? WHERE id = ?";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
         
            // Utiliza PreparedStatement para evitar la inyección SQL
            ps.setString(1, per.getDNI());
            ps.setString(2, per.getNom());
            ps.setInt(3, per.getId()); // Agrega el valor para el parámetro id

            // Ejecuta la actualización
            int filasAfectadas = ps.executeUpdate();

            // Verifica si se realizaron cambios en la base de datos
            return filasAfectadas > 0;
        } catch (Exception e) {
            // Imprime el mensaje de la excepción para facilitar la depuración
            e.printStackTrace();
            // Puedes lanzar una excepción personalizada o devolver false aquí
            return false;
        }
    }

    @Override
    public boolean eliminar(int id) {
        String sql = "DELETE FROM persona WHERE id = ?";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
         
            // Utiliza PreparedStatement para evitar la inyección SQL
            ps.setInt(1, id); // Agrega el valor para el parámetro id

            // Ejecuta la actualización
            int filasAfectadas = ps.executeUpdate();

            // Verifica si se realizaron cambios en la base de datos
            return filasAfectadas > 0;
        } catch (Exception e) {
            // Imprime el mensaje de la excepción para facilitar la depuración
            e.printStackTrace();
            // Puedes lanzar una excepción personalizada o devolver false aquí
            return false;
        }
    }
    
}
