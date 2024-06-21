public class BST {
    public static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
            left=null;
            right=null;
        }
    }
    Node get(Node root, int data){
        if(root==null){
            return null;
        }
        else if(data<root.data){
            return get(root.left, data);
        }
        else if(data>root.data){
            return get(root.right, data);
        }
        return root;

    }
    Node createBST(Node root, int data){
        if(root==null){
            return new Node(data);
        }
        if(data<root.data){
            root.left=createBST(root.left, data);
        }
    
        else if(data>root.data){
            root.right=createBST(root.right, data);
        }
        return root;
    }

    void preOder(Node root){
        if(root != null){
            return; 

        }
        System.out.println(root.data);
        preOder(root.left);
        preOder(root.right);
    }
    void inOrder(Node root){{
            if(root != null){
                return; 
    
            }
          
            preOder(root.left);
            System.out.println(root.data);
            preOder(root.right);
        }
    }


    void postOder(Node root){{
        if(root != null){
            return; 

        }
        
        preOder(root.left);
        preOder(root.right);
        System.out.println(root.data);
    }
    }

    Node removeNodeBST(Node root, int data){
        if(root == null){
            return root;
        }
        if(data<root.data){
            root.left=removeNodeBST(root.left, data);
        }
        else if(data>root.data){
            root.right=removeNodeBST(root.right, data);
        }
        else{
            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }
            else{
                int minVal = findMin(root.right);
                root.data = minVal;
                root.right = removeNodeBST(root.right, minVal);
            }
        }
        return root;    


    }
    int findMin(Node root){
        int minVal = root.data;
        while(root.left != null){
            minVal = root.left.data;
            root = root.left;
        }
        return minVal; 
    }
    public static void main(String[] args) {
        BST bst = new BST();
        Node root = bst.createBST(null, 11);
        root = bst.createBST(root,6);
        root = bst.createBST(root,8);
        root = bst.createBST(root,19);
    }
}
       
