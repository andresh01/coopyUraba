package Controlador;

import Modelo.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TransaccionC {
    private int idT;
    private int nCuenta;
    private String tipo;
    private String fecha;
    private int valor;

    public TransaccionC() {
    }

    public TransaccionC(int idT, int nCuenta, String tipo, String fecha, int valor) {
        this.idT = idT;
        this.nCuenta = nCuenta;
        this.tipo = tipo;
        this.fecha = fecha;
        this.valor = valor;
    }

    public TransaccionC(int nCuenta, String tipo, String fecha, int valor) {
        this.nCuenta = nCuenta;
        this.tipo = tipo;
        this.fecha = fecha;
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getIdT() {
        return idT;
    }

    public void setIdT(int idT) {
        this.idT = idT;
    }

    public int getnCuenta() {
        return nCuenta;
    }

    public void setnCuenta(int nCuenta) {
        this.nCuenta = nCuenta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    public String registrarTrans() throws Exception{
        TransaccionM obj = new TransaccionM(nCuenta, tipo, fecha, valor);
        return obj.registrarTrans();
    }
}
