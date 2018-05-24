public class SlideWindow {
    public static int[] getMaxWindow(int[] arr,int w){
        int len = arr.length - w + 1;//结果数组的长度
        int[] max = new int[len];
        for(int i=0;i< len;i ++){
            int[] temp = new int[w];
            for(int j = 0;j < w;j++){
                temp[j] = arr[i+j];
            }
            max[i] = getMax(temp);
        }
        return max;
    }
    public static int getMax(int[] b){//获取数组的最大值
        int max = b[0];
        for(int i=1;i<b.length;i++){
            if(max < b[i]){
                max = b[i];
            }
        }
        return max;
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
