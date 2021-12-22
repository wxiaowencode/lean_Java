package TestDemos;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class BankEvent_Exam {
    static JFrame mainJFrame= new JFrame("银行管理系统");
    static JTabbedPane tabbedPane1=new JTabbedPane();
    //static JTabbedPane tabbedPane2=new JTabbedPane();
    static Component panel2=makeLoginPanel();
    static Component panel3=makeTextPanel("用户注册页面");
    static Component panel4=makeInfoPanel();
    static Component panel5=makeRecordPanel();
    protected static Component makeTextPanel(String text) {
        JPanel panel = new JPanel(false);
        JLabel filler= new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1,1));
        panel.add(filler);
        return panel;
    }
    protected static Component makeMenuPanel() {
        JPanel panel =new JPanel(false);
        ImageIcon image = new ImageIcon("D:/java/bank.png");
        JLabel lb_image = new JLabel(image);
        lb_image.setLayout(null);
        JButton [] menu = new JButton[8];
        for (int i = 0; i<menu.length;i++) {
            menu[i]=new JButton("Btn"+i);
        }
        menu[0].setText("用户登录");
        menu[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                methodA();
            }
            private void methodA() {
                tabbedPane1.removeAll();
                tabbedPane1.addTab("用户登录",null,panel2,"");
                tabbedPane1.addTab("用户注册",null,panel3," ");

            }
        });
        menu[1].setText("用户注册");
        menu[2].setText("个人信息");
        menu[3].setText("存款操作");
        menu[4].setText("取款操作");
        menu[5].setText("转账操作");
        menu[6].setText("交易记录");
        menu[7].setText("退出登录");
        for(int i=0;i<menu.length;i++) {
            menu[i].setBounds(10,15+35*i,100,25);
            lb_image.add(menu[i]);
        }
        panel.add(lb_image);
        return panel;
    }
    protected static Component makeLoginPanel() {
        JPanel panel = new JPanel(false);
        JLabel lb_name = new JLabel();
        lb_name.setText("账  号");
        lb_name.setSize(20,20);
        lb_name.setBounds(100,70,50,50);
        JLabel lb_pass = new JLabel("密  码");
        lb_pass.setSize(20,20);
        lb_pass.setBounds(100,110,50,50);
        final JTextField tf_name= new JTextField();
        tf_name.setSize(20,20);
        tf_name.setBounds(145,85,150,23);
        final JPasswordField pf_pass= new JPasswordField();
        pf_pass.setSize(20,20);
        pf_pass.setBounds(145,125,150,23);
        JButton bt_login = new JButton("登录");
        bt_login.setSize(20,20);
        bt_login.setBounds(110,185,70,23);
        JButton bt_reset = new JButton("重置");
        bt_reset.setSize(20,20);
        bt_reset.setBounds(210,185,70,23);
        panel.setLayout(null);
        panel.add(lb_name);
        panel.add(lb_pass);
        panel.add(tf_name);
        panel.add(pf_pass);
        panel.add(bt_login);
        panel.add(bt_reset);
        bt_login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                methodA();
            }
            private void methodA() {
                if (tf_name.getText().equals("test")&&pf_pass.getText().equals("test")) {
                    tabbedPane1.removeAll();
                    tabbedPane1.addTab("个人信息", null,panel4,"");
                    tabbedPane1.addTab("交易记录", null,panel5,"");
                }
                else {
                    JOptionPane.showMessageDialog(null, "账号或密码错误","提示信息",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        return panel;

    }
    protected static Component makeInfoPanel() {
        JPanel panel = new JPanel(false);
        JLabel lb_name = new JLabel();
        lb_name.setText("账  户");
        lb_name.setSize(20,20);
        lb_name.setBounds(100,70,50,50);
        JLabel lb_pass = new JLabel("余  额");
        lb_pass.setSize(20,20);
        lb_pass.setBounds(100,110,50,50);
        JTextField tf_name= new JTextField();
        tf_name.setText("239325670035891");
        tf_name.setSize(20,20);
        tf_name.setBounds(145,85,150,23);
        JTextField pf_pass= new JTextField();
        pf_pass.setText("10000");
        pf_pass.setSize(20,20);
        pf_pass.setBounds(145,125,150,23);
        panel.setLayout(null);
        panel.add(lb_name);
        panel.add(lb_pass);
        panel.add(tf_name);
        panel.add(pf_pass);
        return panel;
    }
    protected static Component makeRecordPanel() {
        JPanel panel = new JPanel(false);
        String[] columnNames= {"账号","转入/转出","金额","时间","余额","操作人员"};
        String [][] tableVales= {
                {"239325670035891","存款","10000","20160501"	,"10000","123"},
                {"239325670035891","存款","10000","20160501"	,"20000","123"},
                {"239325670035891","存款","10000","20160501"	,"30000","123"},
                {"239325670035891","取款","10000","20160501"	,"20000","123"},
                {"239325670035891","取款","10000","20160501"	,"10000","123"}};
        final DefaultTableModel tableModel=new DefaultTableModel(tableVales,columnNames);
        final JTable table=new JTable(tableModel);
        JScrollPane scrollPane2=new JScrollPane(table);
        scrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        GridBagLayout gridbag=new GridBagLayout();
        GridBagConstraints constraints =new GridBagConstraints();
        panel.setLayout(gridbag);
        constraints.fill=GridBagConstraints.BOTH;
        constraints.anchor=constraints.NORTHWEST;
        constraints.weightx=1;
        constraints.weighty=5;
        constraints.gridwidth=GridBagConstraints.REMAINDER;
        gridbag.setConstraints(scrollPane2,constraints);
        panel.add(scrollPane2);

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
        return panel;

    }

    public static void main(String[] args) {
        BorderLayout border =new BorderLayout(2,4);
        mainJFrame.setSize(600,400);
        mainJFrame.setLocation(300,150);
        Container container = mainJFrame.getContentPane();
        container.setLayout(border);
        JTabbedPane tabbedPane =new JTabbedPane();
        Component panel1=makeMenuPanel();
        tabbedPane.addTab("菜单栏",null,panel1,"");
        tabbedPane.setPreferredSize(new Dimension(150,400));
        container.add(tabbedPane,BorderLayout.WEST);
        tabbedPane1.addTab("用户登录",null,panel2,"");
        tabbedPane1.setSelectedIndex(0);
        tabbedPane1.addTab("用户注册",null,panel3,"");
        container.add(tabbedPane1,BorderLayout.CENTER);

        JMenuBar mb =new JMenuBar();
        JMenu menu1 =new JMenu("系  统");
        JMenu menu2 =new JMenu("账  户");
        JMenuItem mi1=new JMenuItem("退出系统");
        JMenuItem mi2=new JMenuItem("切换账号");
        JMenuItem mi3=new JMenuItem("添加员工");
        JMenuItem mi4=new JMenuItem("更换密码");
        mb.add(menu1);
        mb.add(menu2);
        menu1.addSeparator();
        menu1.add(mi1);
        menu1.add(mi2);
        menu2.addSeparator();
        menu2.add(mi3);
        menu2.add(mi4);
        mainJFrame.setJMenuBar(mb);
        mainJFrame.setVisible(true);
    }
}
