package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Instruccion;


public class LectorInstrucciones {

	public static List<Instruccion> transformarArchivo(String directorio){
		File carpeta = new File(directorio);
		List<Instruccion> instrucciones = new ArrayList<>();
		for(File archivo : carpeta.listFiles()) {
			if(esArchivoValido(archivo)) {
				try {
					@SuppressWarnings("resource")
					Scanner entrada = new Scanner(archivo);
					List<String> rutas = new ArrayList<>();
					while(entrada.hasNextLine()) {
						String ruta = entrada.nextLine();
						rutas.add(ruta);
					}
					entrada.close();
					Instruccion instruccion = Instruccion.builder().rutas(rutas).build();
					instrucciones.add(instruccion);
				} catch (FileNotFoundException e) {
					System.err.println("Archivo no encontrado "+archivo.getName());
					e.printStackTrace();
				}
			}
		}

		return instrucciones;
	}
	
	private static boolean esArchivoValido(File archivo) {
		return archivo.isFile() && archivo.getName().toLowerCase().endsWith(".txt");
	}

}
