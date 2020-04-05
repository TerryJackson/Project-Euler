// https://projecteuler.net/problem=50

import java.util.ArrayList;

public class PE50 
{
	ArrayList<Integer> primeList;
	
	public static void main(String[] args) 
	{
		System.out.println(new PE50().solution());
	}

	
	public int solution()
	{
		return maxPrime(1000000);
	}

	
	public int maxPrime(int max)
	{
		populatePrimeList(max);
		int t = maxTerms(max);
		int terms = 0;
		int p = 0;
		
		while (terms <= t)
		{
			terms++;
			int n = sumConsecutivePrimes(terms, max);
			
			if (n != -1)
				p = n;
		}	
		
		return p;
	}
	
	
	// Returns the maximum k such that p1+...+pk <= max
	public int maxTerms(int max)
	{
		int terms = 0;
		int sum = 0;
		
		while (true)
		{
			sum += primeList.get(terms);
			
			if (sum > max)
				break;
			else
				terms++;
		}
		
		return terms;
	}
	
	
	// There may be more than one prime less than or equal to the 
	// max which is expressible by summing the number terms given.
	// This function returns only the smallest such prime.
	public int sumConsecutivePrimes(int terms, int max)
	{
		for (int i = 0; i <= primeList.size() - terms; i++)
		{
			// If the first term is 2 (which is when i = 0)
			// and we take an odd number of terms the sum
			// will always be even (and hence not prime).
			if (i == 0 && terms % 2 == 1)
				continue;
			
			// If the first term is an odd prime (i > 0) and we take 
			// an even number of terms the sum will always be even.
			if (i > 0 && terms % 2 == 0)
				break;
			
			int sum = 0;
			
			for (int j = 0; j < terms; j++)
				sum += primeList.get(i + j);
			
			if (sum > max)
				break;
			
			if (primeList.contains(sum))
				return sum;
		}
		
		return -1;
	}
	
	
	// Populate the PrimeList with all the primes 
	// less than or equal to the max parameter. 
	public void populatePrimeList(int max)
	{
		primeList = new ArrayList<Integer>();
		
		// Add the first prime to the list.
		primeList.add(2);
		
		for (int n = 3; n <= max; n++)
		{
			// We determine if n is prime.
			boolean isPrime = true;
			int m = (int)Math.sqrt(n);
			
			for (int i = 0; i < primeList.size(); i++)
			{
				if (primeList.get(i) > m)
					break;
				
				if (n % primeList.get(i) == 0)
				{
					isPrime = false;
					break;
				}
			}
			
			if (isPrime)
				primeList.add(n);
		}
	}
}