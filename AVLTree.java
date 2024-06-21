public class AVLTree {
    public static class Node{
        Node left;
        Node right;
        int data;
        int height;
        public Node(int data){
            this.data=data;
            left=null;
            right=null;
            height=1;
    
    }
    
}
  Node createBST(Node root, int data){
    if(root == null) {
        return new Node(data);

    }
    else if(root.data > data) {
        root.left = createBST(root.left, data);
  
  }
  else if(root.data < data) {
    root.right = createBST(root.right, data);
  }
    else{
        return root;
    }
    root.height = 1+Math.max(getHeight(root.left), getHeight(root.right));
    int balanceFactor = getBalanceFactor(root);
    //LL
    if(balanceFactor > 1 && data<root.left.data){
        return rightRotation(root);
    }
    //LR
    if(balanceFactor > 1 && data>root.left.data){
        root.left = leftRotation(root.left);
        return rightRotation(root);

    }
    //RR
    if(balanceFactor < -1 && data>root.right.data){
        return leftRotation(root);

    }
    //RL
    if(balanceFactor<-1 && data<root.right.data){
        root.right = rightRotation(root.right);
        return leftRotation(root);
        

    }
    Node rightRotation(Node y){
        Node x = y.left;
        Node T2 = x.right;
        x.right = y;
        y.left = T2;
        y.height = 1+Math.max(getHeight(y.left), getHeight(y.right));
        x.height = 1+Math.max(getHeight(x.left), getHeight(x.right));
        return x;
      
    }
    return root;
}
    Node leftRotation(Node x){
        Node y = x.right;
        Node T2 = y.left;
        y.left = x;
        x.right = T2;
        x.height = 1+Math.max(getHeight(x.left), getHeight(x.right));
        y.height = 1+Math.max(getHeight(y.left), getHeight(y.right));
        return y;
    }

    
}
    int getHeight(Node node){
        if(node ==  null){
            return 0; 
        }
        return node.height; 
    }

    int getBalanceFactor(Node node){
        if(node == null){
            return 0;
        }
        return node.left.height - node.right.height;
    }
}
