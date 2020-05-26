package model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import util.enums.Orientacion;

public class DronTest {
	
	@Test
	public void testMover() {
		Dron dron = Dron.builder().id(1)
				.posicion(new Posicion()).build();
		
		dron.mover("AAAAIAA");
		
		assertEquals(-2, dron.getPosicion().getValorY());
		assertEquals(4, dron.getPosicion().getValorX());
		assertEquals(Orientacion.ORIENTE, dron.getPosicion().getOrientacion());
		
	}

}
