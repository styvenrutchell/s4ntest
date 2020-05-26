
import java.util.List;

import model.Instruccion;
import model.Reporte;
import service.ServicioDomicilio;
import util.Constantes;
import util.GeneradorArchivo;
import util.LectorInstrucciones;

/**
 * Aplicación que lee instrucciones de movimiento de archivos .txt
 * ubicados en la carpeta /resources y genera en la misma carpeta
 * archivos con la ubicación en la que quedó cada dron después de hacer
 * el pedido
 * @author styven.rutchell
 *
 */
public class Restaurante {

	public static void main(String[] args) {
		List<Instruccion> instrucciones = LectorInstrucciones.transformarArchivo(Constantes.DIRECTORIO_ARCHIVOS);
		ServicioDomicilio servicioDomicilio = new ServicioDomicilio();

		List<Reporte> reporteFinal = servicioDomicilio.enviarPedido(instrucciones);
		reporteFinal.stream().forEach(r ->GeneradorArchivo.generarArchivo(r,Constantes.DIRECTORIO_ARCHIVOS));
		
	}

}
