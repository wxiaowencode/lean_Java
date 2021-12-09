import javax.swing.*;
import java.awt.*;

public class SwingComponentDemo {
    JFrame frame=new JFrame("测试Swing基本组件");

    //声明菜单相关选项
    JMenuBar menuBar=new JMenuBar();

    JMenu fileMenue=new JMenu("文件");
    JMenu editMenue=new JMenu("编辑");

    JMenuItem auto=new JMenuItem("自动换行");
    JMenuItem copy=new JMenuItem("复制");
    JMenuItem paste=new JMenuItem("粘贴");


    JMenu formatMenu=new JMenu("格式");
    JMenuItem comment=new JMenuItem("注释");
    JMenuItem cancelIComment=new JMenuItem("取消注释");

    //声明文本域
    JTextArea ta=new JTextArea(8,20);

    //声明列表框
    JList<String> colorList=new JList<String>();

    //声明选择相关组件
    String[] colors={"绿色","红色","蓝色"};
    JComboBox<String> colorSelect =new JComboBox<String>(colors);


    //声明单选框

    ButtonGroup bg=new ButtonGroup();
    JRadioButton male=new JRadioButton("男",false);
    JRadioButton female=new JRadioButton("女",true);

    JCheckBox isMarried=new JCheckBox("是否已婚？",false);

    //声明底部
    JTextField tf=new JTextField(40);
    JButton ok=new JButton("确定");

    //声明右键菜单
     JPopupMenu jPopupMenu=new JPopupMenu();

     ButtonGroup poupButtonBg=new ButtonGroup();

     JRadioButtonMenuItem metalItem=new JRadioButtonMenuItem("Metal 风格");
    JRadioButtonMenuItem nimbusItem=new JRadioButtonMenuItem("Nimbus 风格");
    JRadioButtonMenuItem windowsItem=new JRadioButtonMenuItem("Windows 风格");
    JRadioButtonMenuItem windowsClassicItem=new JRadioButtonMenuItem("WindowsClassic 风格");
    JRadioButtonMenuItem motifItem=new JRadioButtonMenuItem("Motif 风格");


    //初始化界面
    public void init(){
        //组装视图

        //组装底部
        JPanel bottonPanel=new JPanel();
        bottonPanel.add(tf);
        bottonPanel.add(ok);
        frame.add(bottonPanel, BorderLayout.SOUTH);

        //组装相关的组件
        JPanel selectPanel =new JPanel();

        colorSelect.addItem("红色");
        colorSelect.addItem("绿色");
        colorSelect.addItem("蓝色");

        selectPanel.add(colorSelect);
        bg.add(male);
        bg.add(female);
        selectPanel.add(male);
        selectPanel.add(female);

        selectPanel.add(isMarried);

        //组装文本域和选择相关组件
        Box topLeft=Box.createVerticalBox();
        topLeft.add(ta);
        topLeft.add(selectPanel);

        //组装顶部
        Box top=Box.createHorizontalBox();
        top.add(topLeft,colorList);

        frame.add(top);

        //组装顶部菜单
        formatMenu.add(comment);
        formatMenu.add(cancelIComment);

        editMenue.add(auto);
        editMenue.addSeparator();
        editMenue.add(copy);
        editMenue.add(paste);
        editMenue.addSeparator();
        editMenue.add(formatMenu);

        menuBar.add(fileMenue);
        menuBar.add(editMenue);
        frame.setJMenuBar(menuBar);

        //组装右键菜单
        poupButtonBg.add(metalItem);
        poupButtonBg.add(nimbusItem);
        poupButtonBg.add(windowsClassicItem);
        poupButtonBg.add(windowsClassicItem);
        poupButtonBg.add(motifItem);

    }
}
