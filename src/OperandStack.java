public class OperandStack {


    int[] stack;
    int top;

    public OperandStack() {
        stack = new int[20];
        top = -1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top == stack.length-1;
    }

    public void push (int ch){
        if (!isFull()){
            stack[++top] = ch;
        }
    }

    public int pop (){
        if (!isEmpty()){
            return stack[top--];
        }return ' ';
//            }else {
//               System.out.println("Stack is empty");
//            }
    }

    public int peek(){
        if (!isEmpty()){
            return stack[top];
        }return ' ';
    }



}

