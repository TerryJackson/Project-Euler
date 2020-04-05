// https://projecteuler.net/problem=10
	
// The sum must be a of type "long" here. If you use "int" it wraps on 
// itself and you get the wrong answer of 1179908154

public class PE10 
{
	public static void main(String[] args) 
	{
		System.out.println(new PE10().solution());
	}

	
	public long solution()
	{
		return primeSum(2000000);
	}
	
	
	// Returns the sum of the primes below max
	public long primeSum(long max)
	{
		long sum = 0;
		
		for (int n = 2; n < max; n++)
		{
			if (isPrime(n))
				sum += n;
		}
		
		return sum;
	}
	
	
	public boolean isPrime(long n)
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
}