import java.util.*;

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
        if(root==null){
            return;
        }
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




















//    //前序遍历
//    void preOrderTraversal(TreeNode root){
//        if(root==null){
//            return;
//        }
//        System.out.println(root.val+" ");
//        preOrderTraversal(root.left);
//        preOrderTraversal(root.right);
//    }
//
//    //中序遍历
//    void inOrderTraversal(TreeNode root){
//        if(root==null){
//            return;
//        }
//        preOrderTraversal(root.left);
//        System.out.println(root.val+" ");
//        preOrderTraversal(root.right);
//    }
//
//    //后序遍历
//    void postOrderTraversal(TreeNode root){
//        if(root==null){
//            return;
//        }
//        preOrderTraversal(root.left);
//        preOrderTraversal(root.right);
//        System.out.println(root.val+" ");
//    }

    //遍历思路：求节点个数
    static int size=0;
    void getSize(TreeNode root){
        if(root==null){
            return;
        }
        size++;
        getSize(root.left);
        getSize(root.right);
    }


    //子问题：求节点的个数
    int getSize2(TreeNode root){
        if(root==null){
            return 0;
        }
        return getSize2(root.left)+getSize2(root.right)+1;
    }


    //遍历思路：求叶子节点个数
    static int leafSize=0;
    void getLeafSize1(TreeNode root){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            leafSize++;
        }
        getLeafSize1(root.left);
        getLeafSize1(root.right);
    }



    //子问题思路：求叶子节点个数
    int getLeafSize2(TreeNode root){
        if(root==null){
            return 0;
        }
        if(root.left==null && root.right==null){
          return 1;
        }
        return getLeafSize2(root.left)+getLeafSize2(root.right);
    }

    //子问题:求第k层节点个数

    int getKLevelSize(TreeNode root,int k){
        if(root==null){
            return 0;
        }
        //循环终止条件
        if(k==1){
            return 1;
        }
        return getKLevelSize(root.left,k-1)+getKLevelSize(root.right,k-1);
    }


   //找到某个值
    TreeNode find(TreeNode root,char val){
        if(root ==null){
            return null;
        }
        if(root.val==val){
            return root;
        }

         TreeNode ret=find(root.left,val);
        if(ret!=null){
            return ret;
        }

         ret=find(root.right,val);
        if(ret!=null){
            return ret;
        }

        return null;
    }

    //获取二叉树的高度
     int getHeight(TreeNode root){
        if(root==null){
            return 0;
        }
        return Math.max(getHeight(root.left),getHeight(root.right))+1;
    }

    //层序遍历
    void levelOrderTraversal(TreeNode root){
        if(root ==null){
            return;
        }
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode top=queue.poll();
            System.out.print(top.val+" ");
            if(top.left!=null){
                queue.offer(top.left);
            }
            if(top.right!=null){
                queue.offer(top.right);
            }
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root){
        //只是为了满足结果的要求
        List<List<Integer>> res=new ArrayList<>();
        if(root==null){
            return null;
        }

        //队列的作用是用来实现层序遍历的。
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            //size的大小就是一层
            int size=queue.size();
            List<TreeNode> list=new ArrayList<>();
            while(size!=0){
                TreeNode top=queue.poll();
          //     list.add(top.val);
                if(top.left!=null){
                    queue.offer(top.left);
                }
                if(top.right!=null){
                    queue.offer(top.right);
                }
                size--;
            }
           // res.add(list);
        }
        return null;
    }


    //判断一棵树是不是完全二叉树
    boolean isCompleteTree(TreeNode root){
        if(root ==null) return true;
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode top=queue.poll();
            if(top!=null){
                queue.offer(top.left);
                queue.offer(top.right);
            }else{
                break;
            }
        }
        while (!queue.isEmpty()){
            TreeNode cur=queue.peek();
            if(cur==null){
                queue.poll();
            }else{
                return false;
            }
        }
        return true;
    }

    //前序遍历非递归
    void preOrderTraversalNor(TreeNode root){
        if(root==null) return;
        TreeNode cur=root;
        Stack<TreeNode> stack=new Stack<>();
        while(cur!=null){
            stack.push(cur);
            System.out.println(cur.val+" ");
            cur=cur.left;
        }
        TreeNode node=stack.pop();

    }
    //中序遍历非递归
    void inOrderTraversalNor(TreeNode root){
        if(root==null) return;
        TreeNode cur=root;
        Stack<TreeNode> stack=new Stack<>();
        while(cur!=null || !stack.empty()){
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            TreeNode top=stack.pop();
            System.out.println(top.val+" ");
            cur=top.right;
        }

    }

    //后序遍历非递归
    void postOrderTraversalNor(TreeNode root){
        if(root==null) return;
        TreeNode cur=root;
        TreeNode pre=null;
        Stack<TreeNode> stack=new Stack<TreeNode>();
        while(cur!=null || !stack.empty()){
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            cur=stack.peek();
            if(cur.right==null || cur.right==pre){
                TreeNode popNode=stack.pop();
                System.out.println(popNode.val+" ");
                pre=cur;
                cur=null;
            }else{
                cur=cur.right;
            }
        }
    }


















    public static void main(String[] args) {
        TreeNode root=new TreeNode();

    }
}









