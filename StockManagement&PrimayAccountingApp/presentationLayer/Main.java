package presentationLayer;

public class Main {

	public static void main(String[] args) {

		InitPageView view = new InitPageView();
		InitPageController controller = new InitPageController(view);

		view.setVisible(true);
	}
}
