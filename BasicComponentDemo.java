package TestDemos;

import javax.swing.*;
import java.awt.*;

public class BasicComponentDemo {

    Frame frame=new Frame("这里测试基本组件");

    TextArea ta=new TextArea(5,20);

    Choice colorChooser=new Choice();

    CheckboxGroup cbg=new CheckboxGroup();
    Checkbox male=new Checkbox("男",cbg,true);
    Checkbox female=new Checkbox("女",cbg,false);

    Checkbox isMarried=new Checkbox("是否已婚？");

    TextField tf=new TextField(20);
    Button ok=new Button("确认按钮");

    List colorList =new List(6,true);


    public void init(){
        //组装界面


        //组装底部
        Box bBox=Box.createHorizontalBox();
        bBox.add(tf);
        bBox.add(ok);

        frame.add(bBox,BorderLayout.SOUTH);


        //组装 选择部分
      colorChooser.add("red");
      colorChooser.add("blue");
      colorChooser.add("yellow");
      Box hBox2=Box.createHorizontalBox();
      hBox2.add(colorChooser);
      hBox2.add(male);
      hBox2.add(female);
      hBox2.add(isMarried);

      Box vBox=Box.createVerticalBox();
      vBox.add(ta);
      vBox.add(hBox2);

      Box dBox=Box.createHorizontalBox();
      dBox.add(vBox);
      colorList.add("红色");
      colorList.add("绿色");
      colorList.add("蓝色");
      dBox.add(colorList);

      //
        frame.add(dBox);
      frame.pack();
      frame.setVisible(true);
    }



    public static void main(String[] args) {
        new BasicComponentDemo().init();

    }
}
