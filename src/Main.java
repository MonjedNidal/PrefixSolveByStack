public class Main {
    public static void main(String[] args) {
        String eq = "4/2+4+5*2";
        System.out.println("Equation : "+ eq);
        System.out.println("Prefix : "+ reverse(getPrefix(eq).toString()));
        System.out.println("Result : "+ solvePrefix(getPrefix(eq)));
    }

    public static StringBuilder reverse(String eq){
        StringBuilder reversed = new StringBuilder("");
        for (int i = eq.length()-1; i >= 0; i--) {
            reversed.append(eq.charAt(i));
        }
        return reversed;
    }

    public static StringBuilder getPrefix(String eq) {
        OperatorStack stack = new OperatorStack(100);
        StringBuilder prefix = new StringBuilder();
        for (int i = eq.length()-1; i >= 0; i--) {
            char ch = eq.charAt(i);
            switch (getType(ch)) {
                case 1:
                    prefix.append(ch);
                    break;
                case 2:
                    while (!stack.isEmpty() && priority(ch) < priority(stack.peek())) {
                        prefix.append(stack.pop());
                    }
                    stack.push(ch);
                    break;
                default:
            }
        }
        while (!stack.isEmpty()) {
            prefix.append(stack.pop());
        }
        return prefix;
    }

    private static int solvePrefix(StringBuilder post) {
        int res = 0;
        int a = 0,b = 0;
        OperandStack stack = new OperandStack();

        for (int i = 0; i < post.length(); i++) {
            switch (getType(post.charAt(i))){
                case 1:
                    stack.push(post.charAt(i) - '0');
                    break;
                case 2:
                    if (!stack.isEmpty()){
                        a = stack.pop();
                    }else {
                        System.out.println("Equation Error!..1");
                    }
                    if (!stack.isEmpty()){
                        b = stack.pop();
                    }else {
                        System.out.println("Equation Error!..2");
                    }
                    res = operator(a,b,post.charAt(i));
                    stack.push(res);
            }
        }
        return res;

    }

    private static int operator(int a, int b, char ch) {
        switch (ch){
            case '+':
                return a+b;
            case '-':
                return a-b;
            case '*':
                return a*b;
            case '/':
                return a/b;
            default:
                return 0;
        }
    }

    private static int priority(char ch) {
        if (ch == '+' || ch == '-'){
            return 2;
        }else if (ch == '*' || ch == '/'){
            return 3;
        }
        return 0;
    }

    private static int getType(char ch) {
        if (ch >= '0' && ch <= '9'){
            return 1;
        } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
            return 2;
        }
        return 0;
    }
}
