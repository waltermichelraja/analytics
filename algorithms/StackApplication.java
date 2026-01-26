import java.util.*;

public class StackApplication{
    static int prec(char c){
        if(c=='^'){return 3;}
        if(c=='*'||c=='/'){return 2;}
        if(c=='+'||c=='-'){return 1;}
        return -1;
    }

    static String infixToPrefix(String infix){
        StringBuilder rev=new StringBuilder(infix).reverse();
        char[] arr=rev.toString().toCharArray();
        Stack<Character> st=new Stack<>();
        StringBuilder out=new StringBuilder();
        for(char c: arr){
            if(Character.isLetterOrDigit(c)){out.append(c);}
            else if(c==')'){st.push(c);}
            else if(c=='('){
                while(!st.isEmpty()&&st.peek()!=')'){
                    out.append(st.pop());
                }
                if(!st.isEmpty())st.pop();}
            else{
                while(!st.isEmpty()&&prec(st.peek())>prec(c)){
                    out.append(st.pop());
                }
                st.push(c);
            }
        }
        while(!st.isEmpty()){out.append(st.pop());}
        return out.reverse().toString();
    }

    static String infixToPostfix(String infix){
        Stack<Character> st=new Stack<>();
        StringBuilder out=new StringBuilder();
        for(char c: infix.toCharArray()){
            if(Character.isLetterOrDigit(c)){out.append(c);}
            else if(c=='('){st.push(c);}
            else if(c==')'){
                while(!st.isEmpty()&&st.peek()!='('){
                    out.append(st.pop());
                }
                st.pop();
            }
            else{
                while(!st.isEmpty()&&prec(st.peek())>=prec(c)){
                    out.append(st.pop());
                }
                st.push(c);
            }
        }
        while(!st.isEmpty()){out.append(st.pop());}
        return out.toString();
    }

    static int apply(char op, int a, int b){
        switch(op){
            case '+': return a+b;
            case '-': return a-b;
            case '*': return a*b;
            case '/':
                if(b==0){throw new ArithmeticException("division by zero");}
                return a/b;
            case '^': return (int)Math.pow(a,b);
            default: throw new IllegalArgumentException("invalid operator:"+op);
        }
    }

    static int evaluatePrefix(String expr){
        Stack<Integer> st=new Stack<>();
        int i=expr.length()-1;
        while(i>=0){
            char c=expr.charAt(i);
            if(c==' '){i--; continue;}
            if(Character.isDigit(c)){
                int num=0,base=1;
                int start=i;
                while(i>=0&&Character.isDigit(expr.charAt(i))){
                    num+=(expr.charAt(i)-'0')*base;
                    base*=10;
                    i--;
                }
                if(i>=0&&"+-*/^".indexOf(expr.charAt(i))!=-1&&start-i>1){
                    for(int k=start;k>i;k--){
                        st.push(expr.charAt(k)-'0');
                    }
                    continue;
                }
                st.push(num);
                continue;
            }
            if(st.size()<2){throw new IllegalArgumentException("invalid prefix expression");}
            int a=st.pop();
            int b=st.pop();
            st.push(apply(c, a, b));
            i--;
        }
        if(st.size()!=1){throw new IllegalArgumentException("invalid prefix expression");}
        return st.pop();
    }

}

