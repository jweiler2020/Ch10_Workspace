public class BonusBonus
{
	public static final String[] ones = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
	public static final String[] tens = {"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
	public static final String[] teens = {"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};

	public static void main(String[] args)
	{
		int sumAnd = 0;
		int sum = 0;
		for(int i = 1; i <= 1000; i++)
		{
			sumAnd += length(spelling(i, true));
		}
		for(int i = 1; i <= 1000; i++)
		{
			sum += length(spelling(i, false));
		}
		System.out.format("The answer with British format is: %d\n", sumAnd);
		System.out.format("The answer without British format is: %d\n", sum);
	}

	public static String spelling(int i, boolean and)
	{
		StringBuilder newstr = new StringBuilder(0);
		if(i == 1000)
			return "onethousand";
		else
		{
			int ten = i % 100;
			if(ten != 0)
			{
				if (ten < 10)
					newstr.append(ones[ten - 1]);
				else if (ten == 10)
					newstr.append("ten");
				else if (ten < 20)
					newstr.append(teens[ten % 10 - 1]);
				else
					if (ten % 10 == 0)
						newstr.append(tens[ten / 10 - 2]);
					else
						newstr.append(ones[ten % 10 - 1] + tens[ten / 10 - 2]);
			}

			if(newstr.length() != 0 && i/100 != 0 && and)
				newstr.append("and");

			int hundred = i / 100;
			if(hundred != 0)
			{
				newstr.append(ones[hundred-1] + "hundred");
			}
		}

		return newstr.toString();
	}

	public static int length(String str)
	{
		int sum = 0;
		for(int i = 0; i < str.length(); i++)
		{
			if(Character.isAlphabetic(str.charAt(i)))
				sum++;
		}

		return sum;
	}
}
