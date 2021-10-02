
import java.util.Scanner;
public class  Operators{

    public static void main(String[] args) {


            Scanner s = new Scanner(System.in);
           System.out.println("Integer operators:");
            System.out.print("Enter integer 1> ");

            int a= s.nextInt();

            System.out.print("Enter integer 2> ") ;
             int b = s.nextInt();
            System.out.println(a+"+"+b+"="+(a+b));
            System.out.println(a+"%"+b+"="+(a%b));
            System.out.println(a+"<<"+b+"="+(a<<b));
            System.out.println(a+">>"+b+"="+(a>>b));
            System.out.println(a+">>>"+b+"="+(a>>>b));
            System.out.println(a+"&"+b+"="+(a&b));


      
            System.out.println("Floating point operators:");

            System.out.print("Enter decimal 1>");

            double d1 = s.nextDouble();

            System.out.print("Enter decimal 2> ");

            double d2 = s.nextDouble();
             System.out.println(d1+"+"+d2+"="+(d1+d2));
             System.out.println(d1+"*"+d2+"="+(d1*d2));
             System.out.println(d1+"-"+d2+"="+(d1-d2));
             System.out.println(d1+"/"+d2+"="+(d1/d2));


        System.out.println("Boolean operators:");
             System.out.print("Enter Boolean 1>");
        boolean b1 = s.nextBoolean();
             System.out.print("Enter Boolean 2>");
        boolean b2 = s.nextBoolean();
        System.out.println(b1+"&"+b2+"="+(b1&b2));
        System.out.println(b1+"|"+b2+"="+(b1|b2));
        System.out.println(b1+"^"+b2+"="+(b1^b2));
        System.out.println("!"+b1+"="+(!b1));

        System.out.println("Yans-MacBookPro:3 Yan$ ");



          

	
    }
}
