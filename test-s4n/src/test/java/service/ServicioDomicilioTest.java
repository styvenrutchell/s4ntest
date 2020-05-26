package service;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import model.Instruccion;
import model.Posicion;
import model.Reporte;

public class ServicioDomicilioTest {
	
	@Test
	public void enviarPedidoTest() {
		ServicioDomicilio servicioDomicilio = new ServicioDomicilio();
		List<Reporte> reporteFinal = servicioDomicilio.enviarPedido(getListaInstruccionesTest());
		Posicion posicion1 = reporteFinal.get(0).getPosicionesLista().get(0);
		Posicion posicion2 = reporteFinal.get(0).getPosicionesLista().get(1);
		Posicion posicion3 = reporteFinal.get(0).getPosicionesLista().get(2);
		assertEquals(1, reporteFinal.size());
		assertEquals(3, reporteFinal.get(0).getPosicionesLista().size());
		assertEquals("(-2, 4) direccion ORIENTE",posicion1.toString());
		assertEquals("(-1, 3) direccion SUR",posicion2.toString());
		assertEquals("(0, 0) direccion ORIENTE",posicion3.toString());
	}
	
	
	private List<Instruccion> getListaInstruccionesTest(){
		Instruccion instruccion = Instruccion.builder()
				.rutas(getRutasTest()).build();
		return Arrays.asList(instruccion);
		
	}

	private List<String> getRutasTest() {
		String ruta1 = "AAAAIAA";
		String ruta2 = "DDDAIAD";
		String ruta3 = "AAIADAD";		
		return Arrays.asList(ruta1,ruta2,ruta3);
	}

}
