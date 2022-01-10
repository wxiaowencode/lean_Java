package component;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class BookManageComponent extends Box{
    final int WIDTH=850;
    final int HEIGHT=600;


         JFrame jf=null;
    private  JTable table;
    private Vector<String> titles;
    private Vector<String> tablesData;
    private TableModel tableModel;



    public BookManageComponent(JFrame jf){
        //垂直布局
        super(BoxLayout.Y_AXIS);

        //组装试图
        this.jf=jf;
        JPanel btnPanel=new JPanel();
        Color color=new Color(203,220,217);
        btnPanel.setBackground(color);
        btnPanel.setMaximumSize(new Dimension(WIDTH,80));
        btnPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));


        JButton addBtn=new JButton("添加");
        JButton uptaBtn=new JButton("修改");
        JButton deletBtn=new JButton("删除");

        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddBookDialog(jf,"添加图书",true).setVisible(true);
            }
        });

        btnPanel.add(addBtn);
        btnPanel.add(uptaBtn);
        btnPanel.add(deletBtn);

        this.add(btnPanel);//this当前类的对象


        //组装表格
        String[] ts={"编号","书名","简介","作者","价格","库存"};
        titles =new Vector<>();
        for(String title:ts){
            titles.add(title);
        }

        tablesData=new Vector<>();
        tableModel=new DefaultTableModel(tablesData,titles);
        table=new JTable(tableModel){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        //设置只能选中一行
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        //滚动条
        JScrollPane scrollPane=new JScrollPane(table);

        this.add(scrollPane);
    }
    //请求数据

    public void requestData(){
       //清楚数据
        //刷新表格
    }

}
