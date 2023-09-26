static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
    SinglyLinkedListNode cur = new SinglyLinkedListNode(data);
    SinglyLinkedListNode temp = head;
    if(head==null) {
        return cur;
    }
    while(temp.next!=null) {
        temp = temp.next;
    }
    temp.next = cur;
    cur.next=null;
    return head;
}