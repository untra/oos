import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame implements ActionListener
{
	private static final int WIDTH = 640;
	private static final int HEIGHT = 480;

	private static final String shapes[] = { "R", "O" };
	private static final Color colors[] = { Color.red, Color.green, Color.blue };
	private static final boolean fill[] = { true, false };
	private static final String font[] = { "Arial", "Courier" };
	private	final JPanel panel = new JPanel();

	public Main() 
	{
		Container contentPane = getContentPane();

		JButton startButton = new JButton("Draw Shapes");

		contentPane.add(panel, BorderLayout.CENTER);
		contentPane.add(startButton, BorderLayout.SOUTH);
		setSize(WIDTH, WIDTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		startButton.addActionListener(this);
	}

	public void actionPerformed(ActionEvent event) 
	{
		Graphics g = panel.getGraphics();
		for (int i = 0; i < 100; ++i) 
		{
			MyShape shape = ShapeList.getShape(getRandomShape());
			shape.draw(g, getRandomX(), getRandomY(), getRandomWidth(),
					getRandomHeight(), getRandomColor(),
					getRandomFill(), getRandomFont());
		}
	}
	private String getRandomShape() 
	{
		return shapes[(int) (Math.random() * shapes.length)];
	}

	private int getRandomX() 
	{
		return (int) (Math.random() * WIDTH);
	}

	private int getRandomY() 
	{
		return (int) (Math.random() * HEIGHT);
	}

	private int getRandomWidth() 
	{
		return (int) (Math.random() * (WIDTH / 7));
	}

	private int getRandomHeight() 
	{
		return (int) (Math.random() * (HEIGHT / 7));
	}

	private Color getRandomColor() 
	{
		return colors[(int) (Math.random() * colors.length)];
	}

	private boolean getRandomFill() 
	{
		return fill[(int) (Math.random() * fill.length)];
	}

	private String getRandomFont() 
	{
		return font[(int) (Math.random() * font.length)];
	}

	public static void main(String[] args) 
	{
		Main main = new Main();
	}
}
