public class DefaultCNFParserController implements CNFParserController {

	private final CNFParserModel model;
	private final CNFParserView view;
	
	public DefaultCNFParserController(CNFParserModel model, CNFParserView view) {
		this.model = model;
		this.view = view;
	}
	
	public void run() {
		String buffer;
		while ((buffer = view.prompt(view.getLabel1())) != null) {
			model.setFilename(buffer);
			while ((buffer = view.prompt(view.getLabel2())) != null) {
				model.setParseTree(buffer);
			}
		}
	}
	
}