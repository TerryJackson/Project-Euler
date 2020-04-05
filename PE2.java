// https://projecteuler.net/problem=2
	
public class PE2 
{
	public static void main(String[] args) 
	{
		System.out.println(new PE2().solution());
	}

	
	public int solution()
	{
		return sumEvenFib(4000000);
	}
	
	
	public int sumEvenFib(int N)
	{
		int x = 0;
		int y = 1;
		int sum = 0;
		
		while (y <= N)
		{
			if (y % 2 == 0)
				sum += y;
			
			int temp = y;
			y = x + y;
			x = temp;
		}
		
		return sum;
	}
}