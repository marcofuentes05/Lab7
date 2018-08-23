package clases;

public class ShoppingItem {
    private String name;
    private int amount;
    private double prizeU;
    private double totalPrize;
    private boolean state;

    public ShoppingItem(){

    }
    public ShoppingItem(String n , int a, double p, double t, boolean s){
        this.name=n;
        this.amount= a;
        this.prizeU= p;
        this.totalPrize=t;
        this.state=s;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public double getPrizeU() {
        return prizeU;
    }

    public double getTotalPrize() {
        return totalPrize;
    }

    public boolean isState() {
        return state;
    }
}
