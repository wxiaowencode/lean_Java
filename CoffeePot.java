public class CoffeePot {

    public String name;
    public int amount;

    public CoffeePot(String name, int amount) {
        this.name=name;
        this.amount=amount;
    }//
    public String getCoffeeName() {
        return name;
    }
    public int getCoffeeAmount() {
        return amount;
    }
    //返回-1表示咖啡的数量不够
    //返回1表示操作成功
    public int pourCup(int cup) {
        if(cup>amount){
            return -1;
        }else{
            amount=amount-cup;
            return 1;
        }
    }
    public int brewPot(int amount) {
        amount+=amount;
        return 1;
    }
}
