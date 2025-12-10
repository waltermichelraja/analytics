class Queue{
    class Node{
        int val;
        Node next;
        Node(int v){val=v;}
    }
    Node head, tail; int length;
    public void enqueue(int v){
        Node n=new Node(v);
        if(tail==null){
            head=n;
            tail=n;
        }else{
            tail.next=n;
            tail=n;
        }
        length++;
    }
    public int dequeue(){
        if(head==null)throw new RuntimeException("QueueUnderflow");
        int x=head.val;
        head=head.next;
        if(head==null)tail=null;
        length--;
        return x;
    }
    public boolean isEmpty(){return head==null;}
    public int peek(){
        if(head==null)throw new RuntimeException("QueueEmpty");
        return head.val;
    }
    public void print(){
        Node cur=head;
        while(cur!=null){
            System.out.print(cur.val+" ");
            cur=cur.next;
        }
    }
}

