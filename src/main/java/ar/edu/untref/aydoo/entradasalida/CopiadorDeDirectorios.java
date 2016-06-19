package ar.edu.untref.aydoo.entradasalida;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.EnumSet;
import java.util.Objects;

public class CopiadorDeDirectorios {

	private CopiadorDeDirectorios() {
	}

	public static boolean copiarDirectorio(Path pathDesde, Path pathHasta) throws IOException {

		boolean copioCorrectamente = true;
		validar(pathDesde);
		Files.walkFileTree(pathDesde, EnumSet.of(FileVisitOption.FOLLOW_LINKS), Integer.MAX_VALUE,
				new CopiadorDeDirectoriosVisitor(pathDesde, pathHasta));
		return copioCorrectamente;
	}

	private static void validar(Path... paths) {
		for (Path path : paths) {
			Objects.requireNonNull(path);
			if (!Files.isDirectory(path)) {
				throw new IllegalArgumentException(String.format("%s no es un directorio", path.toString()));
			}
		}
	}
}