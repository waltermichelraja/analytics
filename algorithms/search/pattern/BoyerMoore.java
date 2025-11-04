import java.util.*;

public class BoyerMoore{
    static int[] search(String txt,String pat){
        int n=txt.length(), m=pat.length();
        if(m==0){return new int[]{0};}
        int bc[]=new int[256];
        for(int i=0;i<256;i++){bc[i]=-1;}
        for(int i=0;i<m;i++){bc[pat.charAt(i)]=i;}
        Stack<Integer>st=new Stack<>();
        int s=0;
        while(s<=n-m){
            int j=m-1;
            while(j>=0&&pat.charAt(j)==txt.charAt(s+j)){j--;}
            if(j<0){st.push(s);s+=m;}
            else{
                int c=txt.charAt(s+j);
                int last=bc[c];
                int shift=j-last;
                if(shift<1)shift=1;
                s+=shift;
            }
        }
        int indices[]=new int[st.size()];
        for(int i=0;i<indices.length;i++)indices[i]=st.get(i);
        return indices;
    }
}

