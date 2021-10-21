package 宠物店;

public class Dog extends Pet{
    //构造方法
    public Dog(String name, float price){

    super(name,price,"狗");
    }
    //吃食方法
    @Override
    public void eat(){
        //补充完整
        System.out.println("我喜欢啃大棒骨！");
    }
}