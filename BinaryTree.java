
//二叉树的前序遍历
public void preOrderTraversal(TreeNode root){
        if(root==null){
            return;
        }
        System.out.print(root.val+" ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

//二叉树的中序遍历
public void inOrderTraversal(TreeNode root){
        if(root==null){
            return;
        }
        preOrderTraversal(root.left);
        System.out.print(root.val+" ");
        preOrderTraversal(root.right);
    }
//二叉树的后序遍历
public void postOrderTraversal(TreeNode root){
        if(root==null){
            return;
        }
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
        System.out.print(root.val+" ");
    }

//二叉树的非递归前序遍历（迭代）
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                res.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return res;
    }
}
//二叉树的非递归中序遍历
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<Integer>();
        if(root==null){
            return res;
        }
        Deque<TreeNode> stack=new LinkedList<TreeNode>();
        TreeNode node=root;
        while(!stack.isEmpty() || node!=null){
            while(node!=null){
                stack.push(node);
                node=node.left;   
            }
            node=stack.pop();//左边为空，就得到栈顶子树的根节点
            res.add(node.val); 
            node=node.right;
        }
        return res;
    }
}


//二叉树的非递归后序遍历
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<Integer>();
        if(root==null){
            return res;
        }
        Deque<TreeNode> stack=new LinkedList<TreeNode>();
        TreeNode node=null;
        while(root!=null || !stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root=root.left;
            }  
            root=stack.pop();
            if(root.right==null || root.right==node){
                res.add(root.val);
                node=root;
                root=null;
            }else{
                stack.push(root);
                root=root.right;
            }
        }
        return res;
    }
}

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

 //二叉树镜像
 public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param pRoot TreeNode类 
     * @return TreeNode类
     */
    public TreeNode Mirror (TreeNode pRoot) {
        // write code here
        if(pRoot==null || (pRoot.left==null && pRoot.right==null)){
            return pRoot;
        }
        TreeNode temp=pRoot.left;
        pRoot.left=pRoot.right;
        pRoot.right=temp;
        Mirror(pRoot.left);
        Mirror(pRoot.right);
        return pRoot;
    }
}

    //层序遍历（借助队列）
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

 //层序遍历（借助队列+将每一层的树节点都放到一个list中  leetcode题目）
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
               list.add(top.val);
                if(top.left!=null){
                    queue.offer(top.left);
                }
                if(top.right!=null){
                    queue.offer(top.right);
                }
                size--;
            }
            res.add(list);
        }
        return null;
    }

