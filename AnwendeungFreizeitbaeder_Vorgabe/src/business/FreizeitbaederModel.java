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

public class FreizeitbaederModel implements Observable{
	
	private List<Observer> observers = new ArrayList<Observer>();
    private ArrayList<Freizeitbad> freizeitbaeder = new ArrayList<Freizeitbad>();
    private static FreizeitbaederModel instanceModel;

    private FreizeitbaederModel() {    }

    public static FreizeitbaederModel getModel() {
    	if(instanceModel == null)
    		instanceModel = new FreizeitbaederModel();
    	
    	return instanceModel;
    }
    
	public ArrayList<Freizeitbad> getFreizeitbaeder() {
		return freizeitbaeder;
	}


	public void addFreizeitbad(Freizeitbad freizeitbad) {
		this.freizeitbaeder.add(freizeitbad);
	}


	public void schreibeFreizeitbaederInCsvDatei() {
		try {
			WriterCreator writerCreator= new ConcreteCsvWriterCreator();
			WriterProduct writerProduct= writerCreator.factoryMethod();
			
			for (Freizeitbad freizeitbad : this.freizeitbaeder) {
				writerProduct.fuegeInDateiHinzu(freizeitbad);
			}
			writerProduct.schliesseDatei();	
			
		} catch (IOException e) {
			System.out.print("IO Fehler");
		}
	}


	public void schreibeFreizeitbaederInTxtDatei() {
		try {
			WriterCreator writerCreator= new ConcreteTxtWriterCreator();
			WriterProduct writerProduct= writerCreator.factoryMethod();
			
			for (Freizeitbad freizeitbad : this.freizeitbaeder) {
				writerProduct.fuegeInDateiHinzu(freizeitbad);
			}
			writerProduct.schliesseDatei();	
		
		} catch (IOException e) {
			System.out.print("IO Fehler");
		}		
	}


	@Override
	public void addObserver(Observer obs) {
		observers.add(obs);
	}


	@Override
	public void removeObserver(Observer obs) {
		observers.remove(obs);
	}


	@Override
	public void notifyObserver() {
		for(Observer obs : observers) {
			obs.update();
		}
	}
    
}
