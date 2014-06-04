import java.util.Observable;
public abstract class Observable { // Observable
	public void registerObserver(Observer b); // register
	public void deleteObserver(Observer b); // delete
	public void notifyObservers(); // notify
}
