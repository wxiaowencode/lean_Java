package 宠物店;/*
 * 宠物类
 */

public class Pet{
    private String name;//昵称
    private float price;//价格
    private String type;//种类

    public Pet(String name, float price, String type){
        this.name = name;
        this.price = price;
        this.type = type;
    }

    //吃食方法
    public void eat(){
        System.out.println(type + "吃饭了！");
    }

    //宠物信息
    public String getInfo(){
        return "我是一只" + type + ",小伙伴们都叫我" + name + ",喜欢我就把我带走吧，只需" + price + "RMB。";
    }
    public String getType() {
        return this.type;
    }
}
