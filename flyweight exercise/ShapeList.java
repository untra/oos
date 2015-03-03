import java.util.HashMap;

public class ShapeList 
{
	private static final HashMap<String, MyShape> shapes = new HashMap<String, MyShape>();

	private ShapeList() { } 
	public static MyShape getShape(String label) 
	{
		MyShape concreteShape = shapes.get(label);

		if (concreteShape == null) 
		{
			if (label.equals("R")) 
			{
				concreteShape = new MyRectangle(label);
			} else if (label.equals("O")) {
				concreteShape = new MyOval(label);
			}
			shapes.put(label, concreteShape);
		}
		return concreteShape;
	}
}
