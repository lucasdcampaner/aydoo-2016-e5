package ar.edu.untref.aydoo.constructores;

import ar.edu.untref.aydoo.dominio.Item;
import ar.edu.untref.aydoo.dominio.Seccion;

public class ConstructorDeSeccion extends ConstructorDeItem {

	private Seccion seccionActual = null;

	@Override
	public Item construir(String linea) {

		Item resultado = null;

		if (linea.startsWith("---")) {

			this.seccionActual = new Seccion("---");

			resultado = this.seccionActual;

		} else {

			resultado = this.construirSiguienteSiExiste(linea);

			if (this.seccionActual != null) {

				this.seccionActual.agregarElementoEnContenedor(resultado);
			}
		}

		return resultado;
	}

}
