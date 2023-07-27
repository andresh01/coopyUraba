package Modelo;

import com.sun.rowset.CachedRowSetImpl;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.sql.rowset.CachedRowSet;

public class ClienteM {

    private int idCliente;
    private String tipoCliente;
    private String nombre;
    private String Apellido;
    private int telefono;
    private boolean estado;

    public ClienteM() {
    }

    public ClienteM(int idCliente, String tipoCliente, String nombre, String Apellido, int telefono, boolean estado) {
        this.idCliente = idCliente;
        this.tipoCliente = tipoCliente;
        this.nombre = nombre;
        this.Apellido = Apellido;
        this.telefono = telefono;
        this.estado = estado;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String registrarCliente() throws Exception {
        PreparedStatement pst;
        pst = Conexion.open().prepareCall("CALL spRegistrarCliente(?,?,?,?,?,?)");
        pst.setInt(1, idCliente);
        pst.setString(2, tipoCliente);
        pst.setString(3, nombre);
        pst.setString(4, Apellido);
        pst.setInt(5, telefono);
        pst.setBoolean(6, estado);
        ResultSet rs = pst.executeQuery();
        rs.next();
        String msj = rs.getString(1);
        Conexion.open().close();
        return msj;
    }

    public String eliminarCliente(int id) throws Exception {
        PreparedStatement pst;
        pst = Conexion.open().prepareCall("CALL spEliminarCliente(?)");
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        rs.next();
        String msj = rs.getString(1);
        Conexion.open().close();
        return msj;
    }

    public CachedRowSet buscarCliente(int id) throws Exception {
        PreparedStatement pst;
        pst = Conexion.open().prepareCall("CALL spBuscarCliente(?)");
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        CachedRowSet crs = new CachedRowSetImpl();
        crs.populate(rs);
        Conexion.open().close();
        return crs;
    }

    public String modificarCliente() throws Exception {
        PreparedStatement pst;
        pst = Conexion.open().prepareCall("CALL spModificarCliente(?,?,?,?,?,?)");
        pst.setInt(1, idCliente);
        pst.setString(2, tipoCliente);
        pst.setString(3, nombre);
        pst.setString(4, Apellido);
        pst.setInt(5, telefono);
        pst.setBoolean(6, estado);
        ResultSet rs = pst.executeQuery();
        rs.next();
        String msj = rs.getString(1);
        Conexion.open().close();
        return msj;
    }
    
    public CachedRowSet buscarCuenta(int id,String cta) throws Exception {
        PreparedStatement pst;
        pst = Conexion.open().prepareCall("CALL spBuscarCuenta(?,?)");
        pst.setInt(1, id);
        pst.setString(2, cta);
        ResultSet rs = pst.executeQuery();
        CachedRowSet crs = new CachedRowSetImpl();
        crs.populate(rs);
        Conexion.open().close();
        return crs;
    }
}
