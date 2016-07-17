/* home.java
 * Clase singleton que brinda comunicacion 
 * entre la interfaz y la base de datos 
 */

public class Home {

	private Home instance = null;
	public Model model;
	public Gui gui;

	private Home() {}

	public static void main(String[] args) {
		this.model = new Model(getInstance());
		this.gui = new Gui(getInstance());
	}

	public static Home getInstance() {
		if(instance == null) instance = this;
		return instance;
	}
}