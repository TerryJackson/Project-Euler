// https://projecteuler.net/problem=52

import java.util.ArrayList;

public class PE52 
{
	public static void main(String[] args) 
	{
		System.out.println(new PE52().solution());
	}

	
	public int solution()
	{
		return sameDigits(6);
	}
	
	
	// Returns the smallest x such that i * x for i = 2,...,m 
	// all have the same digits 
	public int sameDigits(int m)
	{
		int x = 0;
		
		while(true)
		{
			if (x == Integer.MAX_VALUE)
				break;
			
			x++;
			ArrayList<Integer> L1 = getDigits(x);
			boolean allSame = false;
			
			for (int i = 2; i <= m; i++)
			{
				if (isPermutation(L1, getDigits(i * x)))
				{
					if (i == m)
						allSame = true;
				}
				else
					break;
			}
			
			if (allSame)
				break;
		}
		
		return x;
	}
	
	
	public ArrayList<Integer> getDigits(int n)
	{
		ArrayList<Integer> digits = new ArrayList<Integer>();
		
		while (n >= 1)
		{	
			digits.add(n % 10);
			n = (int)(n/10);
		}
		
		return digits;
	}
	
	
	public boolean isPermutation(ArrayList<Integer> L1, ArrayList<Integer> L2)
	{
		if (L1 == null || L2 == null)
			return false;
		
		if (L1.size() != L2.size())
			return false;
		
		int n = L1.size(); // ==L2.size()
		
		int[] perm = new int[n];
		
		// initializes all the elements of permutation to -1.
		for (int i = 0; i < n; i++)
			perm[i] = -1;
		
		for (int i = 0; i < n; i++)
		{
			// find L1[i] in L2
		    for (int j = 0; j < n; j++)
		    {
		    	if (L1.get(i) == L2.get(j) && perm[j] == -1)
		    	{
		    		perm[j] = i;
		    		break;
		    	}
		    	
		    }
		}
		
		for (int i = 0; i < n; i++)
		{
			if (perm[i] == -1)
				return false;
		}
		
		return true;
	}
}