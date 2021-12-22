package ui;

import uitl.ScreenUtils;

import javax.crypto.interfaces.PBEKey;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import component.BankGroundPanel;
public class MainInterFace {

    JFrame jf=new JFrame("我的图书馆");

    final int WIDTH=500;
    final int HEIGHT=300;


    //组装视图
    public void init()  throws Exception{
        //设置窗口坐标--让窗口居中
        jf.setBounds((ScreenUtils.getScreenWith() - WIDTH) / 2, (ScreenUtils.getScreenHeight() - HEIGHT) / 2, WIDTH, HEIGHT);
        jf.setResizable(false);//窗口大小不可变
        try {
            jf.setIconImage(ImageIO.read(new File("src\\images\\bank.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }


        //设置窗口的内容




            BankGroundPanel bgPanel = new BankGroundPanel(ImageIO.read(new File("src\\images\\fish.png")));


        //组装垂直相关的元素
        Box vBox = Box.createVerticalBox();

        //组装用户名
        Box uBox = Box.createHorizontalBox();
        JLabel uLabel = new JLabel("用户名： ");
        JTextField uField = new JTextField(15);


        uBox.add(uLabel);
        uBox.add(Box.createVerticalStrut(20));//增加间隔
        uBox.add(uField);


        //组装密码
        Box pBox = Box.createHorizontalBox();
        JLabel pLabel = new JLabel("密     码:");
        JTextField pField = new JTextField(15);

        pBox.add(pLabel);
        pBox.add(Box.createHorizontalStrut(12));
        pBox.add(pField);

        //组装按钮

        Box btnBox = Box.createHorizontalBox();
        JButton loginBtn = new JButton("登录");
        JButton regisBtn = new JButton("注册");

        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //获取用户输入的数据
                String username=uField.getText().trim();
                String password=pField.getText().trim();

                //封装一下：
                Map<String,String> params=new HashMap<>();
                params.put("username",username);
                params.put("password",password);

                //访问登录接口

            }
        });

        regisBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //跳转到登录页面
                JOptionPane.showMessageDialog(jf,"跳转到注册页面！！");
                try {
                    new RegisterInterface().init();
                    jf.dispose();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });







        btnBox.add(loginBtn);
        btnBox.add(Box.createHorizontalStrut(100));
        btnBox.add(regisBtn);


        vBox.add(Box.createVerticalStrut(50));
        vBox.add(uBox);
        vBox.add(Box.createVerticalStrut(20));
        vBox.add(pBox);
        vBox.add(Box.createVerticalStrut(40));
        vBox.add(btnBox);

        bgPanel.add(vBox);

        jf.add(bgPanel);

        jf.setVisible(true);
    }
    //客户端程序的入口
    public static void main(String[] args) {
        try {
            new MainInterFace().init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
