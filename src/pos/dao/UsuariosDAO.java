package pos.dao;

import java.net.ConnectException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import pos.vo.UsuarioVo;

public class UsuariosDAO extends ConexionSQLite {

    public UsuarioVo getUsuario(String usuario) throws SQLException, ConnectException {
        UsuarioVo usuariovo = new UsuarioVo();
        String query = "SELECT `nombre`, `apellido`, `usuario`, `password`, `fechaNacimiento`, `activo` FROM `usuarios` WHERE `usuario` = '" + usuario + "'; ";
        Statement st;
        st = getConexion().createStatement();
        ResultSet rs = st.executeQuery(query);

        while (rs.next()) {
            usuariovo.setNombre(rs.getString("nombre"));
            usuariovo.setPassword(rs.getString("password"));
            usuariovo.setActivo(rs.getInt("activo"));
        }

        st.close();
        rs.close();
        conexion.close();
        return usuariovo;
    }

    public void insertUsuario(UsuarioVo newUser) throws SQLException, ConnectException {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); 
        
        String query = "INSERT INTO `usuarios` "
                + "( `nombre`, `apellido`, `usuario`, `password`, `fechaNacimiento`, `activo`) "
                + "VALUES ('"+newUser.getNombre() + "', '" + newUser.getApellido() + "','" + newUser.getUsuario() + "' ,"
                + "'" + newUser.getPassword() + "', "
                + "'" + formato.format(newUser.getFechaNacimiento()) + "', '" + newUser.getActivo() + "');";
        
        PreparedStatement ps = getConexion().prepareStatement(query);

        ps.executeUpdate();
        conexion.close();
    }
}
