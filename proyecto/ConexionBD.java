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

    private Connection connection = null;
    private String user = null;
    private String pass = null;
    private String bd = null;

    @SuppressWarnings("empty-statement")

    public ConexionBD(String bd, String user, String pass) {
        this.modConnection(bd, user, pass);
    }

    public void modConnection(String bd, String user, String pass) {
        this.bd = bd;
        this.user = user;
        this.pass = pass;
    }

    public boolean connect() {
        boolean re = false;
        try {
            String driverName = "org.postgresql.Driver";
            String url = "jdbc:postgresql://localhost:5432/" + this.bd;
            Class.forName(driverName);
            Connection conn = DriverManager.getConnection(url, this.user, this.pass);
            if (conn != null)
               System.out.print("Conexion Establecida con Exito");
            
            this.connection = conn;
            re = true;

        } catch (ClassNotFoundException exc) {
            JOptionPane.showMessageDialog (null, "No se encontró el Driver de la BD"+exc.getMessage(), "Error Conexion", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog (null, "Error: " + e.getMessage(), "Error de Conexion", JOptionPane.ERROR_MESSAGE);
        }
        return re;
    }

    public boolean disconnect() {
        try {
            if (this.connection != null) {
                this.connection.close();
                this.connection = null;
            }
            return true;
        }
        catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* Informacion de la conexion */

    public String getUser() {
        return this.user;
    }

    public String getPass() {
        return this.pass;
    }

    public String getDataBase() {
        return this.bd;
    }

    public Connection getConnection() {
        return this.connection;
    }

    //
    /**** Aqui deberian ir las operaciones ****/
}
