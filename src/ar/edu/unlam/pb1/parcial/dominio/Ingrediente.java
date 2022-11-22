package ar.edu.unlam.pb1.parcial.dominio;

public class Ingrediente {
	
	private String nombre;
	private double precio;
	private Origen origen;
	
	public Ingrediente(String nombre, double precio, Origen origen) {
		this.nombre = nombre;
		this.precio = precio;
		this.origen = origen;
	}
	
	public String toString() {
		return nombre + "\n" + precio + "$" + "\n" + origen;
	}
	
	public Origen getOrigen() {
		return origen;
	}
	
	public double getPrecio() {
		return precio;
	}

}
