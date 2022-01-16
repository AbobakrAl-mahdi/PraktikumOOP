package gui.guiSportstaetten;
   
import java.io.IOException;
import business.Freizeitbad;
import business.FreizeitbaederModel;
import business.SporthallenModel;
import business.businessSporthallen.Sporthalle;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.*;
import javafx.scene.control.Alert.AlertType;


public class SporttaettenView {
	
	// Hier ergaenzen
		private FreizeitbaederModel freiModel;
		private SporthallenModel sporthallenModel;
		private SportstaettenControl sportControl;
		
    	//---Anfang Attribute der grafischen Oberflaeche---
    	private Pane pane = new Pane();
    	
    	private Label lblAnzeigeFreizeitbaeder = new Label("Anzeige Freizeitbäder");
    	private TextArea txtAnzeigeFreizeitbaeder  = new TextArea();
    	private Button btnAnzeigeFreizeitbaeder = new Button("Anzeige");
    	
    	private Label lblAnzeigeSporthallen = new Label("Anzeige Sporthallen");
    	private TextArea txtAnzeigeSporthallen = new TextArea();
    	private Button btnAnzeigeSporthallen = new Button("CSV Import und Anzeige");
    	
    	//-------Ende Attribute der grafischen Oberflaeche-------
    
    	public SporttaettenView(SportstaettenControl sportControl, Stage fenstersportstaetten,
    			FreizeitbaederModel freiModel, SporthallenModel sporthallenModel){
    		Scene scene = new Scene(this.pane, 560, 340);
    		fenstersportstaetten.setScene(scene);
    		fenstersportstaetten.setTitle("Anzeige von Sportstätten");
    		fenstersportstaetten.setX(100);
    		fenstersportstaetten.show();
    		// Hier ergaenzen
    		this.freiModel = freiModel;
    		this.sporthallenModel = sporthallenModel;
    		this.sportControl = sportControl;


		this.initKomponenten();
		this.initListener();
    	}
    	private void initKomponenten(){
    		// Label
 		Font font = new Font("Arial", 20);
 		// Freizeitbaeder
 		// Label
       	lblAnzeigeFreizeitbaeder.setLayoutX(310);
    		lblAnzeigeFreizeitbaeder.setLayoutY(40);
    		lblAnzeigeFreizeitbaeder.setFont(font);
    		lblAnzeigeFreizeitbaeder.setStyle("-fx-font-weight: bold;"); 
       	pane.getChildren().add(lblAnzeigeFreizeitbaeder);    
        	// Textbereich	
        	txtAnzeigeFreizeitbaeder.setEditable(false);
     		txtAnzeigeFreizeitbaeder.setLayoutX(310);
    		txtAnzeigeFreizeitbaeder.setLayoutY(90);
     		txtAnzeigeFreizeitbaeder.setPrefWidth(220);
    		txtAnzeigeFreizeitbaeder.setPrefHeight(185);
       	pane.getChildren().add(txtAnzeigeFreizeitbaeder);        	
        	// Button
          	btnAnzeigeFreizeitbaeder.setLayoutX(310);
        	btnAnzeigeFreizeitbaeder.setLayoutY(290);
        	pane.getChildren().add(btnAnzeigeFreizeitbaeder); 
        	
        // Sporthallen
       	lblAnzeigeSporthallen.setLayoutX(20);
       		lblAnzeigeSporthallen.setLayoutY(40);
       		lblAnzeigeSporthallen.setFont(font);
       		lblAnzeigeSporthallen.setStyle("-fx-font-weight: bold;"); 
       	pane.getChildren().add(lblAnzeigeSporthallen);    
        	// Textbereich	
        	txtAnzeigeSporthallen.setEditable(false);
        	txtAnzeigeSporthallen.setLayoutX(20);
        	txtAnzeigeSporthallen.setLayoutY(90);
        	txtAnzeigeSporthallen.setPrefWidth(220);
     		txtAnzeigeSporthallen.setPrefHeight(185);
       	pane.getChildren().add(txtAnzeigeSporthallen);        	
        	// Button
          	btnAnzeigeSporthallen.setLayoutX(20);
          	btnAnzeigeSporthallen.setLayoutY(290);
        	pane.getChildren().add(btnAnzeigeSporthallen); 
   }
   
   private void initListener() {
	    btnAnzeigeFreizeitbaeder.setOnAction(
 			new EventHandler<ActionEvent>() {
	    		@Override
	        	public void handle(ActionEvent e) {
	            	zeigeFreizeitbaederAn();
	    		} 
   	    });
	    
	    btnAnzeigeSporthallen.setOnAction(
 			new EventHandler<ActionEvent>() {
	    		@Override
	        	public void handle(ActionEvent e) {
	    			try {
						sporthallenModel.leseSporthallenAusCsvDatei();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						zeigeInformationsfensterAn("IO Exception");
					} catch (PlausiException e1) {
						// TODO Auto-generated catch block
						zeigeInformationsfensterAn("PlusiException Exception");
					}
	            	zeigeSporthallenAn();
	    		} 
   	    });
    }
   
   // Freizeitbaeder
	public void zeigeFreizeitbaederAn() {
		if (freiModel.getFreizeitbaeder().size() > 0) {
			StringBuffer text = new StringBuffer();
			// Ergaenzen: for each – Schleife ueber ArrayList
			for (Freizeitbad fzb : freiModel.getFreizeitbaeder()){
				text.append(fzb.gibFreizeitbadZurueck(' ') + "\n");
			}
			this.txtAnzeigeFreizeitbaeder.setText(text.toString());
		} else {
			zeigeInformationsfensterAn("Bisher wurde kein Freizeitbad aufgenommen!");
		}
	}	
   
   // Sporthallen 
	public void zeigeSporthallenAn() {
		if (sporthallenModel.getSporthallen().size() > 0) {
			StringBuffer text = new StringBuffer();
			// Ergaenzen: for each – Schleife ueber ArrayList
			for (Sporthalle sh : sporthallenModel.getSporthallen()){
				text.append(sh.gibSporthalleZurueck(' ') + "\n");
			}
			this.txtAnzeigeSporthallen.setText(text.toString());
		} else {
			zeigeInformationsfensterAn("Bisher wurde kein Sporthallen aufgenommen!");
		}
	}	
   	
    private void zeigeInformationsfensterAn(String meldung){
	  	new MeldungsfensterAnzeiger(AlertType.INFORMATION,
           	"Information", meldung).zeigeMeldungsfensterAn();
    }	
    
}

