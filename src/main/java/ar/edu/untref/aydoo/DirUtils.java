package ar.edu.untref.aydoo;

import java.io.IOException;
import java.nio.file.*;
import java.util.EnumSet;
import java.util.Objects;

public class DirUtils {

	private DirUtils() {
	}

	public static void copy(Path from, Path to) throws IOException {
		validate(from);
		Files.walkFileTree(from, EnumSet.of(FileVisitOption.FOLLOW_LINKS), Integer.MAX_VALUE,
				new CopyDirVisitor(from, to));
	}

	private static void validate(Path... paths) {
		for (Path path : paths) {
			Objects.requireNonNull(path);
			if (!Files.isDirectory(path)) {
				throw new IllegalArgumentException(String.format("%s is not a directory", path.toString()));
			}
		}
	}

}