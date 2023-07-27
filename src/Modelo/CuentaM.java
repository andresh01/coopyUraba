package Modelo;

import com.sun.rowset.CachedRowSetImpl;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.sql.rowset.CachedRowSet;

public class CuentaM {
    private int idCuenta;
    private int idCliente;
    private String tipoCuenta;
    private int saldo;
    private String fApert;
    private String estado;
    private String festado;

    public CuentaM() {
    }

    public CuentaM(int idCuenta, int idCliente, String tipoCuenta, int saldo, String fApert, String estado, String festado) {
        this.idCuenta = idCuenta;
        this.idCliente = idCliente;
        this.tipoCuenta = tipoCuenta;
        this.saldo = saldo;
        this.fApert = fApert;
        this.estado = estado;
        this.festado = festado;
    }

    public CuentaM(int idCliente, String tipoCuenta, int saldo, String fApert, String estado, String festado) {
        this.idCliente = idCliente;
        this.tipoCuenta = tipoCuenta;
        this.saldo = saldo;
        this.fApert = fApert;
        this.estado = estado;
        this.festado = festado;
    }
    

    public String getFestado() {
        return festado;
    }

    public void setFestado(String festado) {
        this.festado = festado;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public String getfApert() {
        return fApert;
    }

    public void setfApert(String fApert) {
        this.fApert = fApert;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public String registrarCuenta()throws Exception{
        PreparedStatement pst;
        pst = Conexion.open().prepareCall("CALL spRegistrarCuenta(?,?,?,?,?,?,?)");
        pst.setInt(1, idCuenta);
        pst.setInt(2, idCliente);
        pst.setString(3, tipoCuenta);
        pst.setInt(4, saldo);
        pst.setString(5, fApert);
        pst.setString(6, estado);
        pst.setString(7, festado);
        ResultSet rs = pst.executeQuery();
        rs.next();
        String msj = rs.getString(1);
        Conexion.open().close();
        return msj;
    }
    
    public CachedRowSet buscarCuenta(int id, String tc) throws Exception{
        PreparedStatement pst;
        pst = Conexion.open().prepareCall("CALL spBuscarCuenta(?,?)");
        pst.setInt(1, id);
        pst.setString(2, tc);
        ResultSet rs = pst.executeQuery();
        CachedRowSet crs = new CachedRowSetImpl();
        crs.populate(rs);
        Conexion.open().close();
        return crs;
    }
    
    public String nroCuenta()throws Exception{
        PreparedStatement pst;
        pst = Conexion.open().prepareCall("CALL spNcuenta()");
        
        ResultSet rs = pst.executeQuery();
        rs.next();
        String msj = rs.getString(1);
        Conexion.open().close();
        return msj;
    }
}
