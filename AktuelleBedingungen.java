
public class AktuelleBedingungen implements Observer{
	public AktuelleBedingungen(){}
	@Override
	public void update(MessDaten daten) {
		
		System.out.println("aktuell: " 
				+ daten.getTemperatur() + " C " 
				+ daten.getFeuchtigkeit() + "% "
				+ daten.getDruck() + " hPa ");
	}
}
