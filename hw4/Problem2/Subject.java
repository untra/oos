import java.util.LinkedList;

public abstract class Subject {

	private LinkedList<Observer> observers = new LinkedList<Observer>();
	
	public void attach(Observer o)
	{
		observers.add(o);
	}
	public void detach(Observer o)
	{
		observers.remove(o);
	}
	public void announce()
	{
		for(Observer o : observers)
		{
			o.update();
		}
	}	
}
