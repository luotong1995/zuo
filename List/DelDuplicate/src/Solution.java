import java.util.HashSet;

public class Solution {
    // O(n)   O(n)
    public static void removeRep1(Node head){
        if(head == null){
            return;
        }
        HashSet<Integer> set = new HashSet<>();
        set.add(head.value);
        Node pre = head;
        Node cur = head.next;
        while(cur != null){
            if(set.contains(cur.value)){
                pre.next = cur.next;
            }else{
                set.add(cur.value);
                pre = cur;
            }
            cur = cur.next;
        }
    }

    public static void removeRep2(Node head){
        if(head == null){
            return;
        }
        Node cur = head;
        Node pre = null;
        Node next = null;
        while(cur != null){
            pre = cur;
            next = cur.next;
            while (next != null){
                if(cur.value == next.value){
                    pre.next = next.next;
                }else{
                    pre = next.next;
                }
                next = next.next;
            }
            cur = cur.next;
        }
    }

}

class Node{
    public int value;
    public Node next;
    public Node(int value){
        this.value = value;
    }
}
