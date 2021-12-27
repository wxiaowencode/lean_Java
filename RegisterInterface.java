package ui;


import component.BankGroundPanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class RegisterInterface {

    JFrame jf=new JFrame("注册");


    public void init() throws IOException {


        //窗口属性
        jf.setSize(500,300);//设置大小
        jf.setLocationRelativeTo(null);//居中显示
        jf.setResizable(false);
        jf.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        jf.setIconImage(ImageIO.read(new File("src\\images\\bank.png" )));
        BankGroundPanel bgPanel=new BankGroundPanel(ImageIO.read(new File("src\\images\\fish.png")));
        bgPanel.setBounds(0,0,500,300);


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

        //组装金额
        Box aBox=Box.createHorizontalBox();
        JLabel aLabel=new JLabel("金    额：");
        JTextField aField=new JTextField(10);

        aBox.add(aLabel);
        aBox.add(Box.createHorizontalStrut(20));
        aBox.add(aField);



        Box btnBox=Box.createHorizontalBox();
        JButton regisBtn=new JButton("注册");
        JButton backBtn=new JButton("返回登录页面");

        regisBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //获取用户输入的信息

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
        vBox.add(hBox);
        vBox.add(Box.createVerticalStrut(20));
        vBox.add(aBox);
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
