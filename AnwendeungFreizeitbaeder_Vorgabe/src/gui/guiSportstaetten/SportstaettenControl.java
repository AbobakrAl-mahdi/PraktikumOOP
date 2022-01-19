package gui.guiSportstaetten;

import java.io.IOException;
import ownUtil.PlausiException;
import business.FreizeitbaederModel;
import business.SporthallenModel;
import javafx.stage.Stage;
import observer.Observer;

public class SportstaettenControl implements Observer {
	
	private FreizeitbaederModel freizeitBaederModel;
	private SporttaettenView sportstaettenView;
	private SporthallenModel sporthallenModel;
	
	public SportstaettenControl(Stage fensterSportstaetten) {
		this.freizeitBaederModel = FreizeitbaederModel.getModel();
		this.sporthallenModel = SporthallenModel.getModel();
		this.sportstaettenView = new SporttaettenView(this,fensterSportstaetten, freizeitBaederModel, sporthallenModel );
		this.freizeitBaederModel.addObserver(this);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		this.sportstaettenView.zeigeFreizeitbaederAn();
	}	
	
	public void leseDateiausCsv() {
		try {
			sporthallenModel.leseSporthallenAusCsvDatei();
		} catch (IOException | PlausiException e) {
			sportstaettenView.zeigeInformationsfensterAn("Fehler beim lesen aus der CSV Datei");
		}
	}
}
