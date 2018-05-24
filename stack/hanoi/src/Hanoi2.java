import java.util.Stack;

public class Hanoi2 {
    public enum Action{
        No,LToM,MToL,MToR,RToM
    }

    public static int hanoiProblem2(int num,String left,String mid,String right){
        Stack<Integer> ls = new Stack<Integer>();
        Stack<Integer> ms = new Stack<Integer>();
        Stack<Integer> rs = new Stack<Integer>();
        ls.push(Integer.MAX_VALUE);
        ms.push(Integer.MAX_VALUE);
        rs.push(Integer.MAX_VALUE);
        for (int i = num;i > 0;i--){
            ls.push(i);
        }
        Action[] record = {Action.No};//记录前一次的操作
        int step = 0;
        while (rs.size() != num + 1){
            step += fStackTotStack(record,Action.MToL,Action.LToM,ls,ms,left,mid);
            step += fStackTotStack(record,Action.LToM,Action.MToL,ms,ls,mid,left);
            step += fStackTotStack(record,Action.RToM,Action.MToR,rs,ms,right,mid);
            step += fStackTotStack(record,Action.MToR,Action.RToM,ms,rs,mid,right);
        }
        return step;
    }

    public static int fStackTotStack(Action[] record,Action preNoAct,
                                     Action nowAct,
                                     Stack<Integer> fStack,Stack<Integer> tStack,String from,String to){
        if(record[0] != preNoAct && fStack.peek() < tStack.peek()){//记录的前一次操作不能够等于传入的preNoAct
            tStack.push(fStack.pop());
            System.out.println("Move" + tStack.peek() + " from "+ from + " to " + to);
            record[0] = nowAct;
            return 1;
        }
        return 0;

    }
    public static void main(String[] args){
        int steps = hanoiProblem2(3,"L","M","R");
        System.out.println(steps);
    }
}

