# aydoo-2016-e5
Principales decisiones de diseño:

-La entrada de parámetros por consola se realiza mediante una clase ManejadorDeOpciones. La misma tiene la lógica y las validaciones correspondientes. Program al instanciar un objeto de dicha clase, obtiene los parámetros válidos o las excepciones correspondientes.

-La entrada de datos, de ahora en adelante Items, la realiza una clase que lee el archivo y genera una lista con los tipos de Items correspondiente. Clase GeneradorItemsDesdeArchivo.

-Los Items están modelados con una implementación del abstrac factory method. La clase ItemEntrada posee un método getTextoFormteado que recibe como parámetro un Formateador.

-La clase Formateador es la fábrica de Formateadores. En particular implementamos el FormateadorHTML. En este último, delegamos la lógica de la construcción del texto del Item en el formato esperado.

-La responsabilidad de la salida de los datos procesados está en la clase GeneradorSalida. La misma genera la plantilla a partir del template plantilla y posee dos métodos. Uno para sobreescribir el index.html y otro para devolver un literal a imprimir por pantalla.

