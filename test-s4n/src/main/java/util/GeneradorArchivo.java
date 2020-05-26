package util;

import java.io.PrintWriter;

import model.Posicion;
import model.Reporte;

public class GeneradorArchivo {
	
	public static void generarArchivo(Reporte reporte, String rutaDirectorio) {
		String ubicacionArchivo = rutaDirectorio+ "\\out"+reporte.getDronId()+".txt";
		try {
			PrintWriter writer = new PrintWriter(ubicacionArchivo,"UTF-8");
			for(Posicion posicion : reporte.getPosicionesLista()) {
				writer.println(posicion.toString());
			}
			writer.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
