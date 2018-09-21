package pos.dao;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionSQLite {

    Connection conexion;
    String PATH = "C:\\Curso\\FundamentosJava\\POS Swing\\Databases\\POSQLite.db"; 
    public Connection getConexion() throws SQLException, ConnectException {
        try {
            Class.forName("org.sqlite.JDBC");
             conexion = DriverManager.getConnection("jdbc:sqlite:" + PATH);
             System.out.println("-------------------");
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Error en la conexión de la base de datos" + ex.toString());
        }

        return conexion;

    }

    public void setConexion(Connection conexion) {

        this.conexion = conexion;
    }
}
