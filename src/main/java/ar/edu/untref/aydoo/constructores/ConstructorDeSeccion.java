package ar.edu.untref.aydoo.constructores;

import ar.edu.untref.aydoo.dominio.Item;
import ar.edu.untref.aydoo.dominio.Seccion;

public class ConstructorDeSeccion extends ConstructorDeItem {

	private Seccion seccionActual = null;

	@Override
	public Item construir(String texto) {

		Item resultado = null;

		if (texto.startsWith("---")) {

			this.seccionActual = new Seccion("---");
			resultado = this.seccionActual;
			this.detenerConstruccion();
		} else {

			resultado = this.continuarConstruccion(texto);
			if (this.seccionActual != null && resultado != null) {

				this.seccionActual.agregarElementoEnContenedor(resultado);
				/*
				 * /Este item se agrega a la seccion por lo tanto no debe ser
				 * agregado a la lista ppal de items.
				 */
				resultado = null;
			}
		}

		return resultado;
	}

}
