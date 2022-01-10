class TreeNode{
      public char val;
      public TreeNode left;
      public TreeNode right;
      public TreeNode(char val){
          this.val=val;
      }
      public TreeNode(){

      }
}
public class BinaryTree {

    //比较low的创建方法-穷举法
    public TreeNode createTree(){
        TreeNode A=new TreeNode('A');
        TreeNode B=new TreeNode('B');
        TreeNode C=new TreeNode('C');
        TreeNode D=new TreeNode('D');
        TreeNode E=new TreeNode('E');
        TreeNode F=new TreeNode('F');
        TreeNode H=new TreeNode('H');
        TreeNode I=new TreeNode('I');
        TreeNode G=new TreeNode('G');
        A.left=B;
        A.right=C;
        B.left=D;
        B.right=E;
        C.left=F;
        C.right=G;
        E.right=H;
        return A;
    }

    //前序遍历
    public void preOrderTraversal(TreeNode root){
        if(root==null) return;
        System.out.print(root.val+" ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }


    //中序遍历
    public void inOrderTraversal(TreeNode root){
        if(root==null){
            return;
        }
        preOrderTraversal(root.left);
        System.out.print(root.val+" ");
        preOrderTraversal(root.right);
    }

    //后序遍历
    public void postOrderTraversal(TreeNode root){
        if(root==null){
            return;
        }
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
        System.out.print(root.val+" ");
    }
    public static void main(String[] args) {
     //todo
    }
}
