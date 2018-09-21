
package pos.vo;

import java.util.Date;


public class UsuarioVo {
    private String nombre;
    private String apellido;
    private String usuario;
    private String password; 
    private Date fechaNacimiento;
    private int activo;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "UsuarioVo {" + "nombre=" + nombre + 
                ", apellido=" + apellido + ", usuario=" + usuario + ", password=" + 
                password + ", fechaNacimiento=" + fechaNacimiento + ", activo=" + 
                activo + '}';
    }
}
