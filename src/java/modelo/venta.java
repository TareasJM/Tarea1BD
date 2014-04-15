/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

/**
 *
 * @author jose
 */
public class venta
{
    private int id_venta;
    private int id_cliente;
    private int id_usuario;
    private int monto_total;
    private String fecha;
    private String hora;

    public venta(int id_venta, int id_cliente, int id_usuario, int monto_total, String fecha, String hora)
    {
        this.id_venta = id_venta;
        this.id_cliente = id_cliente;
        this.id_usuario = id_usuario;
        this.monto_total = monto_total;
        this.fecha = fecha;
        this.hora = hora;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public int getId_venta() {
        return id_venta;
    }

    public int getMonto_total() {
        return monto_total;
    }
    



}
