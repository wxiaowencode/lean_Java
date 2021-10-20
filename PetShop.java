package 宠物店;
import java.util.*;
import java.util.ArrayList;

class PetShop{
    private ArrayList<Pet> pets;

    public PetShop() {
        pets = new ArrayList<Pet>();
    }

    //添加
    public void add(Pet p){
        pets.add(p);
    }

    //获取所有宠物
    public Pet[] getPets(){
        Pet[] p = new Pet[pets.size()];
        for(int i = 0; i < pets.size(); ++i){
            p[i] = pets.get(i);
        }
        return p;
    }

    //根据宠物种类查找宠物信息
    public Object[] findBytype(String type){
        ArrayList<Pet> al = new ArrayList<Pet>();
        for(int i = 0; i < pets.size(); ++i){
            if(pets.get(i).getType().equals(type)){
                al.add(pets.get(i));
            }
        }
        return (Object[])al.toArray();
    }
}
