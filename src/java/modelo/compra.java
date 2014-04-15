/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

/**
 *
 * @author jose
 */
public class compra
{
    private int id_compra;
    private int monto_total;
    private String fecha;
    private String hora;

    public compra(int id,int monto, String fecha, String hora)
    {
        this.id_compra = id;
        this.monto_total= monto;
        this.fecha = fecha;
        this.hora = hora;
        
    }

    public int getIDCompra()
    {
        return this.id_compra;
    }
    public int getMonto()
    {
        return this.monto_total;
    }
    public String getFecha()
    {
        return this.fecha;
    }
    public String getHora()
    {
        return this.hora;
    }

}

