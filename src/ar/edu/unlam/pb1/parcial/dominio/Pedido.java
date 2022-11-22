package ar.edu.unlam.pb1.parcial.dominio;

public class Pedido {
	private String nombreDelCliente;
	private Ensalada[] ensaladas;
	
	public Pedido(String nombreCliente, Ensalada[] ensaladas) {
		nombreDelCliente = nombreCliente;
		this.ensaladas = ensaladas;
	}
	
	public boolean agregarNuevaEnsalada(Ensalada nueva) {
		/*
		 * Se incorpora una nueva ensalada a la lista del pedido actual
		 */for(int i = 0; i<ensaladas.length; i++) {
			 if(ensaladas[i] == null) {
				 ensaladas[i] = nueva;
				 return true;
			 }
		 }
		return false;
	}
	
	public double getImporte() {
		/*
		 * Calcula el importe en funci�n del precio de cada ingrediente
		 */
		double importe = 0;
		for(int i = 0; i<ensaladas.length; i++) {
			if(ensaladas[i] != null) {
			importe += ensaladas[i].getPrecio();
			}
		}
		return importe;
	}
}

