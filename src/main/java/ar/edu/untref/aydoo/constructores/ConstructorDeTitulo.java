package ar.edu.untref.aydoo.constructores;

import ar.edu.untref.aydoo.dominio.Item;
import ar.edu.untref.aydoo.dominio.Titulo;

public class ConstructorDeTitulo extends ConstructorDeItem {

	@Override
	public Item construir(String linea) {
		
		Item resultado = null;
		
		if (linea.startsWith("#")) {
			
			resultado = new Titulo(linea.substring(2, linea.length()));
			
		} else {
			
			resultado = this.construirSiguienteSiExiste(linea);
		}
		
		return resultado;
	}

}
