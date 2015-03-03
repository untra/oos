
public abstract class Observer {

	protected Subject subject;
	
	public Observer(Subject s)
	{
		subject = s;
	}
	
	public void update()
	{
		return;
	}
}
