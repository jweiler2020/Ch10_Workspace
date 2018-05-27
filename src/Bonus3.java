import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bonus3 extends JFrame
		implements ActionListener
{
	private JTextField input, result;

	public Bonus3()
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
		str = correct(str);

		result.setText(str);
		input.selectAll();
	}

	public String correct(String str)
	{
		StringBuilder newstr = new StringBuilder(0);
		boolean cap = true;
		for(int i = 0; i < str.length(); i++)
		{
			if(Character.toLowerCase(str.charAt(i)) == 'i')
				newstr.append('I');
			else if(str.charAt(i) == '.')
			{
				cap = true;
				newstr.append('.');
			}
			else
			{
				if (cap && Character.isAlphabetic(str.charAt(i)))
				{
					newstr.append(Character.toUpperCase(str.charAt(i)));
					cap = false;
				}
				else
					newstr.append(Character.toLowerCase(str.charAt(i)));
			}

		}

		return newstr.toString();
	}

	public static void main(String[] args)
	{
		Bonus3 window = new Bonus3();
		window.setBounds(100, 100, 300, 100);
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		window.setVisible(true);
	}
}

