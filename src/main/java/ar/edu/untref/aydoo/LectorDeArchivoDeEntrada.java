package ar.edu.untref.aydoo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LectorDeArchivoDeEntrada {

	private List<String> listaDeItems;
	private FileReader archivoEntrada;
	private Scanner scanner;

	public LectorDeArchivoDeEntrada(String archivoEntrada) throws FileNotFoundException {
		
		this.listaDeItems = new ArrayList<String>();
		this.archivoEntrada = new FileReader(archivoEntrada);
		this.scanner = new Scanner(this.archivoEntrada);
	}

	public List<String> getListaItemsEntrada() {
		
		String lineaLeida = "";
		while (scanner.hasNextLine()) {
			lineaLeida = scanner.nextLine();
			if (!lineaLeida.isEmpty()) {
				listaDeItems.add(lineaLeida);
			}
		}
		scanner.close();
		return listaDeItems;		
	}
	
}
