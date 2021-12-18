package gui.guiFreizeitbaeder;

import java.io.IOException;
import business.FreizeitBaederModel;
import javafx.stage.Stage;
import observer.Observer;

// Concrete Observer
public class FreizeitBaederControler implements Observer {

	private FreizeitBaederModel freizeitBaederModel;
	private FreizeitBaederView freizeitBaederView;

	public FreizeitBaederControler(Stage primaryStage) {
		this.freizeitBaederModel = freizeitBaederModel.getInstance();
		this.freizeitBaederView = new FreizeitBaederView(this, freizeitBaederModel, primaryStage);
		this.freizeitBaederModel.addObserver(this);
	}

	public void schreibeFreizeitbaederInDatei(String typ) {
		try {
			if ("csv".equals(typ)) {
				freizeitBaederModel.SchreibeFreizeitBaederInCsvDatei();
				freizeitBaederView.zeigeInformationsfensterAn("Wurde in csv Datei gespeichert");

			} else {
				freizeitBaederModel.SchreibeFreizeitBaederInTxtDatei();
				freizeitBaederView.zeigeInformationsfensterAn("Wurde in Txt Datei gespeichert");

			}
		} catch (IOException exc) {
			freizeitBaederView.zeigeInformationsfensterAn("IOException beim Speichern");
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
