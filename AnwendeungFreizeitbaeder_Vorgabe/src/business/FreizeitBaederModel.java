package business;

import java.io.IOException;
import writers.ConcreteCsvWriterCreator;
import writers.ConcreteTxtWriterCreator;
import writers.WriterCreator;
import writers.WriterProduct;

public class FreizeitBaederModel {

	private Freizeitbad freizeitbad;
	private	static FreizeitBaederModel instance;
	
	private FreizeitBaederModel() {}

	

	public static FreizeitBaederModel getInstance() {
		// TODO Auto-generated method stub
		if(instance == null) {
			instance = new FreizeitBaederModel();
		}
		return instance;
		
	}



	public Freizeitbad getFreizeitbad() {
		return freizeitbad;
	}

	public void setFreizeitbad(Freizeitbad freizeitbad) {
		this.freizeitbad = freizeitbad;
	}

	public void SchreibeFreizeitBaederInVsvDatei() throws IOException {
		WriterCreator writerCreator = new ConcreteCsvWriterCreator();
		WriterProduct writer = writerCreator.factoryMethod();
		writer.fuegeInDateiHinzu(freizeitbad);
		writer.schliesseDatei();
	}
	
	public void SchreibeFreizeitBaederInTxtDatei() throws IOException {
		WriterCreator writerCreator = new ConcreteTxtWriterCreator();
		WriterProduct writer = writerCreator.factoryMethod();
		writer.fuegeInDateiHinzu(freizeitbad);
		writer.schliesseDatei();
	}

}
