/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

   
public class ConexionBD {

    @SuppressWarnings("empty-statement")


    public Connection obtConexion(String bd,String usuario,String contrasena) throws SQLException {
        try {
            String driverName = "org.postgresql.Driver";
            String url = "jdbc:postgresql://localhost:5432/"+bd;
            Class.forName(driverName);
            Connection conn = DriverManager.getConnection(url, usuario, contrasena);
            if (conn != null)
                //JOptionPane.showMessageDialog(null, "Conexión establecida con éxito!!", "Suceso", JOptionPane.INFORMATION_MESSAGE);
               System.out.print("Conexion Establecida con Exito");
            return conn;

        } catch (ClassNotFoundException exc) {
            JOptionPane.showMessageDialog (null, "No se encontró el Driver de la BD"+exc.getMessage(), "Error Conexion", JOptionPane.ERROR_MESSAGE);
            return null;
        } catch (SQLException e) {
            //JOptionPane.showMessageDialog(null, "No pudo establecerse la Conexión.", "Error", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog (null, "Error: "+e.getMessage(), "Error Conexion", JOptionPane.ERROR_MESSAGE);
            return null;
        }
 }
}
