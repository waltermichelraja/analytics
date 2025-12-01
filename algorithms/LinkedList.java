class LinkedList{
    class Node{
        int val;
        Node next; Node prev;
        Node(int v){val=v;}
    }
    Node head,tail; int length;
    public void append(int v){
        Node n=new Node(v);
        if(tail==null){
            head=n;
            tail=n;
        }else{
            tail.next=n;
            n.prev=tail;
            tail=n;
        }
        length++;
    }
    public void prepend(int v){
        Node n=new Node(v);
        if(head==null){
            head=n;
            tail=n;
        }else{
            n.next=head;
            head.prev=n;
            head=n;
        }
        length++;
    }
}

