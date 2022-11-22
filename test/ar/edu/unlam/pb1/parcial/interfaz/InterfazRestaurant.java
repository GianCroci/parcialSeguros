package ar.edu.unlam.pb1.parcial.interfaz;

import ar.edu.unlam.pb1.parcial.dominio.*;
import java.util.Scanner;

public class InterfazRestaurant {
	
	public static void main(String args[]) {
		
		Scanner teclado = new Scanner(System.in);
		
		
	
		final int CANTIDAD_MAXIMA_DE_INGREDIENTES = 50;
		final int CANTIDAD_MAXIMA_DE_ENSALADAS = 10;
		final int CANTIDAD_MAXIMA_DE_PEDIDOS_POR_DIA = 100;
		
		Ingrediente ingredientesDisponibles[] = new Ingrediente[CANTIDAD_MAXIMA_DE_INGREDIENTES];
		Ensalada ensaladaPreEstablecidas[] = new Ensalada[CANTIDAD_MAXIMA_DE_ENSALADAS];
		Pedido pedidos[] = new Pedido[CANTIDAD_MAXIMA_DE_PEDIDOS_POR_DIA];
		
		
		System.out.println("Bienvenido al Verde");
		System.out.println("Que desea realizar?");
		System.out.println();
		
		/*
		 * En esta secci�n del c�digo se debe generar la interacci�n con el usuario. Se pueden incorporar tantos 
		 * m�todos como considere necesario. M�nimamente se debe invocar a los siguientes m�todos:
		 * 
		 * 	incorporarNuevoIngrediente
		 * 	crearUnNuevaEnsalada
		 * 	crearUnNuevoPedido
		 */
		int opcion = 1;
		do {
             
			 incorporarNuevoIngrediente(teclado, ingredientesDisponibles, null);
			 System.out.println("Desea agregar otro? \n" + "1) SI \n" + "2) NO");
			 opcion = teclado.nextInt();
			 
		}while(opcion != 2);
		
		int loop = 1;
		
		do {
			crearUnaNuevaEnsalada(teclado, ingredientesDisponibles, ensaladaPreEstablecidas, null);
			System.out.println("Desea crear otra ensalada?");
			System.out.println("1) SI \n" + "2) NO");
			loop = teclado.nextInt();
		}while(loop != 2);
		
		crearUnNuevoPedido(teclado, ingredientesDisponibles, ensaladaPreEstablecidas, null, null);
		
		
		
		
	
		

		
		
		
			

		
		

	}

	private static void crearUnaNuevaEnsalada(Scanner teclado, Ingrediente[] ingredientesDisponibles,			
		Ensalada[] ensaladaPreEstablecidas, Ensalada nueva) {
		/* Se visualiza el listado de ingredientes disponibles y a partir de ah� se crean nuevos platos, los cuales 
			 * pueden ser solicitados por los clientes 
			 */ 
		String nombreDeEnsalada = "-";
		teclado.nextLine();
		System.out.println("Ingrese el nombre de la ensalada");		
		nombreDeEnsalada = teclado.nextLine();
		nueva = new Ensalada(nombreDeEnsalada);
		System.out.println("Lista de ingredientes");
			for(int i = 0; i<ingredientesDisponibles.length; i++) {
				if(ingredientesDisponibles[i] != null) {
					System.out.println((i+1) + ") " + ingredientesDisponibles[i] + "\n");
				}
			}			
			int continuar = 1;
			do {
				System.out.println("Elegir un ingrediente");
				int ingredienteSeleccionado = teclado.nextInt();
				Ingrediente ingrediente = ingredientesDisponibles[ingredienteSeleccionado-1];
				nueva.agregarIngrediente(ingrediente);
				System.out.println("Desea agregar otro ingrediente?" + "\n" + "1) SI" + "\n" + "2) NO");
				continuar = teclado.nextInt();
			}
			while(continuar != 2);
			
			for(int i = 0; i<ensaladaPreEstablecidas.length; i++) {
				if(ensaladaPreEstablecidas[i] == null) {
					ensaladaPreEstablecidas[i] = nueva;
					return;
				}
				
			}
			
			
	}

	private static void incorporarNuevoIngrediente(Scanner teclado, Ingrediente[] ingredientesDisponibles, Ingrediente actual) {
		/* Se crean nuevos ingredientes los cuales pueden ser utilizados en los platos */
		
		System.out.println("Ingrese el nombre del ingrediente");
		String nombre = teclado.next();
		System.out.println("Ingrese el precio del ingrediente");
		double precio = teclado.nextDouble();
		System.out.println("Ingrese el origen del ingrediente" + "\n");
		System.out.println(" 1) VEGETAL" + "\n" + " 2) ANIMAL" + "\n" + " 3) TACC" + "\n" + " 4) LECHE" + "\n" + " 5) HUEVO");
		int origenElegido = teclado.nextInt();
		Origen origen = Origen.values()[origenElegido-1];

		actual = new Ingrediente(nombre, precio, origen);
		for(int i = 0; i<50; i++) {
			if(ingredientesDisponibles[i] == null) {
				ingredientesDisponibles[i] = actual;
				return;
			}
		}
	}
		
	
	private static void crearUnNuevoPedido(Scanner teclado, Ingrediente[] ingredientesDisponibles,			
			Ensalada[] ensaladaPreEstablecidas, Ensalada pedidoEnsalada, Pedido pedido) {
		/*
		 * Se muestra el listado de ensaladas, y el cliente elige la ensalada deseada.
		 * Una vez elegida la ensalada el cliente puede incorporar nuevos ingredientes.
		 * Al finalizar informa el valor que debe abonar.
		 */
		System.out.println("LISTADO DE ENSALADAS");
		for(int i = 0; i<ensaladaPreEstablecidas.length; i++) {
			if(ensaladaPreEstablecidas[i]!=null) {
				System.out.println((i+1) + ") " + ensaladaPreEstablecidas[i]);
			}
		}
		System.out.println("****************************************");
		System.out.println("Elija la ensalada deseada");
		int j = teclado.nextInt();
		pedidoEnsalada = ensaladaPreEstablecidas[j-1];
		pedido.agregarNuevaEnsalada(pedidoEnsalada);
		
		int sumarIngrediente = 0;
		do {
			System.out.println("Desea agregarle algun ingrediente?");
			System.out.println("1) SI \n" + "2) NO");
			sumarIngrediente = teclado.nextInt();
			switch(sumarIngrediente) {
			case 1:
				System.out.println("Lista de ingredientes");
				for(int i = 0; i<ingredientesDisponibles.length; i++) {
					if(ingredientesDisponibles[i] != null) {
						System.out.println((i+1) + ") " + ingredientesDisponibles[i] + "\n");
					}
				}
				int continuar = 1;
				do {
					System.out.println("Elegir un ingrediente");
					int ingredienteSeleccionado = teclado.nextInt();
					Ingrediente ingrediente = ingredientesDisponibles[ingredienteSeleccionado-1];
					pedidoEnsalada.agregarIngrediente(ingrediente);
					System.out.println("Desea agregar otro ingrediente?" + "\n" + "1) SI" + "\n" + "2) NO");
					continuar = teclado.nextInt();
				}
				while(continuar != 2);
				System.out.println("Su pedido se realizo correctamente, debera pagar " + pedido.getImporte());
				break;
			case 2:
				System.out.println("Su pedido se realizo correctamente, debera pagar " + pedido.getImporte());
				break;
			}
		}
		while(sumarIngrediente != 2);
		
	}
}


