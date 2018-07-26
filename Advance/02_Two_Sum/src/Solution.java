import java.util.ArrayList;

public class Solution {
    public static void main(String[] args){
//        int [] a = {1,3,4,5};
//        int[] indices = twoSum(a, 8);


//        int [] a = {1,3,3,4,5,5,7};
//        twoSum2(a, 8);
        int [] a = {1,2,3,4,5,5,6,6,8,9};
        uniqueTriad(a,10);
    }

    // 此问题是无重复元素且无重复解法
    public static int[] twoSum(int[] nums, int target){
        int[] indices = new int[nums.length];
        for(int i =0;i < nums.length; i++){
            indices[i] = i;
        }
        // 先对数组进行排序，然后使用两个指针，一个指向开始，一个指向末尾，
        // 将左指针指向的值加上右指针指向的值，
        // 如果值小于target 将左指针向右移动一个，
        // 如果值大于target 将右指针向左移动一个，
        // 相等则输出位置
        sort(nums, indices);

        int l = 0;
        int r = nums.length - 1;
        int sum = 0;
        while(l < r){
            sum = nums[l] + nums[r];
            if(sum < target){
                l ++;
            }else if(sum > target){
                r --;
            }else{
                return new int[] {indices[l], indices[r]};
            }
        }
        return new int[]{-1,-1};
    }

    // 此问题是有重复元素，只输出唯一的一对
    // 此时使用左右指针的时候，需要记录一下左指针的后一个元素是否与前一个元素相等（出现重复元素），
    // 若相等就输出第一次出现的位置，后面的都跳过

    // 此问题是有重复元素，并且有多组的解法，但是对于一样的解法只输出一次
    // 此时使用左右指针的时候，需要记录一下左指针的后一个元素是否与前一个元素相等（出现重复元素），
    // 若相等就输出第一次出现的位置，后面的都跳过
    public static void twoSum2(int[] nums, int target){
        int[] indices = new int[nums.length];
        for(int i =0;i < nums.length; i++){
            indices[i] = i;
        }
        // 先对数组进行排序，然后使用两个指针，一个指向开始，一个指向末尾，
        // 将左指针指向的值加上右指针指向的值，
        // 如果值小于target 将左指针向右移动一个，如果移动的时候后面一个值等于前面一个值，则跳过
        // 如果值大于target 将右指针向左移动一个，
        // 相等则输出位置
        sort(nums, indices);

        int l = 0;
        int r = nums.length - 1;
        int sum = 0;
        int last = 0;
        while(l < r){
            sum = nums[l] + nums[r];
            if(sum < target){
                last = nums[l];
                l ++;
            }else if(sum > target){
                r --;
            }else{
                if(l != 0){
                    if(nums[l] != last){
                        System.out.println(nums[l] + " " + nums[r]);
                    }
                }else{
                    System.out.println(nums[l] + " " + nums[r]);
                }
                last = nums[l];
                l ++;
            }
        }
    }

    public static void uniqueTriad(int[] nums, int k){
        if(nums == null || nums.length < 3){
            return;
        }
        for(int i = 0;i < nums.length;i++){
            if(i == 0 || nums[i] != nums[i - 1]){
                printRest(nums, i ,i+1, nums.length - 1, k-nums[i]);
            }
        }
    }

    public static void printRest(int[] nums, int i, int l,int r,int k){
        while (l < r){
            if(nums[l] + nums[r] < k){
                l ++;
            }else if(nums[l] + nums[r] > k){
                r --;
            }else {
                if(l == i+1 || nums[l - 1] != nums[l]){
                    System.out.println(nums[i]+ " " +nums[l] + " " + nums[r]);
                }
                l ++;
            }
        }
    }


    // 打印重复的
    // 1 1 2 2 2 3 3 3 3 4 5 5
    // 1.使用桶装入值相同的位置，然后进行排列组合
    // 2.遇到答案，写一个函数，求出左边向右只有相同的数的个数，右边向左相同的数的个数

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
