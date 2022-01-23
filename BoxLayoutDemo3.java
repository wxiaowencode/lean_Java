package TestDemos;

import javax.swing.*;
import java.awt.*;

public class BoxLayoutDemo3 {
    public static void main(String[] args) {
        Frame frame=new Frame();

        //1.创建一个水平box容器，里面添加两个按钮和两个水平空格
        Box hBox=Box.createHorizontalBox();
        hBox.add(new Button("水平按钮1"));
        hBox.add(Box.createHorizontalBox());
        hBox.add(new Button("水平按钮2"));
        hBox.add(Box.createHorizontalStrut(30));
        hBox.add(new Button("水平按钮3"));
        //2.将该容器放到frame容器北。
        frame.add(hBox,BorderLayout.NORTH);
        //3.创建一个垂直box容器，里面添加三个按钮，和两个水平空格。
        Box vBox=Box.createVerticalBox();
         vBox.add(new Button("垂直按钮1"));
        vBox.add(Box.createVerticalStrut(30));
         vBox.add(new Button("垂直按钮2"));
        vBox.add(Box.createVerticalBox());
         vBox.add(new Button("垂直按钮3"));
        //4.将该容器放到frame南。
        frame.add(vBox,BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
    }
}
