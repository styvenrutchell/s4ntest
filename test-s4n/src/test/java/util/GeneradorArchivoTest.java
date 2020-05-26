package util;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Test;

import model.Posicion;
import model.Reporte;
import util.enums.Orientacion;


public class GeneradorArchivoTest {
	private static final String NOMBRE_ARCHIVO_TEST =  "out3.txt";
	
	@Test
	public void testGenerarArchivo() {
		Reporte reporte1 = getTestReport(3);
		GeneradorArchivo.generarArchivo(reporte1,Constantes.DIRECTORIO_ARCHIVOS_TEST);
		File archivo = new File(Constantes.DIRECTORIO_ARCHIVOS_TEST+"\\"+NOMBRE_ARCHIVO_TEST);
		assertTrue(archivo.exists());
	}
	
	@After
	public void deleteFiles() {
		File archivo = new File(Constantes.DIRECTORIO_ARCHIVOS_TEST+"\\"+NOMBRE_ARCHIVO_TEST);
		archivo.delete();
	}
	
	private Reporte getTestReport(long dronId) {
		Posicion posicion1 = new Posicion(1, 2, Orientacion.NORTE);
		Posicion posicion2 = new Posicion(3, 4, Orientacion.SUR);
		List<Posicion> posiciones = Arrays.asList(posicion1,posicion2);
		return Reporte.builder().dronId(dronId).posicionesLista(posiciones).build();
	}

}
