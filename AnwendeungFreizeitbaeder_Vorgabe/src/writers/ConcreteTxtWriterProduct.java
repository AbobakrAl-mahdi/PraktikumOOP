package writers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import business.Freizeitbad;

public class ConcreteTxtWriterProduct extends WriterProduct {
	
	BufferedWriter aus;
	
	
	public ConcreteTxtWriterProduct() {
		try {
			this.aus= new BufferedWriter(new FileWriter("Freizeitbad.txt",true));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void fuegeInDateiHinzu(Object object) throws IOException {
		
		for (Freizeitbad fzb : (ArrayList<Freizeitbad>) object) {
			aus.write("Daten des Freizeitbades\n");
			aus.write("Name des Freizeitbads: "+fzb.getName()
			+"\n÷ffnungszeit des Freizeitbads: "+fzb.getGeoeffnetVon()+" - "+fzb.getGeoeffnetBis()
			+"\nBeckenl‰nge des Freizeitbads: "+fzb.getBeckenlaenge()
			+"\nWassertemperatur des Freizeitbads: "+fzb.getTemperatur()+"\n\n");
		}
		
		
	}

	@Override
	public void schliesseDatei() throws IOException {
		aus.close();
	}

}
