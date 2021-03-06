package Amz;

public class NthPrime {
	
	public static int solution(int n)
	{
		if (n <= 0 ) return 0;
		
		int num = 1;
		
		while(n>0)
		{
			num++;
			int i;
			for (i=2; i<=num; i++)
			{
				if (num%i==0) break;
			}
			if (i == num) n--;
		}
		
		return num;
	}
	
	public static int countPrime(int n)
	{
		if (n < 2) return 0;
		
		int num = 2;
		int count = 0;
		while(num < n)
		{
			int i;
			for (i=2; i<=num; i++)
			{
				if (num % i == 0)
				{
					break;
				}
			}
			if (i == num) count++;
			num++;
		}
		
		return count;
	}
	
	public static int countPrimes(int n) {
		if (n <= 2)
			return 0;
	 
		// init an array to track prime numbers
		boolean[] primes = new boolean[n];
		for (int i = 2; i < n; i++)
			primes[i] = true;
	 
		for (int i = 2; i <= Math.sqrt(n - 1); i++) {
		// or for (int i = 2; i <= n-1; i++) {
			if (primes[i]) {
				for (int j = i + i; j < n; j += i)
					primes[j] = false;
			}
		}
	 
		int count = 0;
		for (int i = 2; i < n; i++) {
			if (primes[i])
				count++;
		}
	 
		return count;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(countPrime(499979));
		//System.out.println(countPrimes(499979));
		
		int x = 3;
		System.out.println(8>>1);
		
	}

}
