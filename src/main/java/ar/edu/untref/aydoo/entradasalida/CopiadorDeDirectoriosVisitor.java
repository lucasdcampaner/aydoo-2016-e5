package ar.edu.untref.aydoo.entradasalida;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class CopiadorDeDirectoriosVisitor extends SimpleFileVisitor<Path> {

	private Path desdeElPath;
	private Path alPath;
	private StandardCopyOption opcionDeCopia;

	public CopiadorDeDirectoriosVisitor(Path desdeElPath, Path alPath, StandardCopyOption opcionDeCopia) {
		this.desdeElPath = desdeElPath;
		this.alPath = alPath;
		this.opcionDeCopia = opcionDeCopia;
	}

	public CopiadorDeDirectoriosVisitor(Path desdeElPath, Path alPath) {
		this(desdeElPath, alPath, StandardCopyOption.REPLACE_EXISTING);
	}

	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes atributos) throws IOException {

		Path targetPath = alPath.resolve(desdeElPath.relativize(dir));
		if (!Files.exists(targetPath)) {
			Files.createDirectory(targetPath);
		}
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFile(Path archivo, BasicFileAttributes atributos) throws IOException {

		Files.copy(archivo, alPath.resolve(desdeElPath.relativize(archivo)), opcionDeCopia);
		return FileVisitResult.CONTINUE;
	}
}
