public class CountPrimes {
    // Sieve Of Eratosthenes is good space vs time trade off 
    public int countPrimes(int n) {
        // all true to start - for 0 to n-1
        boolean prime[] = new boolean[n];
        for (int i = 0; i < n; i++)
            prime[i] = true;
        
        // got from 2 to approximately sqrt(n)
        for(int p = 2; p*p <= n; p++)  {
            // if a number is marked prime 
            if(prime[p])  {
                // mark all multiples of that number as not prime
                // Note: we can start at p^2 as previous numbers are already marked
                // by previous primes
                for(int k = p*p; k <  n; k += p)
                    prime[k] = false;
            }
        }
         
        // count all the numbers that are prime
        int count = 0;
        for(int k = 2; k < n; k++)  {
            if (prime[k])
                count++;
        }
        return count;
    }
    
    // This is a rudimentary approach which is good for comparison   
    public int countPrimes2(int n) {
        int numPrimes = (n >= 3) ? 1 : 0;
        for (int k = 3; k < n; k++)
            if (isPrime(k))
                numPrimes++;

        return numPrimes;
    }

    public boolean isPrime(int k) {
        // can improve speed by implementing sqrt for integers
        int bound = findBound(k);
        for (int i = 2; i <= bound; i++)
            if (k % i == 0)
                return false;

        return true;
    }

    public int findBound(int num) {
        // this computes the ceiling of the square root of the given num
        int k = 2; 
        while (k*k < num)
            k++;

        return k;
    }
}