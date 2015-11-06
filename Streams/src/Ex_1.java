import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

public class Ex_1 {

	public static void main(String[] args) {

		FileInputStream in1 = null;
		FileInputStream in2 = null;
		FileInputStream in3 = null;
		File out = null;

		// Copiem fitxers
		try {
			in1 = new FileInputStream("exem1le1.txt");
			in2 = new FileInputStream("exemple2.txt");
			in3 = new FileInputStream("exemple3.txt");
			out = new File("concatenat1e.txt");

			boolean salida = out.exists();
			if (salida){
				in1.close();
				in2.close();
				in3.close();
				throw new FileAlreadyExistsException("El fichero " + out.getName() + " ya existe");				
			}
			FileOutputStream sortida = new FileOutputStream(out);

			copyFiles(in1, sortida);
			copyFiles(in2, sortida);
			copyFiles(in3, sortida);

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

	public static void copyFiles(FileInputStream fileRead, FileOutputStream fileWrite)
			throws FileNotFoundException, IOException {

		try {
			int c;

			while ((c = fileRead.read()) != -1) {
				fileWrite.write(c);
			}
		} catch (FileNotFoundException u) {
			System.out.println("Estas en el metodo");
		} finally {
			if (fileRead != null) {
				fileRead.close();
			}
		}
	}

}
