package 宠物店;

public class Cat extends Pet{
    //构造方法
    public Cat(String name, float price){
        //补充完整
        super(name, price, "猫");
    }
    @Override
    public void eat(){
        System.out.println("我喜欢吃鱼！");
    }
}
