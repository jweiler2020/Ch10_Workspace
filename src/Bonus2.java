import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bonus2 extends JFrame
		implements ActionListener
{
	private JTextField input, result;

	public Bonus2()
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
		str = reverseTags(str);

		result.setText(str);
		input.selectAll();
	}

	public String reverseTags(String str)
	{
		StringBuilder newstr = new StringBuilder(0);
		int countOpen = 0;
		int countClose = 0;
		for(int i = 0; i < str.length(); i++)
		{
			if(str.substring(i).startsWith("<r>"))
				countOpen++;
			else if(str.substring(i).startsWith("</r>"))
			{
				if(countOpen == countClose+1)
					countClose++;
				else
					return "Error: Incorrect Format";
			}
		}
		if(countOpen != countClose)
			return "Error: Incorrect Format";

		for(int i = 0; i < str.length(); i++)
		{
			if (str.substring(i).startsWith("<r>"))
			{
				newstr.append(reverse(str.substring(i+3, str.indexOf("</r>", i+3))));
				i = str.indexOf("</r>", i+3)+4;
			}
			else
			{
				newstr.append(str.charAt(i));
			}
		}
		return newstr.toString();
	}

	public String reverse(String str)
	{
		StringBuilder newstr = new StringBuilder(str.length());
		for(int i = 0; i < str.length(); i++)
		{
			newstr.setCharAt(i, str.charAt(str.length()-i-1));
		}
		return newstr.toString();
	}

	public static void main(String[] args)
	{
		Bonus2 window = new Bonus2();
		window.setBounds(100, 100, 300, 100);
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		window.setVisible(true);
	}
}

