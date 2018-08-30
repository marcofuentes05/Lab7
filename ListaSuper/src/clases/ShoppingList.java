package clases;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;

public class ShoppingList {
    private String name;
    private LocalDate date;
    private String descripcion;
    private double prize;
    private int pendingItems;
    private ObservableList<ShoppingItem> list;

    public ShoppingList(String n, LocalDate f, String d){
        this.name=n;
        this.date= f;
        this.descripcion=d;
        this.list= FXCollections.observableArrayList();
        this.prize = 0;
        this.pendingItems = 0;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    public ObservableList<ShoppingItem> getList() {
        return list;
    }

    public double getPrize (){
        prize=0;
        double p0;
        for (int a = 0;a<list.size();a++){
            if (list.get(a).isState()==false){
                p0 = list.get(a).getPrizeU() * list.get(a).getAmount();
                prize = prize + p0;
            }

        }
        return prize;
    }

    public int getPendingItems(){
        pendingItems = 0;
        int n = this.list.size();
        for (int i =0; i<n;i++){
            if (list.get(i).isState() == false){
                pendingItems = pendingItems +list.get(i).getAmount();
            }
        }
        return pendingItems;
    }

    public void refresh(){
        int pendiente = 0;
        double precio  = 0;
        int n = this.list.size();
        for (int i = 0; i<n-1 ;i++){
            if (this.list.get(i).isState()==false){
                pendiente = pendiente + this.list.get(i).getAmount();
                precio = precio + this.list.get(i).getPrizeT();
            }
        }
        this.prize=precio;
        this.pendingItems=pendiente;

    }
}
