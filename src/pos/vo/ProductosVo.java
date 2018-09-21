
package pos.vo;

public class ProductosVo {
    String nombre;
    String modelo;
    double precio; 
    String category;
    int stock; 

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "ProductosVo{" + "nombre=" + nombre + ", modelo=" + modelo + 
                ", precio=" + precio + ", category=" + category + ", stock=" + stock + '}';
    }
    
}
