package ui;

import component.PersonMessageDialog;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class ManagerInterface {
    JFrame jf=new JFrame("银行管理系统");

    public void init() throws IOException {
        //窗口属性
        jf.setSize(1000,600);//设置大小
        jf.setLocationRelativeTo(null);//居中显示
        jf.setResizable(false);
        jf.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        jf.setIconImage(ImageIO.read(new File("src\\images\\bank.png" )));

        //设置菜单栏
        JMenuBar jmb=new JMenuBar();
        JMenu jMenu=new JMenu("系统");
        JMenuItem m1=new JMenuItem("退出系统");
        JMenuItem m2=new JMenuItem("退出登录");
        JMenuItem m3=new JMenuItem("切换账号");
        m3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new MainInterFace().init();
                    jf.dispose();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
        m2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new MainInterFace().init();
                    jf.dispose();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

        m1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        jMenu.add(m1);
        jMenu.add(m2);
        jMenu.add(m3);
        jmb.add(jMenu);
        jf.setJMenuBar(jmb);

        //设置分割面板
        JSplitPane sp=new JSplitPane();

        //支持连续布局
        sp.setContinuousLayout(true);
        sp.setDividerLocation(150);
        sp.setDividerSize(7);

        //设置左侧内容
        DefaultMutableTreeNode root=new DefaultMutableTreeNode("用户管理");
        DefaultMutableTreeNode personManage=new DefaultMutableTreeNode("个人信息");
        DefaultMutableTreeNode depositManage=new DefaultMutableTreeNode("存款");
        DefaultMutableTreeNode withdrawManage=new DefaultMutableTreeNode("取款");
        DefaultMutableTreeNode transferManage=new DefaultMutableTreeNode("转账");
        DefaultMutableTreeNode recordManage=new DefaultMutableTreeNode("交易记录");
        DefaultMutableTreeNode exitManage=new DefaultMutableTreeNode("退出登录");

        root.add(personManage);
        root.add(depositManage);
        root.add(withdrawManage);
        root.add(transferManage);
        root.add(recordManage);
        root.add(exitManage);


        Color color=new Color(203, 220, 217);
        JTree tree=new JTree(root);
        MyRenderer myRenderer=new MyRenderer();
        myRenderer.setBackgroundNonSelectionColor(color);

        myRenderer.setBackgroundSelectionColor(new Color(140, 140, 140));
        tree.setCellRenderer(myRenderer);

        //设置当前tree默认个人信息
        tree.setSelectionRow(2);
        sp.setRightComponent(new PersonMessageDialog(jf));
        tree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                //得到当前选中的节点对象
                Object lastPathComponent=e.getNewLeadSelectionPath().getLastPathComponent();
                if(personManage.equals(lastPathComponent)){
                    sp.setRightComponent(new PersonMessageDialog(jf));
                    sp.setDividerLocation(150);
                }else if(depositManage.equals(lastPathComponent)){
                    sp.setRightComponent(new JLabel("这里进行存款操作"));
                    sp.setDividerLocation(150);
                }if(withdrawManage.equals(lastPathComponent)){
                    sp.setRightComponent(new JLabel("这里进行取款操作"));
                    sp.setDividerLocation(150);
                }if(transferManage.equals(lastPathComponent)){
                    sp.setRightComponent(new JLabel("这里进行转账操作"));
                    sp.setDividerLocation(150);
                }if(recordManage.equals(lastPathComponent)){
                    sp.setRightComponent(new JLabel("这里显示交易记录"));
                    sp.setDividerLocation(150);
                }if(exitManage.equals(lastPathComponent)){
                    sp.setRightComponent(new JLabel("这里可以退出系统"));
                    sp.setDividerLocation(150);
                }
            }
        });

        tree.setBackground(color);
        sp.setLeftComponent(tree);

        jf.add(sp);




        jf.setVisible(true);
    }

    //自定义节点绘制器
    private class MyRenderer extends DefaultTreeCellRenderer {
        private  ImageIcon rootIcon=null;
        private  ImageIcon personManageIcon=null;
        private  ImageIcon depositManageIcon=null;
        private  ImageIcon withdrawManageIcon=null;
        private  ImageIcon transferManageIcon=null;
        private  ImageIcon recordManageIcon=null;
        private  ImageIcon exitManageIcon=null;

        public MyRenderer(){

            rootIcon=new ImageIcon("src\\images\\source.png");
            personManageIcon=new ImageIcon("src\\images\\open.png");
            depositManageIcon=new ImageIcon("src\\images\\book.png");
            withdrawManageIcon=new ImageIcon("src\\images\\books.png");
            transferManageIcon=new ImageIcon("src\\images\\more.png");
            recordManageIcon=new ImageIcon("src\\images\\source.png");
           exitManageIcon=new ImageIcon("src\\images\\stream.png");

        }
        @Override
        public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
            //使用默认绘制
            super.getTreeCellRendererComponent(tree,value,sel,expanded,leaf,row,hasFocus);


            ImageIcon image=null;
            switch (row){
                case 0:
                    image=rootIcon;

                    break;
                case 1:
                    image=personManageIcon;
                    break;
                case 2:
                    image=depositManageIcon;
                    break;
                case 3:
                    image=withdrawManageIcon;
                    break;
                case 4:
                    image=transferManageIcon;
                    break;
                case 5:
                    image=recordManageIcon;
                    break;
                case 6:
                    image= exitManageIcon;
                    break;
            }
            image.setImage(image.getImage().getScaledInstance(22,22,Image.SCALE_DEFAULT));
            this.setIcon(image);
            return this;
        }
    }

    public static void main(String[] args) throws IOException {
        new ManagerInterface().init();
    }
}
