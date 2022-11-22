package ar.edu.unlam.pb1.parcial.dominio;


public class Ensalada {

	private String nombreDeLaEnsalada;
	private Ingrediente ingredientes[] ;
	
	public Ensalada(String nombre) {
		nombreDeLaEnsalada = nombre;
		ingredientes = new Ingrediente[6]; 
	}
	
	public boolean agregarIngrediente(Ingrediente nuevo) {
		/*
		 * Incorpora un nuevo ingrediente a la ensalada
		 */for(int i = 0; i<ingredientes.length; i++) {
			 if(ingredientes[i]==null) {
				 ingredientes[i] = nuevo;
				 return true;
			 }
		 }
		return false;
	}
	
	
	public boolean esAptoCeliaco() {
		for(int i = 0; i<ingredientes.length; i++) {
			if(ingredientes[i].getOrigen() != Origen.TACC) {
				return true;
			}
		}
		return false;
	}
	
	public boolean esAptoVegetariano() {
		for(int i = 0; i<ingredientes.length; i++) {
			if(ingredientes[i].getOrigen() != Origen.ANIMAL) {
				return true;
			}
		}
		return false;
	}
	
	public boolean esAptoVegano() {
		for(int i = 0; i<ingredientes.length; i++) {
			if(ingredientes[i].getOrigen() == Origen.VEGETAL) {
				return true;
			}
		}
		return false;
	}

	public String toString() {
		/*
		 * Devuelve un String con el nombre de la ensalada y el detalle de los ingredientes que la componen
		 */
		String detalle = "";
		detalle = nombreDeLaEnsalada + "\n" + "INGREDIENTES: \n";
		for(int i = 0; i<ingredientes.length; i++) {
			if(ingredientes[i]!=null) {
				detalle += ingredientes[i] + "\n";
			}
		}
		return detalle;
	}
	public double getPrecio() {
		double precioEnsalada = 0.0;
		for(int i = 0; i<ingredientes.length; i++) {
			if(ingredientes[i] != null) {
				precioEnsalada += ingredientes[i].getPrecio();
			}
		}return precioEnsalada;
		
	}

}
