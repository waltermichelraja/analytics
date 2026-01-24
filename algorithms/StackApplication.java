import java.util.*;

public class StackApplication{
    static int prec(char c){
        if(c=='^')return 3;
        if(c=='*'||c=='/')return 2;
        if(c=='+'||c=='-')return 1;
        return -1;
    }

    static String infixToPrefix(String infix){
        StringBuilder rev=new StringBuilder(infix).reverse();
        char[] arr=rev.toString().toCharArray();
        Stack<Character> st=new Stack<>();
        StringBuilder out=new StringBuilder();
        for(char c:arr){
            if(Character.isLetterOrDigit(c)){
                out.append(c);
            }else if(c==')'){
                st.push(c);
            }else if(c=='('){
                while(!st.isEmpty()&&st.peek()!=')'){
                    out.append(st.pop());
                }
                if(!st.isEmpty())st.pop();
            }else{
                while(!st.isEmpty()&&prec(st.peek())>prec(c)){
                    out.append(st.pop());
                }
                st.push(c);
            }
        }
        while(!st.isEmpty()){out.append(st.pop());}
        return out.reverse().toString();
    }
}

