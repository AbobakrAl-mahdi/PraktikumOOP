package writers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import business.Freizeitbad;

public class ConcreteTxtWriterProduct extends WriterProduct {
	
	BufferedWriter aus;
	
	
	public ConcreteTxtWriterProduct() {
		try {
			this.aus= new BufferedWriter(new FileWriter("Freizeitbad.txt",true));
			aus.write("Daten des Freizeitbades\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void fuegeInDateiHinzu(Object object) throws IOException {
		Freizeitbad fr = (Freizeitbad)object;
		aus.write("Name des Freizeitbads: "+fr.getName()
				+"\n÷ffnungszeit des Freizeitbads: "+fr.getGeoeffnetVon()+" - "+fr.getGeoeffnetBis()
				+"\nBeckenl‰nge des Freizeitbads: "+fr.getBeckenlaenge()
				+"\nWassertemperatur des Freizeitbads: "+fr.getTemperatur()+"\n\n");
		
	}

	@Override
	public void schliesseDatei() throws IOException {
		aus.close();
	}

}
