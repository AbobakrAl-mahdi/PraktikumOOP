package gui.guiFreizeitbaeder;

import business.FreizeitbaederModel;
import javafx.stage.Stage;
import observer.Observer;

// Concrete Observer
public class FreizeitBaederControler implements Observer {

	private FreizeitbaederModel freizeitBaederModel;
	private FreizeitBaederView freizeitBaederView;

	public FreizeitBaederControler(Stage primaryStage) {
		this.freizeitBaederModel = freizeitBaederModel.getModel();
		this.freizeitBaederView = new FreizeitBaederView(this, freizeitBaederModel, primaryStage);
		this.freizeitBaederModel.addObserver(this);
	}

	public void schreibeFreizeitbaederInDatei(String typ) {
		try {
			if ("csv".equals(typ)) {
				freizeitBaederModel.schreibeFreizeitbaederInCsvDatei();
				freizeitBaederView.zeigeInformationsfensterAn("Wurde in csv Datei gespeichert");

			} else {
				freizeitBaederModel.schreibeFreizeitbaederInTxtDatei();
				freizeitBaederView.zeigeInformationsfensterAn("Wurde in Txt Datei gespeichert");

			}
		
		} catch (Exception exc) {
			freizeitBaederView.zeigeInformationsfensterAn("Unbekannter Fehler beim Speichern");
		}
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		this.freizeitBaederView.zeigeFreizeitbaederAn();
		
	}

}
