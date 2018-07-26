public class HeapSort {

    public static void main(String[] args){
        int a[] = {5,4,2,6,8,1};
        int indices[] = {0,1,2,3,4,5};
        sort(a,indices);
        for(int item: a){
            System.out.println(item);
        }
    }

    public static void sort(int[] arr, int[] indices){
        //1.构建大顶堆
        // 从第一个节点进行遍历，然后构建大顶堆
        for(int i=0;i < arr.length;i++){
            heapInsert(arr,indices, i);
        }
        //将堆顶的元素与最后的子节点进行交换，然后从0 --- i-1 个节点开始重新调整堆
        for(int i = arr.length - 1; i >= 0; i--){
            swap(arr, indices, 0, i);
            heapify(arr, indices, i);
        }
    }

    public static void heapInsert(int[] arr,int[] indices, int i){

        while(i > 0){
            // p位置为i节点的父节点的位置，为了生成一个大顶堆，
            // 每次插入一个节点的时候需要与其父节点进行比较是否满足堆的定义，满足则直接插入，否则与父节点交换位置
            int p = (i - 1) / 2;
            //如果父亲节点p 大于等于 子节点i，则不需要进行交换，放在原数组的位置
            if(arr[i] <= arr[p]){
                break;
            }
            // 交换父子节点，然后重新堆父亲节点进行调整
            swap(arr, indices, i, p);
            i = p;
        }
    }


    public static void swap(int[] arr, int[] indices, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        temp = indices[i];
        indices[i] = indices[j];
        indices[j] = temp;
    }


    public static void heapify(int[] arr, int[] indices, int length){
        int i =0;
        int left = 1;
        int right = 2;
        int largest;
        // 只操作小于length的节点,length上的节点已经是一个排好序的节点
        // 从头顶节点开始进行交换，知道满足堆的定义为止
        while(left < length){
            largest = arr[left] > arr[i] ? left:i;
            largest = right < length && arr[right] > arr[largest] ? right:largest;
            if (largest == i){
                break;
            }
            swap(arr, indices, largest, i);
            i = largest;
            left = i * 2 + 1;
            right = i * 2 + 2;
        }
    }
}
