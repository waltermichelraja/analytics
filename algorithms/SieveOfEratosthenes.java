public class SieveOfEratosthenes{
    public static int[] primes(int n){
        if(n<2){return new int[0];}
        boolean[] isPrime=new boolean[n+1];
        for(int i=2;i<=n;i++)isPrime[i]=true;
        for(int i=2;i*i<=n;i++){
            if(isPrime[i]){
                for(int j=i*i;j<=n;j+=i){
                    isPrime[j]=false;
                }
            }
        }
        int count=0;
        for(int i=2;i<=n;i++){
            if(isPrime[i]){count++;}
        }
        int[] primes=new int[count];
        int idx=0;
        for(int i=2;i<=n;i++){
            if(isPrime[i]){
                primes[idx++]=i;
            }
        }
        return primes;
    }
}

