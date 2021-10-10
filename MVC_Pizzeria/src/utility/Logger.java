package utility;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {
	
	public String makeLog(String stringa) {
		FileWriter fw = null;
		try {
			fw = new FileWriter("PizzeriaLog.txt", true);
			fw.write(stringa);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return stringa;
	}

	public void readLog() {
		FileReader fr = null;
		try {
			fr = new FileReader("PizzeriaLog.txt");
			int i = 0;
			while((i = fr.read()) != -1) {
				System.out.print((char)i);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
