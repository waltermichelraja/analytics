import java.util.*;

public class ZAlgorithm{
    static int[] buildZ(String s){
        int n=s.length();
        int Z[]=new int[n];
        int L=0,R=0;
        for(int i=1;i<n;i++){
            if(i<=R){Z[i]=Math.min(R-i+1, Z[i-L]);}
            while(i+Z[i]<n && s.charAt(Z[i])==s.charAt(i+Z[i])){Z[i]++;}
            if(i+Z[i]-1>R){
                L=i;
                R=i+Z[i]-1;
            }
        }
        return Z;
    }

    static int[] search(String t, String p){
        String s=p+'$'+t;
        Stack<Integer> st=new Stack<>();
        int Z[]=buildZ(s);
        int m=p.length();
        for(int i=0;i<Z.length;i++){
            if(Z[i]==m){st.push(i-m-1);}
        }
      	int indices[]=new int[st.size()];
      	for(int k=0;k<indices.length;k++){indices[k]=st.get(k);}
      	return indices;
    }
}

