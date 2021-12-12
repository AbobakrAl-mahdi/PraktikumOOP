package gui.guiSportstaetten;

import business.FreizeitBaederModel;
import javafx.stage.Stage;
import observer.Observer;

public class SportstaettenControl implements Observer {
	
	private FreizeitBaederModel freizeitBaederModel;
	private SporttaettenView sportstaettenView;
	
	public SportstaettenControl(Stage fensterSportstaetten) {
		this.freizeitBaederModel = freizeitBaederModel.getInstance();
		this.sportstaettenView = new SporttaettenView(this, freizeitBaederModel, fensterSportstaetten);
		this.freizeitBaederModel.addObserver(this);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		this.sportstaettenView.zeigeFreizeitbaederAn();
	}	
}
