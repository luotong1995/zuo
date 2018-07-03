### 复制含有随机指针的链表
时间复杂度为O(n) 空间复杂度为O(1)

solution1:要使时间复杂度为O(n)此时可以使用两次遍历

第一次、将每个Node放入到一个hashMap中，key为原node vale为副本node

第一次、遍历直接设置next和random

solution2:不能使用额外的数据结构

为了遍历的时候将副本的next random 都设置成功，并且不能使用其他的数据结构，
此时可以使用原节点的next为副本，然后设置副本的random的时候通过原节点可以找到，
最后再将原链表和副本链表分开
