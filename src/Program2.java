import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Program2 extends JFrame
		implements ActionListener
{
	private JTextField input, result;

	public Program2()
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
		str = compute(str);

		result.setText(str);
		input.selectAll();
	}

	public String compute(String str)
	{
		double sum = 0;
		int count = 0;
		int i = 0;
		while(true)
		{
			count++;
			if(str.indexOf(", ", i) == -1)
			{
				sum += Double.parseDouble(str.substring(i, str.length()));
				break;
			}
			sum += Double.parseDouble(str.substring(i, str.indexOf(", ", i)));
			i = str.indexOf(", ", i) + 2;
		}
		return Double.toString(sum/count);
	}

	public static void main(String[] args)
	{
		Program2 window = new Program2();
		window.setBounds(100, 100, 300, 100);
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		window.setVisible(true);
	}
}

