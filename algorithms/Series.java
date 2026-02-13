import java.util.*;

public class Series{
    static int[] memo;
    public static int fiboMemo(int n){
        if(n<=1)return n;
        if(memo==null||memo.length<=n){
            memo=new int[n+1];
            Arrays.fill(memo,-1);
        }
        if(memo[n]!=-1)return memo[n];
        memo[n]=fiboMemo(n-1)+fiboMemo(n-2);
        return memo[n];
    }
    public static int fiboTab(int n) {
        if(n<=1){return n;}
        int[] dp=new int[n+1];
        dp[0]=0; dp[1]=1;
        for(int i=2;i<=n;i++){dp[i]=dp[i-1]+dp[i-2];}
        return dp[n];
    }
    public static int fibo(int n) {
        if(n<=1){return n;}
        return fibo(n-1)+fibo(n-2);
    }
    public static long[] fibonacci(int n){
        long[] res=new long[n];
        if(n==0){return res;}
        res[0]=0;
        if(n==1){return res;}
        res[1]=1;
        for(int i=2;i<n;i++){
            res[i]=res[i-1]+res[i-2];
        }
        return res;
    }

    public static int[] ap(int a, int d, int n){
        int[] res=new int[n];
        for(int i=0;i<n;i++){
            res[i]=a+i*d;
        }
        return res;
    }

    public static long[] gp(long a, long r, int n){
        long[] res=new long[n];
        long curr=a;
        for(int i=0;i<n;i++){
            res[i]=curr;
            curr*=r;
        }
        return res;
    }

    public static long[] lucas(int n){
        long[] res=new long[n];
        if(n==0){return res;}
        res[0]=2;
        if(n==1){return res;}
        res[1]=1;
        for(int i=2;i<n;i++){
            res[i]=res[i-1]+res[i-2];
        }
        return res;
    }

    public static long[] pell(int n){
        long[] res=new long[n];
        if(n==0){return res;}
        res[0]=0;
        if(n==1){return res;}
        res[1]=1;
        for(int i=2;i<n;i++){
            res[i]=2*res[i-1]+res[i-2];
        }
        return res;
    }

    public static long[] catalan(int n){
        long[] res=new long[n];
        if(n==0)return res;
        res[0]=1;
        for(int i=1;i<n;i++){
            res[i]=0;
            for(int j=0;j<i;j++){
                res[i]+=res[j]*res[i-j-1];
            }
        }
        return res;
    }

    public static long[] uglyNumbers(int n){
        long[] res=new long[n];
        res[0]=1;
        int i2=0,i3=0,i5=0;
        for(int i=1;i<n;i++){
            long next=Math.min(res[i2]*2, Math.min(res[i3]*3, res[i5]*5));
            res[i]=next;
            if(next==res[i2]*2){i2++;}
            if(next==res[i3]*3){i3++;}
            if(next==res[i5]*5){i5++;}
        }
        return res;
    }

    public static boolean isPerfect(long n){
        if(n<2){return false;}
        long sum=1;
        for(long i=2;i*i<=n;i++){
            if(n%i==0){
                sum+=i;
                if(i!=n/i){sum+=n/i;}
            }
        }
        return sum==n;
    }

    public static boolean isArmstrong(long x){
        long temp=x,sum=0;
        long d=(long)Math.log10(x)+1;
        while(temp>0){
            long r=temp%10;
            sum+=Math.pow(r,d);
            temp/=10;
        }
        return sum==x;
    }
}

