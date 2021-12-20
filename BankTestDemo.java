
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;
import java.io.IOException;


public class BankTestDemo {
   static  JFrame jf=new JFrame("银行管理系统");
   static JTabbedPane tabbedPane=new JTabbedPane();
   static JTabbedPane tabbedPane1=new JTabbedPane();//用户登录和用户注册界面
    //交易记录中又可以存款、取款、转账
    static JLabel jl1=new JLabel();
    //菜单：系统、账户、基本操作。
    JMenuBar jMenuBar;
    JMenu systemMenu,accountMenu,operaMenu;
    //系统菜单项
    JMenuItem exitItem,logItem,switchItem;
    JMenuItem loginItem,registerItem,piItem;
    JMenuItem depositItem,withdrawItem,transferItem,recordItem;
  static   Box vBox=Box.createVerticalBox();
    //8个按钮
  static   JButton jb1,jb2,jb3,jb4,jb5,jb6,jb7,jb8;



    protected static Component makeRecordPanel(){
        JPanel panel=new JPanel();
        String[] columnNames= {"账号","转入/转出","金额","时间","余额","操作人员"};
        String [][] tableVales= {
                {"239325670035891","存款","10000","20160501"	,"10000","123"},
                {"239325670035891","存款","10000","20160501"	,"20000","123"},
                {"239325670035891","存款","10000","20160501"	,"30000","123"},
                {"239325670035891","取款","10000","20160501"	,"20000","123"},
                {"239325670035891","取款","10000","20160501"	,"10000","123"}};
        final DefaultTableModel tableModel=new DefaultTableModel(tableVales,columnNames);
        final JTable table=new JTable(tableModel);
        JScrollPane scrollPane1=new JScrollPane(table);
        scrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        GridBagLayout gridbag=new GridBagLayout();
        GridBagConstraints constraints =new GridBagConstraints();
        panel.setLayout(gridbag);
        constraints.fill=GridBagConstraints.BOTH;
        constraints.anchor=constraints.NORTHWEST;
        constraints.weightx=1;
        constraints.weighty=5;
        constraints.gridwidth=GridBagConstraints.REMAINDER;
        gridbag.setConstraints(scrollPane1,constraints);
        panel.add(scrollPane1);

        constraints.weightx=1;
        constraints.weighty=0.3;
        constraints.gridwidth=GridBagConstraints.REMAINDER;
        JLabel lab11=new JLabel("金额");
        gridbag.setConstraints(lab11,constraints);
        final JTextField tf1=new JTextField();
        gridbag.setConstraints(tf1,constraints);
        panel.add(lab11);
        constraints.gridwidth=GridBagConstraints.REMAINDER;
        panel.add(tf1);

        constraints.weightx=1;
        constraints.weighty=0.3;
        constraints.gridwidth=GridBagConstraints.REMAINDER;
        JLabel lab12=new JLabel("时间");
        gridbag.setConstraints(lab12,constraints);
        final JTextField tf2=new JTextField();
        gridbag.setConstraints(tf2,constraints);
        panel.add(lab12);
        constraints.gridwidth=GridBagConstraints.REMAINDER;
        panel.add(tf2);

        constraints.weightx=1;
        constraints.weighty=0.3;
        constraints.gridwidth=GridBagConstraints.REMAINDER;
        JLabel lab13=new JLabel("余额");
        gridbag.setConstraints(lab13,constraints);
        final JTextField tf3=new JTextField();
        gridbag.setConstraints(tf3,constraints);
        panel.add(lab13);
        //constraints.gridwidth=GridBagConstraints.REMAINDER;
        panel.add(tf3);
        constraints.weightx=1;
        constraints.weighty=0.3;
        constraints.gridwidth=1;
        JButton bt1=new JButton("存款");
        gridbag.setConstraints(bt1,constraints);
        panel.add(bt1);
        JButton bt2=new JButton("取款");
        gridbag.setConstraints(bt2,constraints);
        panel.add(bt2);
        JButton bt3=new JButton("转账");
        gridbag.setConstraints(bt3,constraints);
        panel.add(bt3);

        bt1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String []rowValues = {"239325670035891","存款",tf1.getText(),
                        tf2.getText(),tf3.getText(),"123"};
                tableModel.addRow(rowValues);
                int rowCount=table.getRowCount()+1;
            }
        });

        bt2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String []rowValues = {"239325670035891","取款",tf1.getText(),
                        tf2.getText(),tf3.getText(),"123"};
                tableModel.addRow(rowValues);
                int rowCount=table.getRowCount()+1;
            }
        });
        bt3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String []rowValues = {"239325670035891","转账",tf1.getText(),
                        tf2.getText(),tf3.getText(),"123"};
                tableModel.addRow(rowValues);
                int rowCount=table.getRowCount()+1;
            }
        });

        return panel;
    }

    protected static Component makeLoginPanel(){
        JPanel panel=new JPanel();
        Box vBox=Box.createVerticalBox();

        Box hBox=Box.createHorizontalBox();
        JLabel jb1=new JLabel("账   号：");
        JTextField jf1=new JTextField(15);
        hBox.add(jb1);
        hBox.add(Box.createHorizontalStrut(20));
        hBox.add(jf1);

        Box uBox=Box.createHorizontalBox();
        JLabel jb2=new JLabel("密    码：");
        JPasswordField jf2=new JPasswordField(15);
        uBox.add(jb2);
        uBox.add(Box.createHorizontalStrut(20));
        uBox.add(jf2);


        Box zBox=Box.createHorizontalBox();
        JButton b1=new JButton("登录");
        JButton b2=new JButton("重置");
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jf1.setText("");
                jf2.setText("");
            }
        });
        zBox.add(b1);
        zBox.add(Box.createHorizontalStrut(70));
        zBox.add(b2);



        vBox.add(Box.createVerticalStrut(80));
        vBox.add(hBox);
        vBox.add(Box.createVerticalStrut(30));
        vBox.add(uBox);
        vBox.add(Box.createVerticalStrut(30));
        vBox.add(zBox);

        panel.add(vBox,BorderLayout.CENTER);





        return panel;
    }

    protected static Component makeInfoPanel(){
        JPanel panel=new JPanel();

        Box vBox=Box.createVerticalBox();

        Box hBox=Box.createHorizontalBox();
        JLabel jb1=new JLabel("账   号：");
        JTextField jf1=new JTextField(15);
        jf1.setText("1234");
        hBox.add(jb1);
        hBox.add(Box.createHorizontalStrut(20));
        hBox.add(jf1);

        Box uBox=Box.createHorizontalBox();
        JLabel jb2=new JLabel("余    额：");
        JTextField jf2=new JTextField(15);
        jf2.setText("0");
        uBox.add(jb2);
        uBox.add(Box.createHorizontalStrut(20));
        uBox.add(jf2);


        vBox.add(Box.createVerticalStrut(80));
        vBox.add(hBox);
        vBox.add(Box.createVerticalStrut(30));
        vBox.add(uBox);
        vBox.add(Box.createVerticalStrut(30));


        Box mmBox=Box.createHorizontalBox();
        JButton jb10= new JButton("更新");
        mmBox.add(jb10);

         vBox.add(mmBox);
        panel.add(vBox,BorderLayout.CENTER);


        return panel;
    }


