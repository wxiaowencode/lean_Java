package 宠物店;
import java.util.ArrayList;
import java.util.ArrayList;

public class PetsDemo {
    public static void main(String[] args){
        Dog d1 = new Dog("小白", 2000.0f);
        Dog d2 = new Dog("小黑", 1000.0f);
        Dog d3 = new Dog("小黄", 800.0f);
        Cat c1 = new Cat("汤姆", 200.0f);
        Cat c2 = new Cat("咪咪", 1200.0f);

        PetShop ps = new PetShop();
        ps.add(d1);
        ps.add(d2);
        ps.add(d3);
        ps.add(c1);
        ps.add(c2);
        for(Pet p: ps.getPets()){
            System.out.println(p.getInfo());
            p.eat();
        }
        System.out.println("--------------------------查找狗-------------------------");
        Object[] pets = ps.findBytype("狗");
        for(Object p: pets){
            Pet pet = (Pet)p;
            System.out.println(pet.getInfo());
            pet.eat();
        }

        System.out.println("--------------------------查找猫-------------------------");
        pets = ps.findBytype("猫");
        for(Object p: pets){
            Pet pet = (Pet)p;
            System.out.println(pet.getInfo());
            pet.eat();
        }
    }
}



