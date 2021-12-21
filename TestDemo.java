public class TestDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree=new BinaryTree();
        TreeNode root=binaryTree.createTree();




        System.out.println("后序：");
        binaryTree.postOrderTraversal(root);
        System.out.println("");


    }
}
