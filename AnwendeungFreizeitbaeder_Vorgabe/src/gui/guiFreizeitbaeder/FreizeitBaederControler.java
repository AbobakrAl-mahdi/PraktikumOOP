package gui.guiFreizeitbaeder;

import java.io.IOException;
import business.FreizeitBaederModel;
import javafx.stage.Stage;

public class FreizeitBaederControler {

	private FreizeitBaederModel freizeitBaederModel;
	private FreizeitBaederView freizeitBaederView;

	public FreizeitBaederControler(Stage primaryStage) {
		this.freizeitBaederModel = freizeitBaederModel.getInstance();
		this.freizeitBaederView = new FreizeitBaederView(this, freizeitBaederModel, primaryStage);
	}

	public void schreibeFreizeitbaederInDatei(String typ) {
		try {
			if ("csv".equals(typ)) {
				freizeitBaederModel.SchreibeFreizeitBaederInVsvDatei();
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

}
