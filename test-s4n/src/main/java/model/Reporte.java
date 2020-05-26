package model;

import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Reporte {
	private List<Posicion> posicionesLista;
	private long dronId;

}
