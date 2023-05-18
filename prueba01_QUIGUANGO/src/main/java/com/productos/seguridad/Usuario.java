package com.productos.seguridad;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.productos.datos.*;

public class Usuario {

	private String nombre;
	private String direccion;
	private String login;
	private String clave;
	private Integer perfil;

	public boolean verificarUsuario(String nlogin, String nclave) {
		boolean respuesta = false;
		String sentencia = "Select * from tb_usuarios where "
				+ "login_us='" + nlogin + "' and clave_us='" 
				+ nclave + "';";
		// System.out.print(sentencia);
		try {
			ResultSet rs;
			Conexion clsCon = new Conexion();
			rs = clsCon.Consulta(sentencia);
			if (rs.next()) {
				respuesta = true;
				this.setLogin(nlogin);
				this.setClave(nclave);
				this.setPerfil(rs.getInt(2));
				this.setNombre(rs.getString(3));
			} else {
				respuesta = false;
				rs.close();
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return respuesta;
	}
	
// étodo para actualizar la clave del administrador en la base de datos
public static void actualizarClave(int administradorId, String nuevaClave) {
    Conexion connection = new Conexion();
    PreparedStatement statement = null;
    
    try {// Obtener la conexión a la base de datos
        String query = "UPDATE tb_usuarios SET clave_us = ? WHERE id_us = ?";
        statement = connection.Consulta(query);
        statement.setString(1, nuevaClave);
        statement.setInt(2, administradorId);
        statement.executeUpdate();
        
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        ConexionDB.cerrarStatement(statement);
        ConexionDB.cerrarConexion(connection);
    }
}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public Integer getPerfil() {
		return perfil;
	}

	public void setPerfil(Integer perfil) {
		this.perfil = perfil;
	}

}
