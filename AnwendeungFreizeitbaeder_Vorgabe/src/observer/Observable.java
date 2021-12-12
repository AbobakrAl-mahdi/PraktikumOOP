package observer;

public interface Observable {
	
	public void addObserver(Observer Obs);
	
	public void removeObserver(Observer obs) ;
	
	public void notifyObserver();
	
}
