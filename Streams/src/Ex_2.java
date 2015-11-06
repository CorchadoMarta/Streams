import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

public class Ex_2 {
	public static void main(String[] args) {

		FileInputStream in = null;
		File out = null;

		// Copiem fitxers
		try {
			in = new FileInputStream("exemple3.txt");
			out = new File("concatenat1e.txt");

			boolean salida = out.exists();
			if (salida) {
				in.close();
				throw new FileAlreadyExistsException("El fichero " + out.getName() + " ya existe");
			}
			FileOutputStream sortida = new FileOutputStream(out);

			copyFiles(in, sortida);

			if (sortida != null) {
				sortida.close();
			}
		} catch (FileAlreadyExistsException a) {
			System.out.println(a.toString());
		} catch (FileNotFoundException o) {
			System.out.println(o.toString());
		} catch (IOException e) {
			System.out.println(e.toString());
		}

	}

	public static void separateFiles(FileInputStream bigFile, FileOutputStream baseName, byte chunkSize) {
		
		
	}
}
