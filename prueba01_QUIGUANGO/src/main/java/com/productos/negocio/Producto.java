package com.productos.negocio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.*;
import java.util.*;

import com.productos.datos.*;

public class Producto {

	private int id;
	private String nombre;
	private int cantidad;
	private float precio;
	private String foto;
	
	private int id_pr;
	private int id_cat;
	private String descripcion_pr;;
	private double  precio_pr;
	private int cantidad_pr;

	 //new Producto(cod,des,pre,can)
	
	public Producto() {
		this.id = 0;
		this.nombre = "";
		this.precio = 0;
		this.cantidad = 0;
	}
	
	public Producto(int cod, String des, float pre, int can) {
		setId_pr(cod);
		setDescripcion_pr(des);
		setPrecio_pr(pre);
		setCantidad_pr(can);
	}
	
	public String consultarTodo() {
		String sql = "SELECT * FROM tb_producto ORDER BY id_pr";
		Conexion con = new Conexion();
		String tabla = "<table border=2><th>ID</th><th>Producto</th><th>Cantidad</th><th>Precio</th>";
		ResultSet rs = null;
		rs = con.Consulta(sql);
		try {
			while (rs.next()) {
				tabla += "<tr><td>" + rs.getInt(1) + "</td>" + "<td>" + rs.getString(3) + "</td>" + "<td>"
						+ rs.getInt(4) + "</td>" + "<td>" + rs.getDouble(5) + "</td>" + "</td></tr>";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.print(e.getMessage());
		}
		tabla += "</table>";
		return tabla;
	}
	
	public String consultarTodoVendedor() {
		String sql = "SELECT * FROM tb_producto ORDER BY id_pr";
		Conexion con = new Conexion();
		String tabla = "<table border=2><th>ID</th><th>Producto</th><th>Cantidad</th><th>Precio</th>";
		ResultSet rs = null;
		rs = con.Consulta(sql);
		try {
			while (rs.next()) {
				tabla += "<tr><td>" + rs.getInt(1) + "</td>" + "<td>" + rs.getString(3) + "</td>" + "<td>"
						+ rs.getInt(4) + "</td>" + "<td>" + rs.getDouble(5) + "</td>" + "</td></tr>"
						+ "<td> <a href= buscarProducto.jsp?cod=" + rs.getInt(1) + "><pre style=\"text-align: center\">Modificar</pre></a></td>"
						+ "<td> <a href= eliminarProducto.jsp?cod=" + rs.getInt(1) + " \"><pre style=\"textalign: center\">Eliminar</pre></a></td>";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.print(e.getMessage());
		}
		tabla += "</table>";
		return tabla;
	}
	

	public String buscarProductoCategoria(int cat) {
		String sentencia = "SELECT descripcion_pr, precio_pr FROM tb_producto WHERE id_cat=" + cat;
		Conexion con = new Conexion();
		ResultSet rs = null;
		String resultado = "<table border=3>";
		try {
			rs = con.Consulta(sentencia);
			while (rs.next()) {
				resultado += "<tr><td>" + rs.getString(1) + "</td>" + "<td>" + rs.getDouble(2) + "</td></tr>";
			}
			resultado += "</table>";
		} catch (SQLException e) {
			System.out.print(e.getMessage());
		}
		System.out.print(resultado);
		return resultado;
	}

	public String ingresarProducto(int cat, String nombre, int cantidad, double precio, String directorio) {
		String result = "";
		Conexion con = new Conexion();
		PreparedStatement pr = null;
		String sql = "INSERT INTO tb_producto(id_cat,nombre_pr,cantidad_pr,precio_pr,foto_pr) "
				+ "VALUES(?,?,?,?,?)";
		try {
			pr = con.getConexion().prepareStatement(sql);
			
			pr.setInt(1, cat);
			pr.setString(2, nombre);
			pr.setInt(3, cantidad);
			pr.setDouble(4, precio);
			File fichero = new File(directorio);
			FileInputStream streamEntrada = new FileInputStream(fichero);
			pr.setBinaryStream(6, streamEntrada, (int) fichero.length());
			if (pr.executeUpdate() == 1) {
				result = "Inserción correcta";
			} else {
				result = "Error en inserción";
			}
		} catch (Exception ex) {
			result = ex.getMessage();
		} finally {
			try {
				pr.close();
				con.getConexion().close();
			} catch (Exception ex) {
				System.out.print(ex.getMessage());
			}
		}
		return result;
	}
	
	public void ConsulEditarProductos(int cod) {
		Conexion obj = new Conexion();
		ResultSet rs = null;
		
		String sql = "SELECT id_pr,id_cat,descripcion_pr,precio_pr,cantidad_pr FROM tb_producto where id_pr = '"+cod+"'";
		
		try {
			rs = obj.Consulta(sql);
			while(rs.next()) {
				setId_pr(rs.getInt(1));
				setId_cat(rs.getInt(2));
				setDescripcion_pr(rs.getString(3));
				setCantidad_pr(rs.getInt(4));
				setPrecio_pr(rs.getFloat(5));
			}
		}catch(Exception e) {
			
		}
	}
	
public void ofertas(int producto, int p_oferta) {

	// Establecer la conexión con la base de datos
	Conexion con = null;
	String url = "jdbc:postgresql://localhost:5432/db_producto"; // Reemplaza con la URL de tu base de datos
	String usuario = "postgres"; // Reemplaza con tu nombre de usuario de la base de datos
	String contraseña = "1234"; // Reemplaza con tu contraseña de la base de datos

	try {
	   
	    // Crear la consulta SQL para insertar la oferta
	    String consulta = "INSERT INTO tabla_ofertas (producto, precio_oferta) VALUES (?, ?)";
	    PreparedStatement pstmt = con.prepareStatement(consulta);
	    pstmt.setString(1, producto);
	    pstmt.setString(2, precioOferta);

	    // Ejecutar la consulta
	    pstmt.executeUpdate();

	    // Cerrar la conexión
	    pstmt.close();
	    con.close();

	    // Mostrar un mensaje de confirmación
	    out.print("Oferta colocada en la base de datos correctamente");
	} catch (Exception e) {
	    // Manejar cualquier error que pueda ocurrir
	    out.print("Error al colocar la oferta en la base de datos: " + e.getMessage());
	}
}
	public boolean ModificarProducto(Producto mp) {
		Conexion obj = new Conexion();
		ResultSet rs = null;
		
		String sql = "UPDATE tb_producto SET descripcion_pr = '" + mp.getDescripcion_pr() + "', precio_pr = '" + mp.getPrecio_pr() +"',"
				+ "cantidad_pr = '" + mp.getCantidad_pr() + "' WHERE id_pr ='"+ mp.getId_cat()+"';";
		try {
			obj.Consulta(sql);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	
	public boolean EliminarProducto(int cod) {
		boolean f = false;
		Conexion con = new Conexion();
		String sql = "delete from tb_producto where id_pr= '"+cod+"'";
		try {
			con.Ejecutar(sql);
			f = true;
		}catch (Exception e) {
			f = false;
		}
		return f;
	}
	
	
	
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public int getId_pr() {
	    return id_pr;
	}

	public void setId_pr(int id_pr) {
	    this.id_pr = id_pr;
	}

	public int getId_cat() {
	    return id_cat;
	}

	public void setId_cat(int id_cat) {
	    this.id_cat = id_cat;
	}

	public String getDescripcion_pr() {
	    return descripcion_pr;
	}

	public void setDescripcion_pr(String descripcion_pr) {
	    this.descripcion_pr = descripcion_pr;
	}

	public double getPrecio_pr() {
	    return precio_pr;
	}

	public void setPrecio_pr(double precio_pr) {
	    this.precio_pr = precio_pr;
	}

	public int getCantidad_pr() {
	    return cantidad_pr;
	}

	public void setCantidad_pr(int cantidad_pr) {
	    this.cantidad_pr = cantidad_pr;
	}

	
	
	

}
