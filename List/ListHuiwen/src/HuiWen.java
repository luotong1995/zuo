import java.util.Stack;

public class HuiWen {
    //在栈中放入一半节省空间
    public static boolean isHuiWen(NodeList head){
        if(head == null || head.next == null){
            return true;
        }
        NodeList cur = head;
        NodeList right = head.next;
        while(cur.next != null && cur.next.next != null){
            right = right.next;
            cur = cur.next.next;
        }
        Stack<NodeList> stack = new Stack<>();
        while(right != null){
            stack.push(right);
            right = right.next;
        }
        while(!stack.isEmpty()){
            if (head.value != stack.pop().value ){
                return  false;
            }
            head = head.next;
        }
        return true;
    }


    //在栈中放入所有的节点然后进行比较
    public static boolean isHuiWen2(NodeList head){
        if(head == null || head.next == null){
            return true;
        }
        NodeList cur = head;
        Stack<NodeList> stack = new Stack<>();
        while(cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        while(!stack.isEmpty()){
            if (head.value != stack.pop().value ){
                return  false;
            }
            head = head.next;
        }
        return true;
    }


    //在栈中放入一半节省空间
    public static boolean isHuiWen3(NodeList head){
        if(head == null || head.next == null){
            return true;
        }
        //找到中间节点
        NodeList cur = head;
        NodeList mid = head;
        while(cur.next != null && cur.next.next != null){
            mid = mid.next;
            cur = cur.next.next;
        }
        //反转右边的节点 并指向mid节点
        NodeList right_head = mid.next;
        NodeList right = mid;
        NodeList temp = right_head;
        while(temp != null){
            NodeList next = temp.next;
            temp.next = right;
            right = temp;
            temp = next;
        }

        //中间节点再指向null
        mid.next = null;
        //遍历左边和右边的节点，判断是否值相同
        NodeList l1 = head;
        NodeList l2 = right_head;
        boolean re = true;
        while(l1 != null && l2 != null){
            if(l1.value != l2.value){
                re = false;
                break;
            }
        }

        //然后将链表恢复原状
        temp = right.next;
        NodeList new_ = null;
        while(temp != null){
            NodeList next = temp.next;
            temp.next = new_;
            new_ = temp;
            temp = next;
        }

        return re;
    }


    public static void print_list(NodeList L){
        NodeList l2 = L;
        while(l2 != null){
            System.out.println(l2.value);
            l2 = l2.next;
        }
    }

    public static void main(String[] args){


        NodeList head = null;
        NodeList r = null;
        NodeList p = null;
        int numbe[] = {1,2,3,4,4,3,2,1};
        for(int i = 0 ;i < numbe.length; i++){
            p = new NodeList(numbe[i]);
            // 创建链表的第一个节点
            if (head == null) {
                head = p;
                r = p;
                p.next = null;
            } else {
                r.next = p;
                r = p;
            }
        }
        r.next = null;



        print_list(head);
        boolean ishuiwen = isHuiWen2(head);
        System.out.println("-------------------------");
        System.out.println(ishuiwen);
        System.out.println("-------------------------");
        print_list(head);

    }
}


class NodeList{
    public int value;
    public NodeList next;

    public NodeList(int value){
        this.value = value;
    }

}