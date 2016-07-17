
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Model {

    private Connection connection;
    private String user, pass;
    private Home base;

    /* Que es esto? */
    @SuppressWarnings("empty-statement")

    public Model(Home base) {
        this.base = base;
    }

    /* Establece la conexion con la BD */
    public boolean connect(String bd, String usuario, String contrasena) {
        
        boolean re = false;
        
        try {
            String driverName = "org.postgresql.Driver";
            String url = "jdbc:postgresql://localhost:5432/" + bd;
            Class.forName(driverName);
            Connection conn = DriverManager.getConnection(url, usuario, contrasena);
            
            if (conn != null)
                System.out.print("Conexion Establecida con Exito");
            
            this.connection = conn;
            re = true;
        }
        
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        catch (SQLException e) {
            e.printStackTrace();
        }

        return re;
    }

    /* Cierra la conexion a la BD */
    public boolean disconnect() {
        try {
            this.connection.close();
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

    public Connection getConnection() {
        return this.connection;
    }

    /* Las consultas deberian ir aqui */
    //
}
