package util;

import java.util.List;

import org.junit.Test;

import model.Instruccion;

import static org.junit.Assert.assertEquals;

public class LectorInstruccionesTest {
	
 @Test
 public void testTransformadorArchivos() {
 
	 List<Instruccion> instrucciones = LectorInstrucciones.transformarArchivo(Constantes.DIRECTORIO_ARCHIVOS_TEST);
	 String ruta1 = instrucciones.get(0).getRutas().get(0);
	 assertEquals(2, instrucciones.size());
	 assertEquals("AAAAIAA",ruta1);
 }

}
