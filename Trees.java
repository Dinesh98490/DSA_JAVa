public class Trees {
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
   public static void main(String[] args) {
     Node root = new Node(10);
     root.left = new Node(20);
     root.right = new Node(30);
     root.left.left = new Node(40);
     
   }
    
}
