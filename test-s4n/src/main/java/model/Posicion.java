package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import util.enums.Orientacion;

@Getter
@Setter
@AllArgsConstructor
public class Posicion {
	private int valorX;
	private int valorY;
	private Orientacion orientacion;
	
	public Posicion() {
		valorX = 0;
		valorY = 0;
		orientacion = Orientacion.NORTE;
	}
	
	
	protected void subir() {
		valorX = valorX+1;
	}
	
	protected void bajar() {
		valorX = valorX-1;
	}
	
	protected void desplazarIzquierda() {
		valorY = valorY -1;
	}
	
	protected void desplazarDerecha() {
		valorY = valorY +1;
	}
	
	/**
	 * Método que cambia la orientación de acuerdo a su orientación actual
	 * si la dirección es "I" significa que hace un giro a la izquierda
	 * y e acuerdo a su orientación actual la cambiará a la que le corresponde,
	 * si la dirección es "D" entonces hace un giro de 90 grados a la derecha.
	 * @param direccion
	 */
	protected void cambiarOrientacion(String direccion) {
		switch (direccion) {
		case "I":
			switch (orientacion) {
			case NORTE:
				orientacion = Orientacion.ORIENTE;
				break;

			case SUR:
				orientacion = Orientacion.OCCIDENTE;
				break;
				
			case OCCIDENTE:
				orientacion = Orientacion.NORTE;
				break;
			case ORIENTE:
				orientacion = Orientacion.SUR;
				break;
			}
			
			break;

		case "D":
			switch (orientacion) {
			case NORTE:
				orientacion = Orientacion.OCCIDENTE;
				break;

			case SUR:
				orientacion = Orientacion.ORIENTE;
				break;
				
			case OCCIDENTE:
				orientacion = Orientacion.SUR;
				break;
				
			case ORIENTE:
				orientacion = Orientacion.NORTE;
				break;
			}
			
			break;
		
		default:
			break;
		}
	}

	@Override
	public String toString() {
		return "("+valorY+", "+valorX + ") direccion "+orientacion;
	}
	

}
