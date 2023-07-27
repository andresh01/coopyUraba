package Controlador;

import Modelo.*;
import com.sun.rowset.CachedRowSetImpl;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.sql.rowset.CachedRowSet;

public class CuentaC {
    private int idCuenta;
    private int idCliente;
    private String tipoCuenta;
    private int saldo;
    private String fApert;
    private String estado;
    private String festado;

    public CuentaC() {
    }

    public CuentaC(int idCuenta, int idCliente, String tipoCuenta, int saldo, String fApert, String estado, String festado) {
        this.idCuenta = idCuenta;
        this.idCliente = idCliente;
        this.tipoCuenta = tipoCuenta;
        this.saldo = saldo;
        this.fApert = fApert;
        this.estado = estado;
        this.festado = festado;
    }

    public CuentaC(int idCliente, String tipoCuenta, int saldo, String fApert, String estado, String festado) {
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
        CuentaM obj = new CuentaM(idCuenta,idCliente, tipoCuenta, saldo, fApert, estado, festado);
        return obj.registrarCuenta();
    }
    
    public String nroCuenta()throws Exception{
        CuentaM obj = new CuentaM();
        return obj.nroCuenta();
    }
}
