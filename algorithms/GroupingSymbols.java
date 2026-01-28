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
}

