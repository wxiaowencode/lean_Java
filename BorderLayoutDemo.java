import java.awt.*;

public class BorderLayoutDemo {
    public static void main(String[] args) {
        Frame frame=new Frame("这里测试BorderLayout布局管理");
        //1.给frame设置布局管理器

        frame.setLayout(new BorderLayout(30,30));
        //2在frame指定的区域添加组件
        frame.add(new Button("北侧按钮"),BorderLayout.NORTH);
        frame.add(new Button("东侧按钮"),BorderLayout.EAST);
        frame.add(new Button("西侧按钮"),BorderLayout.WEST);
        frame.add(new Button("南侧按钮"),BorderLayout.SOUTH);

        Panel p=new Panel();
        p.add(new Button("中间按钮"),BorderLayout.CENTER);
        p.add(new TextField("这是文本框"));
        frame.add(p);

         frame.pack();
        frame.setVisible(true);
    }
}
