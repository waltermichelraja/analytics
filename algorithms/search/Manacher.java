import java.util.*;

public class Manacher{
    static String prep(String s){
        String mc="@";
        for(char ch:s.toCharArray())mc+="#"+ch;
        return mc+"#$";
    }
    static String longestPalindrome(String str){
        String mc=prep(str);
        int vec[]=new int[mc.length()];
        int center=0, right=0;
        for(int i=0;i<mc.length();i++){
            while((i+1+vec[i])<mc.length() && i-1-vec[i]>=0 && mc.charAt(i+1+vec[i])==mc.charAt(i-1-vec[i])){vec[i]++;}
            if(i+vec[i]>right){center=i; right=i+vec[i];}
        }
        int value=0, index=0;
        for(int i=1;i<mc.length()-1;i++){
            if(vec[i]>value){
                value=vec[i]; index=i;
            }
        }
        int start=(index-value)/2;
        return str.substring(start, start+value);
    }
    static String[] palindromicSubstrings(String str) {
        String mc=prep(str);
        int vec[]=new int[mc.length()];
        int c=0, r=0;
        for(int i=1;i<mc.length()-1;i++){
            if(i<r){vec[i]=Math.min(r-i, vec[2*c-i]);}
            while(mc.charAt(i+1+vec[i])==mc.charAt(i-1-vec[i])){vec[i]++;}
            if(i+vec[i]>r){c=i; r=i+vec[i];}
        }
        Set<String> hs=new LinkedHashSet<>();
        for(int i=1;i<mc.length()-1;i++) {
            int rad=vec[i];
            while(rad>1){
                int start=(i-rad-1)/2; int endInc=(i+rad-2)/2;
                if(start>=0 && endInc<str.length() && endInc-start+1>1){hs.add(str.substring(start, endInc+1));}
                rad--;
            }
        }
        return hs.toArray(new String[0]);
    }
}
