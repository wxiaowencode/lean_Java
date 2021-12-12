package TestDemos;

import java.awt.*;

public class ScrollPaneDemo {
    public static void main(String[] args) {
        //创建窗口
        Frame frame=new Frame("这是一个新的窗口");

        //1.创建一个ScrollPane对象
        ScrollPane scrollPane=new ScrollPane(ScrollPane.SCROLLBARS_ALWAYS);
        //2.往ScrollPane中添加内容
        scrollPane.add(new TextField("这是文本框！"));
        scrollPane.add(new Button("这是一个按钮！"));
        //3.将ScrollPane对象添加到窗口中
        frame.add(scrollPane);


        //设置位置及大小
        frame.setBounds(200,300,500,600);
        //设置可见
        frame.setVisible(true);
    }
}
