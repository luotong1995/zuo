
import java.util.Stack;

public class MyQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public MyQueue() {
        this.stack1 = new Stack<Integer>();
        this.stack2 = new Stack<Integer>();
    }
    public void add(int newNum){
        stack1.push(newNum);
    }

    public int poll(){
        if(stack1.isEmpty() && stack2.isEmpty()){
            throw new RuntimeException("Queue is empty");
        }else if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                int temp = stack1.pop();
                stack2.push(temp);
            }
        }
        return stack2.pop();
    }
    public int peek(){
        if(stack1.isEmpty() && stack2.isEmpty()){
            throw new RuntimeException("Queue is empty");
        }else if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                int temp = stack1.pop();
                stack2.push(temp);
            }
        }
        return stack2.peek();
    }

    public static void main(String[] args){
        MyQueue myQueue = new MyQueue();
        myQueue.add(1);
        myQueue.add(2);
        myQueue.add(3);
        myQueue.poll();
        System.out.println(myQueue.peek());
    }
}
