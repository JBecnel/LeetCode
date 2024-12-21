import java.util.Stack;

public class ValidParantheses {
    public boolean isValid(String str) {
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if ((ch == '(') || (ch == '{')  || (ch == '[')) {
                stack.push(ch);
            } else {
                if (stack.isEmpty())
                    return false;

                char top = stack.peek();
                if (ch == ')' && top != '(') 
                    return false;
                else if (ch == '}' && top != '{') 
                    return false;
                else if (ch == ']'  && top != '[')
                    return false;
                
                stack.pop();
            }
        }
        return stack.isEmpty();
        
    }
    
    public static void main(String[] args) {
        ValidParantheses vp = new ValidParantheses();
        System.out.println(vp.isValid("(()(({[[]]})))"));
        System.out.println(vp.isValid("[]({}})[()]"));
        System.out.println(vp.isValid("[]({]})"));
    }
}
