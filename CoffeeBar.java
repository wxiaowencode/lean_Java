public class CoffeeBar {
    private static final int SMALL_CUP_OZ = 8;
    private static final int LARGE_CUP_OZ = 16;
    private CoffeePot[] pots;
    public CoffeeBar(CoffeePot[]  pots) {
      //  pots =pots.length;
        this.pots=pots;
    }
    public void getMenu() {
        String p=new String();
        for (int i = 0; i <pots.length ; i++) {
            p= i+1+"."+pots[i].getCoffeeName()+"("+pots[i].getCoffeeAmount()+" oz )";
            System.out.println(p);
        }
    }
    public int getSmallCup() { return SMALL_CUP_OZ; }
    public int getLargeCup() { return LARGE_CUP_OZ; }
    private int serveCup(int n, int cup) {

        return pots[n-1].pourCup(cup);
    }
    public int serveSmallCup(int pot) {

        return serveCup(pot,SMALL_CUP_OZ);
    }
    public int serveLargeCup(int pot) {

        return serveCup(pot,LARGE_CUP_OZ);
    }
}
