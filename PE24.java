// https://projecteuler.net/problem=24

import java.util.ArrayList;

public class PE24 
{
	public static void main(String[] args) 
	{
		System.out.println(new PE24().solution());
	}

	
	public long solution()
	{
		return lexicographic(10, 1000000);
	}
	

	public long lexicographic(int numberDigits, int position)
	{
		ArrayList<Integer> factorialExpansion = factorialExpansion(numberDigits - 1, position - 1);
		ArrayList<Integer> digitList = new ArrayList<Integer>();
		
		for (int i = 0; i < numberDigits; i++)
			digitList.add(i);
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		for (int i = 0; i < numberDigits; i++)
		{
			int index = factorialExpansion.get(i);
			result.add(digitList.get(index));
			digitList.remove(index);
		}
		
		// The integer array result now contains the digits of the answer.
		// Now need to convert the digits to an integer.
		long answer = 0;
		
		for (int i = 0; i < numberDigits; i++)
			answer += result.get(i) * (int)Math.pow(10, numberDigits - i - 1);
		
		return answer;
	}
	
	
	// Say factorialValue = 9 and expansionValue = 999,999. Since,
	// 999,999 = 2(9!) + 6(8!) + 6(7!) + 2(6!) + 5(5!) + 1(4!) + 2(3!) + 1(2!) + 1(1!) + 0(0!)
	// This method would return the list: 
	// {2, 6, 6, 2, 5, 1, 2, 1, 1, 0}
	public ArrayList<Integer> factorialExpansion(int factorialValue, int expansionValue)
	{
		ArrayList<Integer> digitList = new ArrayList<Integer>();
		
		int currentFactorial = factorial(factorialValue);
		int currentExpansion = expansionValue;
		
		for (int n = factorialValue; n >= 0; n--)
		{	
			int currentDigit = (int)(currentExpansion / currentFactorial);
			digitList.add(currentDigit);
			
			currentExpansion -= currentDigit * currentFactorial;
			
			if (n > 0)
				currentFactorial = (int)(currentFactorial / n);
		}
		
		return digitList;
	}
	

	public int factorial(int n)
	{
		if (n < 0)
			return -1;
		
		if (n == 0)
			return 1;
		
		int result = 1;
		
		for (int i = 2; i <= n; i++)
			result *= i;
		
		return result;
	}
	
}