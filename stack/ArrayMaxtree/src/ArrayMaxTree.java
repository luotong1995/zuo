

//TODO 之后再做，这个题目有点不会
public class ArrayMaxTree {


    public static void main(String[] args){
        Node node = new  Node(1);

        System.out.println(node.value);
    }

}

class Node{
    public int value;
    public Node left;
    public Node right;

    public Node(int value){
        this.value = value;
    }
}