// https://projecteuler.net/problem=4
	
import java.util.ArrayList;

public class PE4 
{
	public static void main(String[] args) 
	{
		System.out.println(new PE4().solution());
	}

	
	public int solution()
	{
		return maxPalindrome(3);
	}
	
	
	// Finds the maximum palindrome which is the product 
	// of two integers, each with d digits.
	public int maxPalindrome(int d)
	{
		int maxPalindrome = 0;
		
		int min = (int)Math.pow(10, d - 1);
		int max = (int)Math.pow(10, d);
		
		for (int i = min; i < max; i++)
			for (int j = min; j < max; j++)
			{
				int n = i * j;
				
				if (isPalindrome(n) && n > maxPalindrome)
					maxPalindrome = n;
			}
		
		return maxPalindrome;
	}
	
	
	public boolean isPalindrome(int n)
	{
		ArrayList<Integer> digits = getDigits(n);
		int d = digits.size();
		
		for (int i = 0; i < (int)(d / 2); i++)
		{
			if (digits.get(i) != digits.get(d - i - 1))
				return false;
		}
		
		return true;
	}
	
	
	public ArrayList<Integer> getDigits(int n)
	{
		ArrayList<Integer> digits = new ArrayList<Integer>();
		
		while (n >= 1)
		{
			digits.add(n % 10);
			n = (int)(n / 10);
		}
		
		return digits;
	}
}