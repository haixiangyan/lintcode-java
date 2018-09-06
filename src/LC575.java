import java.util.Stack;

public class LC575 {
    public String expressionExpand(String s) {
        if (s == null) {
            return null;
        }
        if (s.length() == 0) {
            return "";
        }

        Stack<String> stack = new Stack<>();
        String result = "";

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ']') {
                stack.push(s.substring(i, i + 1));
            }
            else {
                String str = "";
                String num = "";

                while (!stack.peek().equals("[")) {
                    str = stack.pop() + str;
                }

                stack.pop(); // Pop "["

                while (!stack.isEmpty() && isNum(stack.peek())) {
                    num = stack.pop() + num;
                }

                int number = Integer.parseInt(num);
                if (number != 0) {
                    String string = "";
                    for (int j = 0; j < number; j++) {
                        string = string + str;
                    }
                    stack.push(string); // Put the expanded string to stack
                }
            }
        }

        while (!stack.isEmpty()) {
            result = stack.pop() + result;
        }
        return result;
    }

    private boolean isNum(String s) {
        if (s.charAt(0) >= '0' && s.charAt(0) <= '9') {
            return true;
        }
        return false;
    }
}
