import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

public class Ex_2 {
	public static void main(String[] args) {

		FileInputStream in = null;
		String out = null;
		byte chunk = null;

		// Copiem fitxers
		try {
			in = new FileInputStream("concatenate.txt");
			out = "extract";
			chunk = (byte)12;
			
			boolean salida = out.exists();
			if (salida) {
				in.close();
				throw new FileAlreadyExistsException("El fichero " + out.getName() + " ya existe");
			}
			FileOutputStream sortida = new FileOutputStream(out);

			separateFiles(in, sortida, chunk);

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

	public static void separateFiles(FileInputStream bigFile, String baseName, byte chunkSize) throws IOException {
		byte[] chunk = new byte[chunkSize];
		int c;
		int count = 0;

		while ((c = bigFile.read(chunk)) > 0){
			count ++;

			FileOutputStream out = new FileOutputStream(baseName+count+".txt");
			
		}
	}
}
