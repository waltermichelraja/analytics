package custom;

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
    public boolean isEmpty(){return length==0;}
    public Integer get(int index){
        if(index<0||index>=length)return null;
        Node cur;
        if(index<length/2){
            cur=head;
            for(int i=0;i<index;i++)cur=cur.next;
        }else{
            cur=tail;
            for(int i=length-1;i>index;i--)cur=cur.prev;
        }
        return cur.val;
    }
    public boolean removeAt(int index){
        if(index<0||index>=length)return false;
        if(index==0)return removeHead();
        if(index==length-1)return removeTail();
        Node cur;
        if(index<length/2){
            cur=head;
            for(int i=0;i<index;i++)cur=cur.next;
        }else{
            cur=tail;
            for(int i=length-1;i>index;i--)cur=cur.prev;
        }
        cur.prev.next=cur.next;
        cur.next.prev=cur.prev;
        length--;
        return true;
    }
    private boolean removeHead(){
        if(head==null)return false;
        if(head==tail){
            head=null;
            tail=null;
            length=0;
            return true;
        }
        head=head.next;
        head.prev=null;
        length--;
        return true;
    }
    private boolean removeTail(){
        if(tail==null)return false;
        if(head==tail){
            head=null;
            tail=null;
            length=0;
            return true;
        }
        tail=tail.prev;
        tail.next=null;
        length--;
        return true;
    }
}

