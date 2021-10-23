package 树;


class TreeNode{
    public char val;
    public TreeNode left;
    public TreeNode right;



    public TreeNode(char val){
        this.val=val;
    }
}







public class BinaryTree {
    public TreeNode createTree(){
        TreeNode A =new TreeNode('A');
        TreeNode B =new TreeNode('B');
        TreeNode C =new TreeNode('C');
        TreeNode D =new TreeNode('D');
        TreeNode E =new TreeNode('E');
        TreeNode F =new TreeNode('F');
        TreeNode G =new TreeNode('G');
        TreeNode H =new TreeNode('H');
        A.left=B;
        A.right=C;
        B.left=D;
        B.right=E;
        C.left=F;
        C.right=G;
        C.right=H;
        E.right=H;
        return A;
    }
    //前序遍历

    void preOrderTraversal(TreeNode root){
        if(root == null){
            return;
        }
        System.out.print(root.val+" ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    //后序遍历
    void postOrderTraversal(TreeNode root){
        if(root ==null ){
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
    }

    //子问题思路-求结点个数
    int getSize2(TreeNode root){
        if(root == null){
            return 0;
        }
        return getSize2(root.left)+getSize2(root.right)+1;
    }
}
