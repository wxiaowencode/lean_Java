package TestDemos;

import javax.swing.*;
import java.awt.*;

public class BoxLayoutDemo2 {
    public static void main(String[] args) {
        Frame frame=new Frame("这是一个新的窗口");
        //1.创建一个水平的容器
        Box hBox=Box.createHorizontalBox();

        //2.往该容器中添加两个按钮
        hBox.add(new Button("水平按钮1"));
        hBox.add(new Button("水平按钮2"));
        //3.创建一个垂直的容器
        Box vBox=Box.createVerticalBox();
        //4.往该容器中添加两个按钮
        vBox.add(new Button("垂直按钮1"));
        vBox.add(new Button("垂直按钮2"));
        //5.将这两个容器添加到frame容器中
        frame.add(hBox,BorderLayout.NORTH);
        frame.add(vBox);

        frame.pack();
        frame.setVisible(true);
    }
}
