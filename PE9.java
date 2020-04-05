// https://projecteuler.net/problem=9

// Note that we can work this problem out by hand.
// a = m^2 - n^2, b = 2mn, c = m^2 + n^2 where n < m.
// (It may be that a > b but that does not matter)
// a + b + c = 100 implies m(m+n) = 500
// so n = (500 - m^2)/m
// Combining this with n < m implies 16 <= m
// Since m divides 500, must have m = 20 and n = 5
// so a = 375, b = 200, c= 425 and abc = 31875000

public class PE9 
{
	public static void main(String[] args) 
	{
		System.out.println(new PE9().solution());
	}

	
	public int solution()
	{
		return PythagoreanSum(1000);
	}
	
	
	public int PythagoreanSum(int n)
	{
		for (int c = (int)(n / 3); c < n; c++)
			for (int b = (int)((n - c) / 2); b < c; b++)
			{
				int a = n - b - c;
				
				if (a < 0)
					continue;
				
				if (a * a + b * b == c * c)
					return a * b * c;
			}
			
		// Case for which no sum equals n.
		return -1;
	}
}