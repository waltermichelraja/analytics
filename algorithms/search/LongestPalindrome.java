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
    public static String subsequence(String s){
        int n=s.length();
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++)dp[i][i]=1;
        for(int len=2;len<=n;len++){
            for(int i=0;i<=n-len;i++){
                int j=i+len-1;
                if(s.charAt(i)==s.charAt(j)){
                    dp[i][j]=dp[i+1][j-1]+2;
                }else{
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        int i=0, j=n-1;
        while(i<=j){
            if(s.charAt(i)==s.charAt(j)){
                sb.append(s.charAt(i));
                i++; j--;
            }
            else if(dp[i+1][j]>=dp[i][j-1]){i++;}
            else{j--;}
        }
        String half=sb.toString();
        String rev=new StringBuilder(half).reverse().toString();
        if(dp[0][n-1]%2==0)return half+rev;
        return half.substring(0,half.length()-1)+rev;
    }
}

