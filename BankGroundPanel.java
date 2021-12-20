

import javax.swing.*;
import java.awt.*;

public class BankGroundPanel extends JPanel {
    //声明图片
    private Image backIcon;
    public BankGroundPanel(Image backIcon){
        this.backIcon=backIcon;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //绘制背景
        g.drawImage(backIcon,0,0,500,300,null);
    }
}
