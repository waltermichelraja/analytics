import java.util.*;

public class KMP{
    static int[] lps(String pattern){
    	int m=pattern.length();
    	int lps[]=new int[m];
    	int i=1, j=0;
    	while(i<m){
    		  if(pattern.charAt(i)==pattern.charAt(j)){
      			  j+=1; lps[i]=j; i+=1;
    		  }
      		else{
        			if(j!=0){j=lps[j-1];}
        			else{lps[i]=0; i+=1;}
      		}
    	  }
    	  return lps;
    }
    static int[] search(String text, String pattern){
      	int n=text.length(); int m=pattern.length();
      	Stack<Integer> st=new Stack<>();
      	int lps[]=lps(pattern); int i=0,j=0;
      	while(i<n){
        		if(pattern.charAt(j)==text.charAt(i)){i+=1; j+=1;}
        		if(j==m){st.push(i-j); j=lps[j-1];}
        		else if(i<n && pattern.charAt(j)!=text.charAt(i)){
          			if(j!=0){j=lps[j-1];}
          			else{i+=1;}
        		}
      	}
      	int indices[]=new int[st.size()];
      	for(int k=0;k<indices.length;k++){indices[k]=st.get(k);}
      	return indices;
    }
}
