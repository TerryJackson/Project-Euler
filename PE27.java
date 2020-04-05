// https://projecteuler.net/problem=27

public class PE27 
{
	public static void main(String[] args) 
	{
		System.out.println(new PE27().solution());
	}

	
	public long solution()
	{
		return productCoef(1000, 1000);
	}
	
	
	public int productCoef(int maxA, int maxB)
	{
		int N = 0;
		int A = -maxA;
		int B = -maxB;
		
		for (int a = -maxA + 1; a < maxA; a++)
			for (int b = -maxB + 1; b < maxB; b++)
			{
				int p = 0;
				int n = -1;
				
				do {
					n++;
					p = n * n + a * n + b;
				} while(isPrime(p));
				
				if (n > N)
				{
					N = n;
					A = a;
					B = b;
				}
			}
		
		return A * B;
	}
	
	
	public boolean isPrime(int n)
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