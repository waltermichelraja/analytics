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
}

