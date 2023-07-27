package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TransaccionM {
    private int idT;
    private int nCuenta;
    private String tipo;
    private String fecha;
    private int valor;

    public TransaccionM() {
    }

    public TransaccionM(int idT, int nCuenta, String tipo, String fecha, int valor) {
        this.idT = idT;
        this.nCuenta = nCuenta;
        this.tipo = tipo;
        this.fecha = fecha;
        this.valor = valor;
    }

    public TransaccionM(int nCuenta, String tipo, String fecha, int valor) {
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
        PreparedStatement pst;
        pst = Conexion.open().prepareCall("CALL spRegistrarT(?,?,?,?)");
        
        pst.setInt(1, nCuenta);
        pst.setString(2, tipo);
        pst.setString(3, fecha);
        pst.setInt(4, valor);
        ResultSet rs = pst.executeQuery();
        rs.next();
        String msj = rs.getString(1);
        Conexion.open().close();
        return msj;
    }
}
