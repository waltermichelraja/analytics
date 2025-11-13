import java.util.*;

public class RabinKarp{
    static final int d=256; static final int q=101;

    static int hash(String s,int m){
        int h=0;
        for(int i=0;i<m;i++){h=(d*h+s.charAt(i))%q;}
        return h;
    }

    static int[] search(String text,String pattern){
        int n=text.length(),m=pattern.length();
        int h=1;
        for(int i=0;i<m-1;i++){h=(h*d)%q;}
        int p=hash(pattern,m);
        int t=hash(text,m);
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<=n-m;i++){
            if(p==t){
                int j=0;
                while(j<m&&text.charAt(i+j)==pattern.charAt(j)){j++;}
                if(j==m){st.push(i);}
            }
            if(i<n-m){
                t=(d*(t-text.charAt(i)*h)+text.charAt(i+m))%q;
                if(t<0){t+=q;}
            }
        }
        int indices[]=new int[st.size()];
        for(int k=0;k<indices.length;k++){indices[k]=st.get(k);}
        return indices;
    }
}

