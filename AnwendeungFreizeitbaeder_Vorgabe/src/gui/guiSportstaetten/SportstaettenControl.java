package gui.guiSportstaetten;

import business.FreizeitBaederModel;
import javafx.stage.Stage;

public class SportstaettenControl {
	
	private FreizeitBaederModel freizeitBaederModel;
	private SporttaettenView sportstaettenView;
	
	public SportstaettenControl(Stage fensterSportstaetten) {
		this.freizeitBaederModel = freizeitBaederModel.getInstance();
		this.sportstaettenView = new SporttaettenView(this, freizeitBaederModel, fensterSportstaetten);
	}
	
}
