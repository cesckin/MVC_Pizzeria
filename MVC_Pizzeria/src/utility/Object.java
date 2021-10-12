package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Object {

	public void salvaObject(Object oggetto) {
		
		// Inserimento comande
					FileOutputStream fos;
					ObjectOutputStream oos;

					try {
						fos = new FileOutputStream("Comande.dat");
						oos = new ObjectOutputStream(fos);
						oos.writeObject(oggetto);
						oos.flush();
						fos.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
		
	}
}
