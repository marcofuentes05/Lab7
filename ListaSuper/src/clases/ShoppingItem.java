package clases;


public class ShoppingItem {
    private String name;
    private Integer amount;
    private double prizeU;
    private double prizeT;
    private Boolean state;

    public ShoppingItem(String n , int a, double p){
        this.name=n;
        this.amount= a;
        this.prizeU= p;
        this.prizeT=a*p;
        this.state=false;
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

    public double getPrizeT() {
        double p ;
        if(state){
            p=0;
        }else{
            p=prizeT;
        }
        return p;
    }

    public String getState() {
        String estado;
        if (state) {
            estado = "Comprado";
        }else{
            estado = "Pendiente";
        }
        return estado;
    }
    public Boolean isState(){
        return state;
    }


    public void setState(Boolean b){
        this.state = b;
    }
}
