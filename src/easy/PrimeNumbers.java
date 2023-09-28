package easy;

public class PrimeNumbers {
    public int diagonalPrime(int[][] nums) {
        int maxPrime=0;
        for(int i=0; i<nums.length; i++){
            final int x=nums[i][i], y=nums[i][nums.length-1-i];
            if(isPrime(x)) maxPrime= Math.max(x, maxPrime);
            if(isPrime(y)) maxPrime= Math.max(y, maxPrime);
        }
        return maxPrime;
    }

    boolean isPrime(int n){
        if (n <= 1) return false;
        for(int i=2; i*i<=n; i++) if(n%i==0) return false;
        return  true;
    }
}
