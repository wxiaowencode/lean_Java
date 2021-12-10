import java.awt.*;
import javax.swing.*;
public class BoxLayoutDemo {
    public static void main(String[] args) {
        Frame frame=new Frame("这是一个frame容器");
        //1.基于frame容器，创建一个BoxLayout对象，并且，该对象存放组件是垂直存放
      BoxLayout boxLayout=new BoxLayout(frame,BoxLayout.X_AXIS);

   frame.setLayout(boxLayout);
        //2.把BoxLayout对象设置给frame

        //3.向frame中添加两个按钮
        frame.add(new Button("按钮1"));
        frame.add(new Button("按钮2"));

        frame.pack();
        frame.setVisible(true);
    }
}
