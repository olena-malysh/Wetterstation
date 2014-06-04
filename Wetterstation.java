import java.util.*;

public class Wetterstation extends Observable {
	private MessDaten daten = new MessDaten();
	private ArrayList<Observer> observerListe = new ArrayList<Observer>();
	
	@Override
	public void registerObserver(Observer b){
		observerListe.add(b);
	}
	
	@Override
	public void deleteObserver(Observer b){
		observerListe.remove(b);
	}
	
	@Override
	public void notifyObservers(){
		for (int i = 0; i < observerListe.size(); i++){
			Observer b = observerListe.get(i);
			b.update(daten);
		}
	}

	// wird aufgerufen, wenn neue Messwerte da sind
	public void messwerteGeaendert(){
		registerObserver();
	}

	
	// Simulation der Wetterdaten ...
	public void messungSimulieren(){
		Thread thread = new Thread(new Runnable(){
			public void run(){
				while (true){
					daten.messen();
					messwerteGeaendert();
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}
				}
			}
		});
		thread.start();
	}

	public Wetterstation(){
		messungSimulieren();
	}
}
