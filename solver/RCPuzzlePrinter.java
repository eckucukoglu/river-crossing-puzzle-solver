import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class RCPuzzlePrinter {
	private String filepath;
	
	public RCPuzzlePrinter(String filepath) {
		this.filepath = filepath;
	}
	
	public void printToFile(String text, boolean append) throws IOException {
		FileWriter write = new FileWriter(filepath, append);
		PrintWriter lineprinter = new PrintWriter(write);
		
		lineprinter.printf("%s", text);
		lineprinter.close();
	}
}
