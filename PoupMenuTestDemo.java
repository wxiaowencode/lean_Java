package TestDemos;

import java.awt.*;
import java.awt.event.*;

public class PoupMenuTestDemo {
    private Frame frame=new Frame("这里测试PopupMenu");


    //创建文本域
    TextArea ta=new TextArea("我爱编程！！",6,40);

    //创建Panel容器
    Panel p=new Panel();

    //创建PopupMenu
    PopupMenu popupMenu=new PopupMenu();

    //创建菜单项
    MenuItem comment=new MenuItem("注释");
    MenuItem cancelComment=new MenuItem("取消注释");
    MenuItem copy=new MenuItem("复制");
    MenuItem save=new MenuItem("注释");


    public void init(){


        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        //组装视图

        ActionListener listener=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String actionCommand=e.getActionCommand();
                ta.append("您点击了："+actionCommand+"\n");
            }
        };

        comment.addActionListener(listener);
        cancelComment.addActionListener(listener);
        copy.addActionListener(listener);
        save.addActionListener(listener);

        popupMenu.add(cancelComment);
        popupMenu.add(comment);
        popupMenu.add(copy);
        popupMenu.add(save);

        p.add(popupMenu);

        //设置Panel的大小
        p.setPreferredSize(new Dimension(100,200));


        //给Panel注册鼠标事件，监听用户释放鼠标的动作，展示菜单
        p.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                boolean flg=e.isPopupTrigger();
                if(flg){
                    //显示PopupMenu
                    popupMenu.show(p,e.getX(),e.getY());
                }
            }
        });

        //放置ta和p
        frame.add(ta,BorderLayout.NORTH);
        frame.add(p, BorderLayout.SOUTH);

        //设置frame最佳大小
        frame.pack();
        frame.setVisible(true);
    }


    public static void main(String[] args) {
        new PoupMenuTestDemo().init();
    }
}
