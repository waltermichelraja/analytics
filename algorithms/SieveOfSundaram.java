public class SieveOfSundaram{
    public static int[] primes(int n){
        if(n<2){return new int[0];}
        int m=(n-2)/2;
        boolean[] marked=new boolean[m+1];
        for(int i=1;i<=m;i++){
            for(int j=i;i+j+2*i*j<=m;j++){
                marked[i+j+2*i*j]=true;
            }
        }
        int count=1;
        for(int i=1;i<=m;i++){if(!marked[i])count++;}
        int[] primes=new int[count];
        int idx=0;
        primes[idx++]=2;
        for(int i=1;i<=m;i++){
            if(!marked[i]){
                primes[idx++]=2*i+1;
            }
        }
        return primes;
    }
}
