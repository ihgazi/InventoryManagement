import java.util.*;
import java.io.*;

public class Logger {
	private static String address = "history.txt";

	Logger() {
		File file = new File(address);
		try(PrintWriter pw = new PrintWriter(file)) {
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void readData() {
		int nextByte;
		try {
			BufferedReader br = new BufferedReader(new FileReader(address));
			while ((nextByte=br.read())!=-1) 
			System.out.print((char)nextByte);
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void writeData(int productID, int stock) {
		String s1 = "ProductID: "+(String.valueOf(productID))+" Stock puchased: "+(String.valueOf(stock));
		try(FileWriter fw = new FileWriter(address,true);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter out = new PrintWriter(bw)) {
			out.println(s1);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
