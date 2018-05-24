import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class SlideWindow2 {
    public static int[] getMaxWindow(int[] arr,int w){
        if(arr ==null || w < 1 || arr.length < w){
            return null;
        }
        Deque<Integer> qmax = new LinkedList<Integer>();
        int[] res = new int[arr.length - w +1];
        int index = 0;
        for(int i =0;i< arr.length;i++){
            while(!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]){
                qmax.pollLast();
            }
            qmax.addLast(i);
            if(qmax.peekFirst() == i - w){
                qmax.pollFirst();
            }
            if(i >= w -1){
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;

    }
    public static void main(String[] args){
        int[] a = new int[]{4,3,5,4,3,3,6,7};
        int[] b = getMaxWindow(a,3);
        for(int i = 0; i< b.length;i++){
            System.out.print(b[i] + " ");
        }
        System.out.println();
    }

}
