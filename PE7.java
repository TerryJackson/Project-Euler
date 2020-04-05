// https://projecteuler.net/problem=7

public class PE7 
{
	public static void main(String[] args) 
	{
		System.out.println(new PE7().solution());
	}

	
	public int solution()
	{
		return primeSequence(10001);
	}
	
	
	// Returns the prime corresponding to the given index.
	public int primeSequence(int index)
	{
		int n = 2;
		int p = 2;
		int i = 1;
		
		while (i < index)
		{
			n++;
			
			if (isPrime(n))
			{
				p = n;
				i++;
			}
		}
		
		return p;
	}
	
	
	public Boolean isPrime(int n)
	{
		if (n <= 1)
			return false;
		
		for (int d = 2; d <= Math.sqrt(n); d++)
		{
			if (n % d == 0)
				return false;
		}
		
		return true;
	}
}