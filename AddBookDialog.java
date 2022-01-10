package component;

import uitl.ScreenUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddBookDialog extends Dialog {
    final  int WIDTH=400;
    final int HEIGHT=300;

    public AddBookDialog(JFrame jf,String title,boolean isModel){
        super(jf,title,isModel);
        //组装视图

        this.setBounds((ScreenUtils.getScreenWith())/2,(ScreenUtils.getScreenHeight()-HEIGHT)/2,WIDTH,HEIGHT);

        Box vBox=Box.createVerticalBox();

        //组装图书名称
        Box nameBox=Box.createHorizontalBox();
        JLabel nameLable=new JLabel("图书名称：");
        JTextField nameField=new JTextField(15);

        nameBox.add(nameLable);
        nameBox.add(Box.createHorizontalStrut(20));
        nameBox.add(nameField);

        //组装图书库存
        Box stockBox=Box.createHorizontalBox();
        JLabel stockLable=new JLabel("图书库存：");
        JTextField stockField=new JTextField(15);

        stockBox.add(stockLable);
        stockBox.add(Box.createHorizontalStrut(20));
        stockBox.add(stockField);



        //组装图书作者
        Box authorBox=Box.createHorizontalBox();
        JLabel authorLable=new JLabel("图书作者：");
        JTextField authorField=new JTextField(15);

        authorBox.add(authorLable);
        authorBox.add(Box.createHorizontalStrut(20));
        authorBox.add(authorField);

        //组装图书价格
        Box priceBox=Box.createHorizontalBox();
        JLabel priceLable=new JLabel("图书价格：");
        JTextField priceField=new JTextField(15);

        priceBox.add(priceLable);
        priceBox.add(Box.createHorizontalStrut(20));
        priceBox.add(priceField);


        //组装图书简介
        Box descBox=Box.createHorizontalBox();
        JLabel descLable=new JLabel("图书简介：");
        JTextArea descArea=new JTextArea(3,15);

        descBox.add(descLable);
        descBox.add(Box.createHorizontalStrut(20));
        descBox.add(descArea);


        //组装按钮
        Box btnBox=Box.createHorizontalBox();
        JButton addBtn=new JButton("添加");
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //获取用户的输入

            }
        });

        btnBox.add(addBtn);

        vBox.add(Box.createVerticalStrut(20));
        vBox.add(nameBox);
        vBox.add(Box.createVerticalStrut(15));
        vBox.add(stockBox);
        vBox.add(Box.createVerticalStrut(15));
        vBox.add(authorBox);
        vBox.add(Box.createVerticalStrut(15));
        vBox.add(priceBox);
        vBox.add(Box.createVerticalStrut(15));
        vBox.add(descBox);
        vBox.add(Box.createVerticalStrut(15));
        vBox.add(btnBox);

        //添加左右间隔。
        Box hBox=Box.createHorizontalBox();
        hBox.add(Box.createHorizontalStrut(20));
        hBox.add(vBox);
        hBox.add(Box.createHorizontalStrut(20));

        this.add(hBox);

    }
}
