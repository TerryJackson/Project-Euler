// https://projecteuler.net/problem=3

public class PE3 
{
	public static void main(String[] args) 
	{
		System.out.println(new PE3().solution());
	}

	
	public long solution()
	{
		long n = 600851475143L;
		return largestPrimeDivisor(n);
	}
	
	
	public Boolean isPrime(long n)
	{
		if (n <= 1)
			return false;
		
		for (long d = 2; d <= Math.sqrt(n); d++)
		{
			if (n % d == 0)
				return false;
		}
		
		return true;
	}
	
	
	public long largestPrimeDivisor(long n)
	{
		// Note n must be greater or equal to 2
		
		if (isPrime(n))
			return n;
		
		long largestPrimeDiv = 0;
		
		for (long d = 2; d < Math.sqrt(n); d++)
		{
			if (n % d == 0 && isPrime(d))
				largestPrimeDiv = d;
		}
		
		return largestPrimeDiv;
	}
}