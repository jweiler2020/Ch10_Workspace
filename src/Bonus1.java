import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bonus1 extends JFrame
		implements ActionListener
{
	private JTextField input, result;

	public Bonus1()
	{
		super("String test");
		Box box1 = Box.createVerticalBox();
		box1.add(new JLabel("Input:"));
		box1.add(Box.createVerticalStrut(10));
		box1.add(new JLabel("Result:"));

		input = new JTextField(20);
		input.setBackground(Color.WHITE);
		input.addActionListener(this);
		input.selectAll();

		result = new JTextField(20);
		result.setBackground(Color.WHITE);
		result.setEditable(false);

		Box box2 = Box.createVerticalBox();
		box2.add(input);
		box2.add(Box.createVerticalStrut(10));
		box2.add(result);

		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(box1);
		c.add(box2);
		input.requestFocus();
	}

	public void actionPerformed(ActionEvent e)
	{
		String str = input.getText();

		// ... insert code to process str or call a method here
		str = reverseCaps(str);

		result.setText(str);
		input.selectAll();
	}

	public String reverseCaps(String str)
	{
		char[] newstr = new char[str.length()];
		for (int i = 0; i < str.length(); i++)
		{
			char c = str.charAt(i);
			if(Character.isUpperCase(c))
				newstr[i] = Character.toLowerCase(c);
			else
				newstr[i] = Character.toUpperCase(c);
		}
		return new String(newstr);
	}

	public static void main(String[] args)
	{
		Bonus1 window = new Bonus1();
		window.setBounds(100, 100, 300, 100);
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		window.setVisible(true);
	}
}

