import java.util.Scanner;

public class Polynomial {
    public int degree; // 多项式的最高次
    public double[] coeffs; // 多项式各项的系数
    // 构造方法
    public Polynomial(){
    }
    public Polynomial(int d){ //给定degree创建Polynomial对象
        this.degree=d;
    }
    public Polynomial(int d, double[] c) {
        this.degree=d;
        this.coeffs=c;
    }
    //set & get for degree
    public void setDegree(int d) {
        this.degree=d;
        coeffs =new double[degree+1];
    }
    public int getDegree(){

        return degree;
    }
    //set for Coefficients
    public void setCoeff(int i, double v) {
         coeffs[i]=v;
    }
    public void getCoeff(){
    }
    public void setCoeffs(double[] vs){
        for (int i = degree; i>=0; i--) {
            coeffs [i]= vs[i];
        }
    }
    //String representation for Polynomial object
    public String toString() {
        String p;
        p = " p(x)=";
        for (int i = degree; i > 0; i--) {
            if (coeffs[i] != 0) {
                p += coeffs[i] + "*x^" + i + " +";
            }
        }
        if (coeffs[0] != 0) {
            p += coeffs[0];
        }
        if (p.charAt(p.length() - 1) == '+') {
            p = p.substring(0, p.length() - 1);
        }
        return p;
    }
    //evaluate polynomial given variable x
    public double evaluate(double x) {
        double result = 0;
        for (int i = degree; i > 0; i--) {
            result = (result + coeffs[i]) * x;
        }
        result += coeffs[0];
        return result;
    }
}
