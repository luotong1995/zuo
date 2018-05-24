import java.util.Stack;

public class StackSort {
    public static void sortStackByStack(Stack<Integer> stack){
        Stack<Integer> help = new Stack<Integer>();
        while(!stack.isEmpty()){
            int x = stack.pop();
            while(!help.isEmpty() && x > help.peek()){
                stack.push((help.pop()));
            }
            help.push(x);
        }
        while(!help.isEmpty()){
            stack.push(help.pop());
        }

    }
    public static void main(String[] args){
        Stack<Integer> stack  = new Stack<Integer>();
        stack.push(1);
        stack.push(4);
        stack.push(2);
        stack.push(3);

        sortStackByStack(stack);
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
