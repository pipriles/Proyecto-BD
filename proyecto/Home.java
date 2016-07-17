/* Home.java
 * Clase singleton que brinda comunicacion 
 * entre la interfaz y la base de datos 
 */

public class Home {

	private static Home instance = null;
	public static Model model;
	public static Gui gui;

	private Home() {}

	public static void main(String[] args) {
		model = new Model(getInstance());
		gui = new Gui(getInstance());
		gui.setVisible(true);
	}

	public static Home getInstance() {
		if(instance == null) instance = new Home();
		return instance;
	}
}