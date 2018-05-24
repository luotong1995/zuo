import java.util.Stack;

public class ReverseStack {
    public static int getAndRemoveLastElement(Stack<Integer> stack){
        int result = stack.pop();
        if(stack.isEmpty())
            return result;
        else{
            int last = getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }
    }
    public static void reverse(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }
        int i = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(i);
    }
    public static void main(String[] args){
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        for(int x:stack){       //for each遍历并不会对栈内部的数据进行修改
            System.out.println(x);
        }
        reverse(stack);
        for(int x:stack){
            System.out.println(x);
        }

    }
}
