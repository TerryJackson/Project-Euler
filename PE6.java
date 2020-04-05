// https://projecteuler.net/problem=6
	
// Note that this problem can be solved
// with just basic algebra using the formulas:
// 1 + 2 + ... + n = n(n+1)/2
// 1^2 + 2^2 + ... + n^2 = n(n+1)(2n+1)/6

public class PE6 
{
	public static void main(String[] args) 
	{
		System.out.println(new PE6().solution());
	}

	
	public int solution()
	{
		int x = sumOfIntegers(100);
		int y = sumOfSquares(100);
		
		return x * x - y;
	}
	
	
	public int sumOfIntegers(int n)
	{
		int sum = 0;
		
		for (int i = 1; i <= n; i++)
			sum += i;
		
		return sum;
	}
	
	
	public int sumOfSquares(int n)
	{
		int sum = 0;
		
		for (int i = 1; i <= n; i++)
			sum += i * i;
		
		return sum;
	}
}