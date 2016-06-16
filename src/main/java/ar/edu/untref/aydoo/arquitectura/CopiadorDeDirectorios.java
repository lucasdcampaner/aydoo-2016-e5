package ar.edu.untref.aydoo.arquitectura;

import java.io.IOException;
import java.nio.file.*;
import java.util.EnumSet;
import java.util.Objects;

public class CopiadorDeDirectorios {

	private CopiadorDeDirectorios() {}

	public static boolean copiarDirectorio(Path from, Path to) throws IOException {
		
		boolean copioCorrectamente = true;
		validar(from);
		Files.walkFileTree(from, EnumSet.of(FileVisitOption.FOLLOW_LINKS), Integer.MAX_VALUE, new CopiadorDeDirectoriosVisitor(from, to));
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