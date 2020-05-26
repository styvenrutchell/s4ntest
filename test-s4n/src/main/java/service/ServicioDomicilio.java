package service;

import java.util.ArrayList;
import java.util.List;

import model.Dron;
import model.Instruccion;
import model.Posicion;
import model.Reporte;

/**
 * Esta clase se encargará de gestionar todos los pedidos
 * que debe realizar cada dron
 * @author styven.rutchell
 *
 */
public class ServicioDomicilio {
	
	/**
	 * Método que recibe una lista de instrucciones
	 * donde cada instrucción contiene una lista de 
	 * rutas que debe recorrer un dron
	 * @param instrucciones
	 * @return una lista de Reportes por cada dron
	 * el cual tiene incluido el id del dron y una lista
	 * de posiciones donde quedó el dron después de cada pedido.
	 */
	public List<Reporte> enviarPedido(List<Instruccion> instrucciones){
		List<Reporte> reportes = new ArrayList<>();
	
		long contadorDron = 1;
		for(Instruccion instruccion : instrucciones) {
			List<Posicion>posicionesDron = new ArrayList<>();
			Dron dron = Dron.builder()
					.id(contadorDron)
					.posicion(new Posicion())
					.build();

			for (String ruta : instruccion.getRutas()) {
				dron.mover(ruta);
				Posicion posicion = new Posicion(dron.getPosicion().getValorX(), dron.getPosicion().getValorY(),
						dron.getPosicion().getOrientacion());
				posicionesDron.add(posicion);
			}
			Reporte reporte = Reporte.builder()
					.posicionesLista(posicionesDron)
					.dronId(dron.getId())
					.build();
			reportes.add(reporte);
			contadorDron++;
		}
		
		return reportes;
	}

}
