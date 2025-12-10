class Stack{
    class Node{
        int val;
        Node next;
        Node(int v){val=v;}
    }
    Node top; int length;
    public void push(int v){
        Node n=new Node(v);
        n.next=top;
        top=n;
        length++;
    }
    public int pop(){
        if(top==null)throw new RuntimeException("StackUnderflow");
        int x=top.val;
        top=top.next;
        length--;
        return x;
    }
    public boolean isEmpty(){return top==null;}
    public int peek(){
        if(top==null)throw new RuntimeException("StackEmpty");
        return top.val;
    }
    public void print(){
        Node cur=top;
        while(cur!=null){
            System.out.print(cur.val+" ");
            cur=cur.next;
        }
    }
}
