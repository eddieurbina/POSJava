
package pos.dao;

import java.net.ConnectException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import pos.vo.ProductosVo;

public class ProductosDAO extends ConexionSQLite {
    public ProductosVo getProducto(String producto) throws SQLException, ConnectException {
        ProductosVo productosvo = new ProductosVo();
        String query = "SELECT `nombre`, `modelo`, `precio`, `category`, `stock` FROM `productos` WHERE `nombre` = '" + producto + "'; ";
        Statement st;
        st = getConexion().createStatement();
        ResultSet rs = st.executeQuery(query);

        while (rs.next()) {
            productosvo.setNombre(rs.getString("nombre"));
            productosvo.setModelo(rs.getString("modelo"));
            productosvo.setPrecio(rs.getDouble("precio"));
            productosvo.setCategory(rs.getString("category"));
            productosvo.setStock(rs.getInt("stock"));
        }

        st.close();
        rs.close();
        conexion.close();
        return productosvo;
    }
    
    public void insertProducto(ProductosVo newProduct) throws SQLException, ConnectException {
        String query = "INSERT INTO `productos` "
                + "( `nombre`, `modelo`, `precio`, `category`, `stock`) "
                + "VALUES ('"+ newProduct.getNombre() + "', '" + newProduct.getModelo() + "','" + newProduct.getPrecio() + "' ,"
                + "'" + newProduct.getCategory() + "', "
                + "'" + newProduct.getStock() + "');";
        PreparedStatement ps = getConexion().prepareStatement(query);

        ps.executeUpdate();
        conexion.close();
    }
    
      public ArrayList<ProductosVo> getListaProductos() throws SQLException, ConnectException {
        ArrayList<ProductosVo> listaProductos = new ArrayList<>();
        String query = "SELECT `nombre`, `modelo`, `precio`, `category`, `stock` FROM `productos`; ";
        Statement st;
        st = getConexion().createStatement();
        ResultSet rs = st.executeQuery(query);

        while (rs.next()) {
            ProductosVo productosvo = new ProductosVo();
            productosvo.setNombre(rs.getString("nombre"));
            productosvo.setModelo(rs.getString("modelo"));
            productosvo.setPrecio(rs.getDouble("precio"));
            productosvo.setCategory(rs.getString("category"));
            productosvo.setStock(rs.getInt("stock"));
            listaProductos.add(productosvo);
        }

        st.close();
        rs.close();
        conexion.close();
        return listaProductos;
    }

      
    
}
