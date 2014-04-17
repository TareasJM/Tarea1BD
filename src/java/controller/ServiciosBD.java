package controller;

import java.sql.*;

public class ServiciosBD {

    static Connection conexion;
    static Statement sentencia;
    static ResultSet resultado;
    static String query = "";

    public static void conectar() {
        String ruta = "jdbc:oracle:thin:@localhost:1521:xe";
        String usuario = "bd327_32";
        String password = "bd327";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
            conexion = DriverManager.getConnection(ruta, usuario, password);
            sentencia = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            System.out.println("CONECTO BIEN!!!");
        } catch (InstantiationException e) {
            System.out.println("NO CONECTO ERRORORORORORORROO!!");
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            System.out.println("NO CONECTO ERRORORORORORORROO!!");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("NO CONECTO ERRORORORORORORROO!!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("NO CONECTO ERRORORORORORORROO!!");
            e.printStackTrace();
        }
    }

    public static void ejecutarConsulta(String q) {
        query = q;

        try {


            resultado = sentencia.executeQuery(query);
System.out.println("se ejecuto consuloat");

        } catch (SQLException e) {
            System.out.println("NO LO EJEUCTO EERRRIIRIRIRRORORORORORORROO!!");
            e.printStackTrace();
        }
    }

    public static void ejecutarUpdate(String q) {
        query = q;

        try {


            sentencia.executeUpdate(query);


        } catch (SQLException e) {
            System.out.println("NO LO EJEUCTO EERRRIIRIRIRRORORORORORORROO!!");
            e.printStackTrace();
        }
    }
}
