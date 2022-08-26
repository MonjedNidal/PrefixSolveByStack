public class OperatorStack {

    char[] stack;
    int top;

    public OperatorStack(int n) {
        stack = new char[n];
        top = -1;
    }



    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top == stack.length-1;
    }

    public void push (char ch){
        if (!isFull()){
            stack[++top] = ch;
        }
    }

    public char pop (){
        if (!isEmpty()){
            return stack[top--];
        }return ' ';
    }

    public char peek(){
        if (!isEmpty()){
            return stack[top];
        }return ' ';
    }


}



