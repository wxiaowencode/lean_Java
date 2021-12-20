
//��������ǰ�����
public void preOrderTraversal(TreeNode root){
        if(root==null){
            return;
        }
        System.out.print(root.val+" ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

//���������������
public void inOrderTraversal(TreeNode root){
        if(root==null){
            return;
        }
        preOrderTraversal(root.left);
        System.out.print(root.val+" ");
        preOrderTraversal(root.right);
    }
//�������ĺ������
public void postOrderTraversal(TreeNode root){
        if(root==null){
            return;
        }
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
        System.out.print(root.val+" ");
    }

//�������ķǵݹ�ǰ�������������
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
//�������ķǵݹ��������
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
            node=stack.pop();//���Ϊ�գ��͵õ�ջ�������ĸ��ڵ�
            res.add(node.val); 
            node=node.right;
        }
        return res;
    }
}


//�������ķǵݹ�������
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

    //����˼·����ڵ����
    static int size=0;
    void getSize(TreeNode root){
        if(root==null){
            return;
        }
        size++;
        getSize(root.left);
        getSize(root.right);
    }


    //�����⣺��ڵ�ĸ���
    int getSize2(TreeNode root){
        if(root==null){
            return 0;
        }
        return getSize2(root.left)+getSize2(root.right)+1;
    }


    //����˼·����Ҷ�ӽڵ����
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




    //������˼·����Ҷ�ӽڵ����
    int getLeafSize2(TreeNode root){
        if(root==null){
            return 0;
        }
        if(root.left==null && root.right==null){
          return 1;
        }
        return getLeafSize2(root.left)+getLeafSize2(root.right);
    }

    //������:���k��ڵ����

    int getKLevelSize(TreeNode root,int k){
        if(root==null){
            return 0;
        }
        //ѭ����ֹ����
        if(k==1){
            return 1;
        }
        return getKLevelSize(root.left,k-1)+getKLevelSize(root.right,k-1);
    }


   //�ҵ�ĳ��ֵ
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

    //��ȡ�������ĸ߶�
     int getHeight(TreeNode root){
        if(root==null){
            return 0;
        }
        return Math.max(getHeight(root.left),getHeight(root.right))+1;
    }

 //����������
 public class Solution {
    /**
     * �����е����������������������Ѿ�ָ���������޸ģ�ֱ�ӷ��ط����涨��ֵ����
     *
     * 
     * @param pRoot TreeNode�� 
     * @return TreeNode��
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

    //����������������У�
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

 //�����������������+��ÿһ������ڵ㶼�ŵ�һ��list��  leetcode��Ŀ��
     public List<List<Integer>> levelOrder(TreeNode root){
        //ֻ��Ϊ����������Ҫ��
        List<List<Integer>> res=new ArrayList<>();
        if(root==null){
            return null;
        }

        //���е�����������ʵ�ֲ�������ġ�
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            //size�Ĵ�С����һ��
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

