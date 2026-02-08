import java.util.*;

public class Series{
    public static int apTerm(int a, int d, int n){
        return a+(n-1)*d;
    }

    public static int gpTerm(int a, int r, int n){
        int res=1;
        for(int i=1;i<n;i++){res*=r;}
        return a*res;
    }

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
    public static int uglyNumberTab(int n){
        int[] dp=new int[n];
        dp[0]=1;
        int i2=0,i3=0,i5=0;
        for(int i=1;i<n;i++){
            int next=Math.min(dp[i2]*2, Math.min(dp[i3]*3, dp[i5]*5));
            dp[i]=next;
            if(next==dp[i2]*2){i2++;}
            if(next==dp[i3]*3){i3++;}
            if(next==dp[i5]*5){i5++;}
        }
        return dp[n-1];
    }
    public static int catalan(int n){
        int[] dp=new int[n+1];
        dp[0]=1;
        for(int i=1;i<=n;i++){
            for(int j=0;j<i;j++){
                dp[i]+=dp[j]*dp[i-j-1];
            }
        }
        return dp[n];
    }
    public static int lucas(int n){
        if(n==0){return 2;}
        if(n==1){return 1;}
        int a=2,b=1;
        for(int i=2;i<=n;i++){
            int c=a+b;
            a=b;
            b=c;
        }
        return b;
    }
}

