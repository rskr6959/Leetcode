class MyLinkedList {
    private class ListNode{
        int val;
        ListNode next;
        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }
    private ListNode head, tail;
    public MyLinkedList() {
        head = null;
        tail = null;
    }
    
    public int get(int index) {
        ListNode curr = head;
        int nodeIndex = 0;
        while(curr != null && index != nodeIndex){
            curr = curr.next;
            nodeIndex++;
        }
        if(curr != null){
            return curr.val;
        }else{
            return -1;
        }
    }
    
    public void addAtHead(int val) {
        ListNode node = new ListNode(val, head);
        head = node;
        if(tail == null){
            tail = head;
        }
    }
    
    public void addAtTail(int val) {
        ListNode node = new ListNode(val, null);
        if(head == null){
            head = node;
            tail = node;
        }else{
            tail.next = node;
            tail = node;
        }
    }
    
    public void addAtIndex(int index, int val) {
        ListNode sentinel = new ListNode(Integer.MIN_VALUE, head);
        ListNode node = new ListNode(val, null);
        ListNode curr = head;
        ListNode pred = sentinel;
        int nodeIndex = 0;
        while(curr != null && index != nodeIndex){
            pred = curr;
            curr = curr.next;
            nodeIndex++;
        }
        if(index == nodeIndex){
            pred.next = node;
            node.next = curr;
            if(curr == null)
            tail = node;
        }
        head = sentinel.next;
    }
    
    public void deleteAtIndex(int index) {
        ListNode sentinel = new ListNode(Integer.MIN_VALUE, head);
        ListNode pred = sentinel;
        ListNode curr = head;
        int nodeIndex = 0;
        while(curr != null && nodeIndex != index){
            curr = curr.next;
            pred = pred.next;
            nodeIndex++;
        }
        if(curr != null){
            pred.next = curr.next;
            if(tail == curr){
                tail = pred;
                if(tail == sentinel)
                tail = null;
            }
        }
        head = sentinel.next;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */