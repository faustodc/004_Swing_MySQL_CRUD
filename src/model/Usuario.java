package model;

public class Usuario {

	private int id;
	private String nombre, password, estado;
	
	public Usuario(int id, String nombre, String password, String estado)
	{
		this.id = id;
		this.nombre = nombre;
		this.password = password;
		this.estado = estado;
	}// Cierra constructor

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getPassword() {
		return password;
	}

	public String getEstado() {
		return estado;
	}
	
}// Cierra clase
