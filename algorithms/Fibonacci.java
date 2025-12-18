import java.util.*;

public class Fibonacci{
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
}

