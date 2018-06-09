public class PrintSameList {
    public static void printSamePart(NodeList header1, NodeList header2){
        while(header1 != null && header2 != null) {
            if (header1.value < header2.value) {
                header1 = header1.next;
            } else if (header1.value > header2.value) {
                header2 = header2.next;
            } else {
                System.out.print(String.valueOf(header1.value) + ' ');
                header1 = header1.next;
                header2 = header2.next;
            }
        }
    }

    public static void print(NodeList header){
        while (header != null){
            System.out.print(String.valueOf(header.value) + ' ');

            header = header.next;
        }
    }
    public static void main(String[] args){
        NodeList l1 = new NodeList(1);
        NodeList r = l1;
        for(int i = 1; i < 10 ; i++){
            NodeList temp = new NodeList(i);
            r.next = temp;
            r = temp;
        }
        r.next = null;

        NodeList l2 = new NodeList(1);
        NodeList r2 = l2;
        for(int i = 1; i < 1111 ; i++){
            NodeList temp = new NodeList(i);
            r2.next = temp;
            r2 = temp;
        }
        r2.next = null;

        print(l1);
        System.out.println();
        print(l2);
        System.out.println();

        printSamePart(l1, l2);
    }
}



class NodeList{
    public int value;
    public NodeList next;
    public NodeList(int value){
        this.value = value;
    }
}