import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FileDialogTestDemo {
    public static void main(String[] args) {
        Frame frame=new Frame("这是一个窗口");

        FileDialog f1=new FileDialog(frame,"选择要打开的文件",FileDialog.LOAD);
        FileDialog f2=new FileDialog(frame,"选择要保存的文件",FileDialog.SAVE);

        Button b1=new Button("打开文件");
        Button b2=new Button("保存文件");

       b1.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               f1.setVisible(true); //在选择文件之前，代码会阻塞等待
               String directory=f1.getDirectory();
               String file=f1.getFile();
               System.out.println("打开的文件名："+directory);
               System.out.println("打开的文件名称为："+file);
           }
       });
       b2.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               f2.setVisible(true);

               //获取选择的文件和路径
               String directory=f2.getDirectory();
               String file=f2.getFile();
               System.out.println("保存的文件路径为："+directory);
               System.out.println("保存的文件名称为："+file);
           }
       });
       frame.add(b1,BorderLayout.NORTH);
       frame.add(b2);

        frame.pack();
        frame.setVisible(true);
    }
}
