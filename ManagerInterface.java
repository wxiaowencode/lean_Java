package ui;

import component.BookManageComponent;
import uitl.ScreenUtils;

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

public class ManagerInterface {
    JFrame jf=new JFrame("新城图书馆：XXX，欢迎您！");

    final int WIDTH=1000;
    final int HEIGHT=600;

    //组装视图
    public void init() throws Exception {
        //给窗口设置属性

        jf.setBounds((ScreenUtils.getScreenWith()-WIDTH)/2,(ScreenUtils.getScreenHeight()-HEIGHT)/2,WIDTH,HEIGHT);
        jf.setResizable(false);
        jf.setIconImage(ImageIO.read(new File("src\\images\\bank.png")));

        //设置菜单栏
        JMenuBar jmb=new JMenuBar();
        JMenu jMenu=new JMenu("设置");
        JMenuItem m1=new JMenuItem("切换账号");
        JMenuItem m2=new JMenuItem("退出程序");
        m1.addActionListener(new ActionListener() {
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
                System.exit(0);
            }
        });


        jMenu.add(m1);
        jMenu.add(m2);
        jmb.add(jMenu);
        jf.setJMenuBar(jmb);

        //设置分割面板
        JSplitPane sp=new JSplitPane();

        //支持连续布局
        sp.setContinuousLayout(true);
        sp.setDividerLocation(150);
        sp.setDividerSize(7);

        //设置左侧内容
        DefaultMutableTreeNode root=new DefaultMutableTreeNode("系统管理");
        DefaultMutableTreeNode userManage=new DefaultMutableTreeNode("用户管理");
        DefaultMutableTreeNode bookManage=new DefaultMutableTreeNode("图书管理");
        DefaultMutableTreeNode borrowManage=new DefaultMutableTreeNode("借阅管理");
        DefaultMutableTreeNode statisticsManage=new DefaultMutableTreeNode("统计分析");

        root.add(userManage);
        root.add(bookManage);
        root.add(borrowManage);
        root.add(statisticsManage);

        Color color=new Color(203, 220, 217);
        JTree tree=new JTree(root);
        MyRenderer myRenderer=new MyRenderer();
        myRenderer.setBackgroundNonSelectionColor(color);

        myRenderer.setBackgroundSelectionColor(new Color(140, 140, 140));
        tree.setCellRenderer(myRenderer);

        //设置当前tree默认图书管理
        tree.setSelectionRow(2);
        sp.setRightComponent(new BookManageComponent(jf));
        tree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                //得到当前选中的节点对象
                Object lastPathComponent=e.getNewLeadSelectionPath().getLastPathComponent();
                if(userManage.equals(lastPathComponent)){
                    sp.setRightComponent(new JLabel("这里进行用户管理"));
                    sp.setDividerLocation(150);
                }else if(bookManage.equals(lastPathComponent)){
                    sp.setRightComponent(new BookManageComponent(jf));
                    sp.setDividerLocation(150);
                }if(borrowManage.equals(lastPathComponent)){
                    sp.setRightComponent(new JLabel("这里进行借阅管理"));
                    sp.setDividerLocation(150);
                }if(statisticsManage.equals(lastPathComponent)){
                    sp.setRightComponent(new JLabel("这里进行统计分析"));
                    sp.setDividerLocation(150);
                }
            }
        });

        tree.setBackground(color);
       sp.setLeftComponent(tree);

        jf.add(sp);




        jf.setVisible(true);
    }





    public static void main(String[] args) {
        try {
            new ManagerInterface().init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//自定义节点绘制器
    private class MyRenderer extends DefaultTreeCellRenderer{
        private  ImageIcon userManageIcon=null;
        private  ImageIcon bookManageIcon=null;
        private  ImageIcon borrowManageIcon=null;
        private  ImageIcon statisticsManageIcon=null;
        private  ImageIcon rootIcon=null;

        public MyRenderer(){

                rootIcon=new ImageIcon("src\\images\\source.png");
                userManageIcon=new ImageIcon("src\\images\\open.png");
                bookManageIcon=new ImageIcon("src\\images\\book.png");
                borrowManageIcon=new ImageIcon("src\\images\\books.png");
                statisticsManageIcon=new ImageIcon("src\\images\\more.png");
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
                    image=userManageIcon;
                    break;
                case 2:
                    image=bookManageIcon;
                    break;
                case 3:
                    image=borrowManageIcon;
                    break;
                case 4:
                    image=statisticsManageIcon;
                    break;
            }
            image.setImage(image.getImage().getScaledInstance(22,22,Image.SCALE_DEFAULT));
            this.setIcon(image);
            return this;
        }
    }
}
