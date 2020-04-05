// https://projecteuler.net/problem=5
	
public class PE5 
{
	public static void main(String[] args) 
	{
		System.out.println(new PE5().solution());
	}

	
	public int solution()
	{
		return evenlyDivisible(20);
	}
	
	
	// Returns the smallest integer that is divisible
	// by all of the integers from 1 to n.
	public int evenlyDivisible(int n)
	{
		int x = 1;
		boolean answerFound = false;
		
		while(!answerFound)
		{
			answerFound = true;
			
			for (int i = 2; i <= n; i++)
			{
				if (x % i != 0)
				{
					answerFound = false;
					x++;
					break;
				}
			}
		}
		
		return x;
	}
}