package pos.dao;
//Pool de Conexio

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.dbcp.BasicDataSource;

public class ConexionDAO {

    static String DRIVER = "org.gjt.mm.mysql.Driver";
    static String USER = "root";
    static String PASSWORD = "";
    static String SERVIDOR = "localhost";
    static String BASE = "posjava";
    public static String NOMBREBASE = "posjava";
    static String URL = "jdbc:mysql://" + SERVIDOR + ":3306/" + BASE;
    BasicDataSource basicDataSource = new BasicDataSource();

    public ConexionDAO() {

        URL = "jdbc:mysql://" + SERVIDOR + ":3306/" + BASE;

    }

    Connection conexion;

    public Connection getConexion() throws SQLException, ConnectException {

        basicDataSource.setDriverClassName(DRIVER);
        basicDataSource.setUsername(USER);
        basicDataSource.setPassword(PASSWORD);
        basicDataSource.setUrl(URL);

// Opcional. Sentencia SQL que le puede servir a BasicDataSource
// para comprobar que la conexion es correcta.
        basicDataSource.setValidationQuery("select 1");

//        conexion = (Connection) DriverManager.getConnection(URL, USER, PASSWORD);
        //  util.Util.getLog().info("Conexion Establecida.."+URL);
        basicDataSource.setMaxActive(50);
        conexion = basicDataSource.getConnection();

        return conexion;

    }

    public void setConexion(Connection conexion) {

        this.conexion = conexion;
    }

}
