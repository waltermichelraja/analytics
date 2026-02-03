public class SieveOfAtkin{
    public static int[] primes(int n){
        if(n<2){return new int[0];}
        boolean[] isPrime=new boolean[n+1];
        int limit=(int)Math.sqrt(n);
        for(int x=1;x<=limit;x++){
            for(int y=1;y<=limit;y++){
                int k=4*x*x+y*y;
                if(k<=n && (k%12==1 || k%12==5)){isPrime[k]=!isPrime[k];}
                k=3*x*x+y*y;
                if(k<=n && k%12==7){isPrime[k]=!isPrime[k];}
                k=3*x*x-y*y;
                if(x>y && k<=n && k%12==11){isPrime[k]=!isPrime[k];}
            }
        }
        for(int i=5;i<=limit;i++){
            if(isPrime[i]){
                int sq=i*i;
                for(int j=sq;j<=n;j+=sq){isPrime[j]=false;}
            }
        }
        int count=(n>=2?1:0)+(n>=3?1:0);
        for(int i=5;i<=n;i+=2){if(isPrime[i])count++;}
        int[] primes=new int[count];
        int idx=0;
        if(n>=2)primes[idx++]=2;
        if(n>=3)primes[idx++]=3;
        for(int i=5;i<=n;i+=2){if(isPrime[i]){primes[idx++]=i;}}
        return primes;
    }
}

