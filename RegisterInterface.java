package ui;


import javafx.scene.layout.Background;
import uitl.ScreenUtils;
import component.BankGroundPanel;



import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class RegisterInterface {


    JFrame jf=new JFrame("注册");

    final int WIDTH=500;
    final int HEIGHT=400;






    //组装视图
   public void init() throws Exception {

       //设置窗口的属性
       jf.setBounds((ScreenUtils.getScreenWith()-WIDTH)/2,(ScreenUtils.getScreenHeight()-HEIGHT)/2,WIDTH,HEIGHT);
       jf.setResizable(false);

           jf.setIconImage(ImageIO.read(new File("src\\images\\bank.png" )));
           BankGroundPanel bgPanel=new BankGroundPanel(ImageIO.read(new File("src\\images\\fishs.png")));
           bgPanel.setBounds(0,0,WIDTH,HEIGHT);






           Box vBox=Box.createVerticalBox();


           //组装用户名
           Box uBox=Box.createHorizontalBox();
           JLabel uLabel=new JLabel("用户名：");
           JTextField uField=new JTextField(10);

          uBox.add(uLabel);
           uBox.add(Box.createHorizontalStrut(20));
           uBox.add(uField);

           //组装密码
       Box zBox=Box.createHorizontalBox();
      JLabel zLabel=new JLabel("密     码：");
       JTextField zField=new JTextField(10);

       zBox.add(zLabel);
       zBox.add(Box.createHorizontalStrut(20));
       zBox.add(zField);

       //组装手机号
       Box hBox=Box.createHorizontalBox();
       JLabel hLabel=new JLabel("手机号：");
       JTextField hField=new JTextField(10);

       hBox.add(hLabel);
       hBox.add(Box.createHorizontalStrut(20));
       hBox.add(hField);

       //组装性别
       Box lBox=Box.createHorizontalBox();
       JLabel lLabel=new JLabel("性    别：");
           ButtonGroup bg=new ButtonGroup();
        JRadioButton male=new JRadioButton("男",true);
       JRadioButton female=new JRadioButton("女",false);

       bg.add(male);
       bg.add(female);

       lBox.add(lLabel);
       lBox.add(Box.createHorizontalStrut(20));
       lBox.add(male);
       lBox.add(female);
       lBox.add(Box.createHorizontalStrut(120));

       Box mBox=Box.createHorizontalBox();
       JLabel mLabel=new JLabel("验证码：");
       JTextField mField=new JTextField(4);
       mBox.add(mLabel);
       mBox.add(Box.createHorizontalStrut(20));
       mBox.add(mField);


       Box btnBox=Box.createHorizontalBox();
       JButton regisBtn=new JButton("注册");
       JButton backBtn=new JButton("返回登录页面");

       regisBtn.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               //获取用户输入的信息
               String username=uField.getText().trim();
               String password=zField.getText().trim();
               String phone=hField.getText().trim();

               //访问后台接口
               JOptionPane.showMessageDialog(jf,"注册成功，即将返回登录页面！！");
               try {
                   new MainInterFace().init();
                   jf.dispose();
               } catch (Exception exception) {
                   exception.printStackTrace();
               }
           }
       });

       backBtn.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               //返回到登录页面即可
               try {
                   new MainInterFace().init();
                   jf.dispose();
               } catch (Exception exception) {
                   exception.printStackTrace();
               }
           }
       });



       btnBox.add(regisBtn);
       btnBox.add(Box.createHorizontalStrut(80));
       btnBox.add(backBtn);






       vBox.add(Box.createVerticalStrut(40));
       vBox.add(uBox);
       vBox.add(Box.createVerticalStrut(20));
       vBox.add(zBox);
       vBox.add(Box.createVerticalStrut(20));
       vBox.add(hBox);
       vBox.add(Box.createVerticalStrut(20));
       vBox.add(lBox);
       vBox.add(Box.createVerticalStrut(20));
       vBox.add(mBox);
       vBox.add(Box.createVerticalStrut(20));
       vBox.add(btnBox);

       bgPanel.add(vBox);

      jf.add(bgPanel);



           jf.setVisible(true);

   }


    public static void main(String[] args) throws Exception {
        new RegisterInterface().init();
    }
}
