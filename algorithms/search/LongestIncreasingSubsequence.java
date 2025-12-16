import java.util.*;

public class LongestIncreasingSubsequence{
    public static int[] subsequence(int[] nums){
        if(nums==null||nums.length==0){return new int[0];}
        int n=nums.length;
        int[] dp=new int[n];
        int[] prev=new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(prev,-1);
        int maxLen=1;
        int lastIndex=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]&&dp[j]+1>dp[i]){
                    dp[i]=dp[j]+1;
                    prev[i]=j;
                }
            }
            if(dp[i]>maxLen){
                maxLen=dp[i];
                lastIndex=i;
            }
        }
        int[] result=new int[maxLen];
        int k=maxLen-1;
        while(lastIndex!=-1){
            result[k--]=nums[lastIndex];
            lastIndex=prev[lastIndex];
        }
        return result;
    }
}

