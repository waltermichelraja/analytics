import java.util.Stack;

public class GroupingSymbols{
    public static boolean isBalanced(String s){
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('||ch=='{'||ch=='['){
                stack.push(ch);
            }
            else if(ch==')'||ch=='}'||ch==']'){
                if(stack.isEmpty())return false;
                char top=stack.pop();
                if((ch==')'&&top!='(')||
                   (ch=='}'&&top!='{')||
                   (ch==']'&&top!='[')){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static int maxDepth(String s){
        int depth=0, max=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('||ch=='{'||ch=='['){
                depth++;
                if(depth>max){max=depth;}
            }
            else if(ch==')'||ch=='}'||ch==']'){depth--;}
        }
        return max;
    }

    public static String sanitize(String s){
        Stack<Integer> stack=new Stack<>();
        boolean[] valid=new boolean[s.length()];
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('){stack.push(i);}
            else if(ch==')'){
                if(!stack.isEmpty()){
                    int j=stack.pop();
                    valid[i]=true;
                    valid[j]=true;
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(valid[i]||!(s.charAt(i)=='('||s.charAt(i)==')')){sb.append(s.charAt(i));}
        }
        return sb.toString();
    }
}

