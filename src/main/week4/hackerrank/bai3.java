static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode llist, int data) {
    SinglyLinkedListNode cur = new SinglyLinkedListNode(data);
    if(llist==null) {
        return cur;
    }
    cur.next = llist;
    llist = cur;
    return llist;
}