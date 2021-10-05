import java.util.*;

public class PolynomialTest {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Polynomial p = new Polynomial();
        do {
            System.out.print("输入最高次: ");
            p.setDegree(s.nextInt());
            for (int i = p.getDegree(); i >= 0; i--) {
                System.out.print(" 输入第" + i + "项的系数：");
                p.setCoeff(i, s.nextDouble());
            }
            System.out.println("你输入的多项式为：\n"+p.toString() );
            System.out.print("重新输入？(true/false)");
        } while (s.nextBoolean());
        do {
            System.out.print("输入自变量的值：");
            double x = s.nextDouble();
            System.out.println("p(" + x + ") = " + p.evaluate(x));
            System.out.print("继续计算？(true/false)");
        } while (s.nextBoolean());
    }
}
