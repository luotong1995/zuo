import java.util.Stack;

public class StackSort2 {

    public static void SortStack(Stack<Integer> stack){
        Stack<Integer> tempStack = new Stack<>();
        while(!stack.isEmpty()){
            int x = stack.pop();
            while(!tempStack.isEmpty() && x > tempStack.peek()){
                stack.push(tempStack.pop());
            }
            tempStack.push(x);
        }

        while(!tempStack.isEmpty()){
            stack.push(tempStack.pop());
        }
    }

    public static void main(String[] args){
        Stack<Integer> stack  = new Stack<Integer>();
        stack.push(1);
        stack.push(4);
        stack.push(2);
        stack.push(3);

        SortStack(stack);
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
