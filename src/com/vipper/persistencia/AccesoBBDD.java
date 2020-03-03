package com.vipper.persistencia;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccesoBBDD extends Conexion {

	public String verificarPassword ( String usuario ) throws SQLException, ClassNotFoundException {
		
		String sql = "{ call verificarPassword (?) }";
        CallableStatement st;
        ResultSet rs;
        
        String password = null;
        
        abrirConexion();
        
        st = miConexion.prepareCall(sql);
        
        st.setString(1, usuario);
        
        rs = st.executeQuery();
        
        if ( rs.next() ) {
        	password = rs.getString("password");
        }
        
        System.out.println("---" + password);
        
        cerrarConexion();
        
        return password;
	}
}
