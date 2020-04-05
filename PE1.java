// https://projecteuler.net/problem=1
	
public class PE1 
{
	public static void main(String[] args) 
	{
		System.out.println(new PE1().solution());
	}
	
	
	public int solution()
	{
		return sumOfMultiples(1000);
	}
	
	
	public int sumOfMultiples(int N)
	{
		int sum = 0;
		
		// Note that only multiples strictly 
		// less than N are considered.
		for (int i = 3; i < N; i++)
		{
			if (i % 3 == 0 || i % 5 == 0)
				sum += i;
		}
		
		return sum;
	}
}