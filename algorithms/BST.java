class BST{
    class Node{
        int val;
        Node left,right;
        Node(int v){val=v;}
    }
    Node root;
    private Node insertRec(Node n,int v){
        if(n==null)return new Node(v);
        if(v<n.val)n.left=insertRec(n.left,v);
        else n.right=insertRec(n.right,v);
        return n;
    }
    private Node deleteRec(Node n,int v){
        if(n==null)return null;
        if(v<n.val)n.left=deleteRec(n.left,v);
        else if(v>n.val)n.right=deleteRec(n.right,v);
        else{
            if(n.left==null)return n.right;
            if(n.right==null)return n.left;
            Node m=minNode(n.right);
            n.val=m.val;
            n.right=deleteRec(n.right,m.val);
        }
        return n;
    }
    private Node minNode(Node n){
        while(n.left!=null)n=n.left;
        return n;
    }

    private void inorderRec(Node n){
        if(n==null)return;
        inorderRec(n.left);
        System.out.print(n.val+" ");
        inorderRec(n.right);
    }
    private void preorderRec(Node n){
        if(n==null)return;
        System.out.print(n.val+" ");
        preorderRec(n.left);
        preorderRec(n.right);
    }
    private void postorderRec(Node n){
        if(n==null)return;
        postorderRec(n.left);
        postorderRec(n.right);
        System.out.print(n.val+" ");
    }
    private void levelOrderRec(){
        if(root==null)return;
        java.util.Queue<Node>q=new java.util.LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node c=q.poll();
            System.out.print(c.val+" ");
            if(c.left!=null)q.add(c.left);
            if(c.right!=null)q.add(c.right);
        }
    }

    public void insert(int v){root=insertRec(root,v);}

    public void delete(int v){root=deleteRec(root,v);}

    public void inorder(){inorderRec(root);}
    
    public void preorder(){preorderRec(root);}

    public void postorder(){postorderRec(root);}

    public void levelorder(){levelOrderRec();}
}

