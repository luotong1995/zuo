### 将单链表变成左边小于一个某个数，右边大于某个数
比如 1->4->5->2->9  输入5: 1->4->2->5->9

输入一个值pivot
定义三个head1,head2,head3

遍历整个链表
1. 如果值小于pivot,添加在head1后
2. 如果值等于pivot,添加在head2后
3. 如果值大于pivot,添加在head3后

然后将三个head 按顺序拼起来
