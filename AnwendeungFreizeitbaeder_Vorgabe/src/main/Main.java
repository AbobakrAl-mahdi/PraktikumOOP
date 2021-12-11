package main;

import gui.guiFreizeitbaeder.*;
import gui.guiSportstaetten.SportstaettenControl;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		// Freizeitbäder Fenster
		new FreizeitBaederControler(primaryStage);
		// Sportsätten Fenster
		Stage fensterSportstaetten = new Stage();
		new SportstaettenControl(fensterSportstaetten);
	}	
	
	public static void main(String[] args){
		launch(args);
	}
}
