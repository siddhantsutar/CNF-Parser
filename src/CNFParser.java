public class CNFParser {
	
	public static void main(String[] args) {
		CNFParserModel model = new DefaultCNFParserModel();
		CNFParserView view = new DefaultCNFParserView();
		((DefaultCNFParserModel) model).addObserver((DefaultCNFParserView) view);
		CNFParserController controller = new DefaultCNFParserController(model, view);
		controller.run();
	}

}