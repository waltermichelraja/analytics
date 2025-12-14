public class LongestCommonSubstring{
    public static String substring(String s1, String s2){
        int[][] dp=new int[s1.length()+1][s2.length()+1];
        int maxLen=0;
        int endIndex=0;
        for(int i=1;i<=s1.length();i++){
            for(int j=1;j<=s2.length();j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                    if(dp[i][j]>maxLen){
                        maxLen=dp[i][j];
                        endIndex=i;
                    }
                }
                else{dp[i][j]=0;}
            }
        }
        return s1.substring(endIndex-maxLen, endIndex);
    }
}

