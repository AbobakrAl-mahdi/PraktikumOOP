package business;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import observer.Observable;
import observer.Observer;
import writers.ConcreteCsvWriterCreator;
import writers.ConcreteTxtWriterCreator;
import writers.WriterCreator;
import writers.WriterProduct;
// Concrete Observable
public class FreizeitBaederModel implements Observable{

	private Freizeitbad freizeitbad;
	private	static FreizeitBaederModel instance;
	
	private List<Observer> observers = new ArrayList();
	
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



	@Override
	public void addObserver(Observer Obs) {
		// TODO Auto-generated method stub
		this.observers.add(Obs);
	}



	@Override
	public void removeObserver(Observer obs) {
		// TODO Auto-generated method stub
		this.observers.remove(obs);
		
	}



	@Override
	public void notifyObserver() {
		// TODO Auto-generated method stub
		for (Observer obs : observers) {
			obs.update();
		}
		
	}

}
