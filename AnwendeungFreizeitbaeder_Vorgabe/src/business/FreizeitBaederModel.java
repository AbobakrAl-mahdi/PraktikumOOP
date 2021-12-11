package business;

import java.io.IOException;
import writers.ConcreteCsvWriterCreator;
import writers.ConcreteTxtWriterCreator;
import writers.WriterCreator;
import writers.WriterProduct;

public class FreizeitBaederModel {

	private Freizeitbad freizeitbad;

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
