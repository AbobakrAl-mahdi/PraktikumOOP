package writers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import business.Freizeitbad;

public class ConcreteCsvWriterProduct extends WriterProduct {
	
	BufferedWriter aus;
	
	public ConcreteCsvWriterProduct() {
		try {
			this.aus= new BufferedWriter(new FileWriter("Freizeitbad.csv",true));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void fuegeInDateiHinzu(Object object) throws IOException {
		//Freizeitbad fr = (Freizeitbad)object;
		for (Freizeitbad fzb : (ArrayList<Freizeitbad>) object) {
			aus.write(fzb.gibFreizeitbadZurueck(';')+"\n");
		}
		//aus.write(fzb.gibFreizeitbadZurueck(';')+"\n");
		
	}

	@Override
	public void schliesseDatei() throws IOException {
		aus.close();
	}

}
