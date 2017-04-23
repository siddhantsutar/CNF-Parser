import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

public class DefaultCNFParserView implements Observer, CNFParserView {

	private final Scanner in;
	private final String label1;
	private final String label2;
	
	public DefaultCNFParserView() {
		in = new Scanner(System.in);
		label1 = "Enter grammar file: ";
		label2 = "Enter word to parse: ";
	}
	
	public String getLabel1() {
		return label1;
	}
	
	public String getLabel2() {
		return label2;
	}
	
	public String prompt(String prompt) {
		try {
			System.out.printf(prompt);
			return in.nextLine();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void update(Observable o, Object arg) {
		System.out.println(arg);
	}
	
}