// https://projecteuler.net/problem=19

public class PE19 
{
	public static void main(String[] args) 
	{
		System.out.println(new PE19().solution());
	}
	
	
	public int solution()
	{
		return numberSundays();
	}
	
	
	public int numberSundays()
	{
		int day = 0;
		int month = 1;
		int year = 1900;
		int daysPassed = 0;
		int numberSundays = 0;
		
		while (year <= 2000)
		{
			//advance to the next day
			daysPassed++;
			
			if (month == 12 && day == 31)
			{
				day = 1;
				month = 1;
				year++;
			}
			else if ((month == 4 || month == 6 || month == 9 || month == 11) && day == 30)
			{
				day = 1;
				month++;
			}
			else if ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10) && day == 31)
			{
				day = 1;
				month++;
			}
			else if (month == 2 && isLeapYear(year) && day == 29)
			{
				day = 1;
				month++;
			}
			else if (month == 2 && !isLeapYear(year) && day == 28)
			{
				day = 1;
				month++;
			}
			else
			{
				day++;
			}
			
			// daysPassed % 7 == 6 means Sunday
			if (daysPassed % 7 == 6 && day == 1 && year >= 1901)
			{
				String s = day + " " + month + " " + year; 
				numberSundays++;
			}
		}
		
		return numberSundays;
	}

	
	public boolean isLeapYear(int year)
	{
		//is the year a century?
		if (year % 100 == 0)
		{
			if (year % 400 == 0)
				return true;
			else
				return false;
		}
		
		if (year % 4 == 0)
			return true;
		else 
			return false;
	}
}