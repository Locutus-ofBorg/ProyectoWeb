package com.vipper.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Hugo
 */
public class Conexion {
    
    protected Connection miConexion;
    
    public void abrirConexion() throws ClassNotFoundException, SQLException{
            Class.forName("com.mysql.cj.jdbc.Driver");
            miConexion = DriverManager.getConnection
                         ("jdbc:mysql://localhost:3306/abogados?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&autoReconnect=true&useSSL=false",
                          "root", "Curso2019$");
            System.out.println("Exito al Abrir!");
    }
    
    public void cerrarConexion() throws SQLException {
            miConexion.close();
            System.out.println("Exito al Cerrar!");
    }
    
}
