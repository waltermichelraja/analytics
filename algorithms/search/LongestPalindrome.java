public class LongestPalindrome{
    public static String substring(String s){
        int n=s.length();
        if(n<2){return s;}
        boolean[][] dp=new boolean[n][n];
        int maxLen=1, start=0;
        for(int i=0;i<n;i++)dp[i][i]=true;

        for(int len=2;len<=n;len++){
            for(int i=0;i<=n-len;i++){
                int j=i+len-1;
                if(s.charAt(i)==s.charAt(j)){
                    if(len<=3)dp[i][j]=true;
                    else dp[i][j]=dp[i+1][j-1];
                }else dp[i][j]=false;

                if(dp[i][j]&&len>maxLen){
                    maxLen=len;
                    start=i;
                }
            }
        }
        return s.substring(start,start+maxLen);
    }
}