protected static Component makeMenuPanel(){
        JPanel panel=new JPanel();
    jb1=new JButton("用户登录");
    jb1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            tabbedPane1.removeAll();
            tabbedPane1.addTab("用户登录",null,makeLoginPanel(),"");
        }
    });
    jb2=new JButton("用户注册");
    jb2.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            tabbedPane1.removeAll();
            tabbedPane1.addTab("用户注册",null,makeRegisterPanel(),"");
        }
    });
    jb3=new JButton("个人信息");
    jb3.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            tabbedPane1.removeAll();
            tabbedPane1.addTab("个人信息",null,makeInfoPanel(),"");
        }
    });
    jb4=new JButton("存款操作");
    jb4.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            tabbedPane1.removeAll();
            tabbedPane1.addTab("存款操作",null,makeRecordPanel(),"");
        }
    });
    jb5=new JButton("取款操作");
    jb5.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            tabbedPane1.removeAll();
            tabbedPane1.addTab("取款操作",null,makeRecordPanel(),"");
        }
    });
    jb6=new JButton("转账操作");
    jb6.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            tabbedPane1.removeAll();
            tabbedPane1.addTab("转账操作",null,makeRecordPanel(),"");
        }
    });
    jb7=new JButton("交易记录");
    jb7.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            tabbedPane1.removeAll();
            tabbedPane1.addTab("交易记录",null,makeRecordPanel(),"");
        }
    });
    jb8=new JButton("退出登录");
    jb8.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    });
        Box vBox=Box.createVerticalBox();

        Box box1=Box.createHorizontalBox();


    vBox.add(Box.createVerticalStrut(20));
    vBox.add(jb1);
    vBox.add(Box.createVerticalStrut(20));
    vBox.add(jb2);
    vBox.add(Box.createVerticalStrut(20));
    vBox.add(jb3);
    vBox.add(Box.createVerticalStrut(20));
    vBox.add(jb4);
    vBox.add(Box.createVerticalStrut(20));
    vBox.add(jb5);
    vBox.add(Box.createVerticalStrut(20));
    vBox.add(jb6);
    vBox.add(Box.createVerticalStrut(20));
    vBox.add(jb7);
    vBox.add(Box.createVerticalStrut(20));
    vBox.add(jb8);

        panel.add(vBox);

        return panel ;
}





  protected static Component makeRegisterPanel(){
        JPanel panel=new JPanel();


        Box zBox=Box.createVerticalBox();
        Box vBox=Box.createHorizontalBox();
        JLabel ml=new JLabel("点击跳转至登录界面");
        JButton jbn=new JButton("注册");
        jbn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new RegisterInterface().init();
                    jf.dispose();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        vBox.add(ml);
        vBox.add(Box.createHorizontalStrut(20));
        vBox.add(jbn);

        zBox.add(Box.createVerticalStrut(70));
        zBox.add(vBox);
        panel.add(zBox);
        return panel;
  }


    public void init(){


        jf.setSize(700,500);//大小
        jf.setLocationRelativeTo(null);//居中
        jf.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);//仅关闭当前窗口

        //logo
        try {
            jf.setIconImage(ImageIO.read(new File("src\\images\\bank.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        jMenuBar=new JMenuBar();
        systemMenu=new JMenu("系统");
        accountMenu=new JMenu("账户");
        operaMenu=new JMenu("基本操作");
        exitItem=new JMenuItem("退出系统");
        logItem=new JMenuItem("退出登录");
        switchItem=new JMenuItem("切换账号");
        loginItem=new JMenuItem("用户登录");
        registerItem=new JMenuItem("用户注册");
        piItem=new JMenuItem("个人信息");
        piItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabbedPane1.removeAll();
                tabbedPane1.addTab("个人信息",null,makeInfoPanel(),"");
            }
        });
        depositItem=new JMenuItem("存款操作");
        depositItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabbedPane1.removeAll();
                tabbedPane1.addTab("存款操作",null,makeRecordPanel(),"");
            }
        });
        withdrawItem=new JMenuItem("取款操作");
        withdrawItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabbedPane1.removeAll();
                tabbedPane1.addTab("取款操作",null,makeRecordPanel(),"");
            }
        });
        transferItem=new JMenuItem("转账操作");
        transferItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabbedPane1.removeAll();
                tabbedPane1.addTab("转账操作",null,makeRecordPanel(),"");
            }
        });
        recordItem=new JMenuItem("交易记录");
        recordItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabbedPane1.removeAll();
                tabbedPane1.addTab("交易记录",null,makeRecordPanel(),"");
            }
        });

        jMenuBar.add(systemMenu);
        jMenuBar.add(accountMenu);
        jMenuBar.add(operaMenu);
        systemMenu.add(exitItem);
        systemMenu.add(logItem);
        systemMenu.add(switchItem);
        accountMenu.add(loginItem);
        accountMenu.add(registerItem);
        accountMenu.add(piItem);
        operaMenu.add(depositItem);
        operaMenu.add(withdrawItem);
        operaMenu.add(transferItem);
        operaMenu.add(recordItem);

        jf.setJMenuBar(jMenuBar);


        loginItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new MainInterFace().init();
                    jf.dispose();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        registerItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new RegisterInterface().init();
                    jf.dispose();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        logItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new MainInterFace().init();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                jf.dispose();
            }
        });

        switchItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new MainInterFace().init();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                jf.dispose();
            }
        });



        tabbedPane.addTab("菜单栏",null,makeMenuPanel(),"");
        tabbedPane.setPreferredSize(new Dimension(150,400));
        tabbedPane1.addTab("用户登录",null,makeLoginPanel(),"");
        tabbedPane1.setSelectedIndex(0);
        tabbedPane1.addTab("用户注册",null,makeRegisterPanel(),"");




         jf.add(tabbedPane1);

        jf.add(tabbedPane,BorderLayout.WEST);

        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new BankTestDemo().init();
    }
}
