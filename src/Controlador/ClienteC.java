package Controlador;

import Modelo.*;
import javax.sql.rowset.CachedRowSet;

public class ClienteC {

    private int idCliente;
    private String tipoCliente;
    private String nombre;
    private String Apellido;
    private int telefono;
    private boolean estado;

    public ClienteC() {
    }

    public ClienteC(int idCliente, String tipoCliente, String nombre, String Apellido, int telefono, boolean estado) {
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
        ClienteM obj = new ClienteM(idCliente, tipoCliente, nombre, Apellido, telefono, estado);
        return obj.registrarCliente();
    }

    public String eliminarCliente(int id) throws Exception {
        ClienteM obj = new ClienteM();
        return obj.eliminarCliente(id);
    }
    
    public CachedRowSet buscarCliente(int id) throws Exception{
        ClienteM obj = new ClienteM(); 
        return obj.buscarCliente(id);
    }
    
    public String modificarCliente() throws Exception {
        ClienteM obj = new ClienteM(idCliente, tipoCliente, nombre, Apellido, telefono, estado);
        return obj.modificarCliente();
    }

    public CachedRowSet buscarCuenta(int id, String cta) throws Exception{
        ClienteM obj = new ClienteM(); 
        return obj.buscarCuenta(id, cta);
    }
}
