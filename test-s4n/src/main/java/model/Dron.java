package model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Dron {
	private long id;
	private Posicion posicion;

	/**
	 * �ste m�todo se encarga de actualizar la posici�n del dron
	 * de acuerdo a la secuencia de movimientos indicados:
	 * A: Avanza hac�a adelante
	 * I: Giro de 90 grados a la izquierda
	 * D: Giro de 90 grados a la derecha
	 * @param movimiento
	 */
	public void mover(String movimiento) {
		char[] movimientosSeparados = movimiento.toCharArray();
		for(int i = 0; i < movimiento.length(); i ++) {
			switch (String.valueOf(movimientosSeparados[i])) {
			case "A":
				switch(posicion.getOrientacion()) {
				case NORTE:
					posicion.subir();
					break;

				case SUR:
					posicion.bajar();
					break;
					
				case OCCIDENTE:
					posicion.desplazarDerecha();
					break;
					
				case ORIENTE:
					posicion.desplazarIzquierda();
					break;
				}
				break;

			default:
				posicion.cambiarOrientacion(String.valueOf(movimientosSeparados[i]));
				break;
			}
		}
	}

}
