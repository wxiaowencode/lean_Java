




import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;
import java.io.IOException;

public class RegisterInterface {

    JFrame jf=new JFrame("注册");

    public void init() throws IOException {
        jf.setSize(500,300);
        jf.setLocationRelativeTo(null);
        jf.setResizable(false);
        jf.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        jf.setIconImage(ImageIO.read(new File("src\\images\\bank.png" )));
        BankGroundPanel bgPanel=new BankGroundPanel(ImageIO.read(new File("src\\images\\fish.png")));
        bgPanel.setBounds(0,0,500,300);

        Box vBox=Box.createVerticalBox();
        //账号
        Box uBox=Box.createHorizontalBox();
        JLabel uLabel=new JLabel("新用户名：");
        JTextField uField=new JTextField(10);
        uBox.add(uLabel);
        uBox.add(Box.createHorizontalStrut(10));
        uBox.add(uField);
        //密码
        Box zBox=Box.createHorizontalBox();
        JLabel zLabel=new JLabel("密     码：");
        JPasswordField zField=new JPasswordField(10);
        zBox.add(zLabel);
        zBox.add(Box.createHorizontalStrut(20));
        zBox.add(zField);

        Box btnBox=Box.createHorizontalBox();
        JButton regisBtn=new JButton("注册");
        JButton backBtn=new JButton("返回登录页面");

        regisBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //获取用户输入的信息
                String message[]=new String[2];
                message[0]=uField.getText();//获取账号
                message[1]=zField.getText();//获取密码
                if(! UserMessage.checkName(message[0])){
                    UserMessage.write(message[0],message[1]);
                    JOptionPane.showMessageDialog(null,"注册成功！即将返回登录页面！","提示消息",JOptionPane.WARNING_MESSAGE);
                    try {
                        new MainInterFace().init();
                        jf.dispose();
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "用户已存在！请重新输入！", "标题",JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //返回到登录页面即可
                try {
                    JOptionPane.showMessageDialog(jf,"即将返回到登录页面！");
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
        vBox.add(btnBox);
        bgPanel.add(vBox);
        jf.add(bgPanel);

        jf.setVisible(true);
    }


    public static void main(String[] args) {
        try {
            new RegisterInterface().init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
