/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

/**
 *
 * @author jose
 */
public class usuario
{
    private String nombre;
    private String tipo;
    private String rut;
    private String pass;
    private int comision;

    public usuario(String nombre, String tipo, String rut, String pass, int comision)
    {
        this.nombre = nombre;
        this.tipo = tipo;
        this.rut = rut;
        this.pass = pass;
        this.comision = comision;
    }


}
