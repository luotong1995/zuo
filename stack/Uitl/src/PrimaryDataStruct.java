import java.util.*;

public class PrimaryDataStruct {


    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        for(int i = 0;i < 1;i++ ){
            list.add("你是不是傻");
            list.add("你这样作你有什么好处");
            list.add("请你告诉我你这样得到了什么");
        }
//        默认冲第一个元素开始进行迭代
        Iterator listIter = list.listIterator();
        while(listIter.hasNext()){
            String x = (String)listIter.next();
            System.out.println("arraylist: " + x);
        }
//      用户自定义从哪个index开始进行迭代
        Iterator listIter0 = list.listIterator(1);
        while(listIter0.hasNext()){
            String x = (String)listIter0.next();
            System.out.println("arraylist: " + x);
        }

        long startTime=System.nanoTime();
        String str = list.remove(0);
        long endTime=System.nanoTime();
        System.out.println("ArrayList删除其中一个元素用时间： "+(endTime-startTime)+"ns");

        System.out.println("ArrayList的 len： "+ list.size());

//      LinkedList便于删除和插入，内部的实现使用链表，删除和插入比较的快,同时LinkedList实现了Queue的接口可以将其当作Queue来使用

        List<String > list2 = new LinkedList<>();
        for(int i = 0;i < 1;i++ ){
            list2.add("你是不是傻");
            list2.add("你这样作你有什么好处");
            list2.add("请你告诉我你这样得到了什么");
        }
        long startTime2=System.nanoTime();
        String str2 = list2.remove(0);
        long endTime2=System.nanoTime();
        System.out.println("LinkedList删除其中一个元素用时间： "+(endTime2-startTime2)+"ns");
        System.out.println("LinkedList的 len："+ list2.size());


        /*
        Map             HashMap
                        TreeMap  按照key的顺序进行存储
         */
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(2,3);

        hashMap.put(666,2);
        hashMap.put(7,2);
        hashMap.put(1,2);
        hashMap.put(4,2);
        hashMap.put(3,2);
        Iterator hashMapkeyIter = hashMap.keySet().iterator();
        while(hashMapkeyIter.hasNext()){
            int key =(int)hashMapkeyIter.next();
            System.out.println("hashmap" + key+ ' ' + String.valueOf(hashMap.get(key)));
        }

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(2,3);
        treeMap.put(1,2);
        treeMap.put(2,3);
        treeMap.put(4,2);
        treeMap.put(3,2);

        Iterator treeMapkeyIter = treeMap.keySet().iterator();
        while(treeMapkeyIter.hasNext()){
            int key =(int)treeMapkeyIter.next();
            System.out.println("treemap" + key+ ' ' + String.valueOf(hashMap.get(key)));
        }


//        tree set的使用能够进行元素的排序
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(2);
        treeSet.add(2);
        treeSet.add(1);
        treeSet.add(3);
        System.out.println(treeSet.first());
        System.out.println(treeSet.last());
        System.out.println(treeSet.headSet(3));
        Iterator treeSetIter = treeSet.iterator();
        while(treeSetIter.hasNext()){
            int x = (int)treeSetIter.next();
            System.out.println("treeSet: " + String.valueOf(x));
        }

//      HashSet 能够避免重复，但是不能保证set中的袁术的顺序
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(2);
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(4);
        hashSet.add(2);
        hashSet.add(5);
        hashSet.add(8);
        hashSet.add(9);

        Iterator hashSetIter = hashSet.iterator();
        while(hashSetIter.hasNext()){
            int x = (int)hashSetIter.next();
            System.out.println("hashSet: " + String.valueOf(x));
        }

//      LinkedHashSet 能够避免重复，而且还能保证元素输入的顺序，原因是内部是用链表实现的
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(2);
        linkedHashSet.add(1);
        linkedHashSet.add(2);
        linkedHashSet.add(3);
        Iterator linkedHashSetIter = linkedHashSet.iterator();
        while(linkedHashSetIter.hasNext()){
            int x = (int)linkedHashSetIter.next();
            System.out.println("linkedHashset: " + String.valueOf(x));
        }

    }
}
