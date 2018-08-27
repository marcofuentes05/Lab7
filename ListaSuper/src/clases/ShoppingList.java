package clases;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ShoppingList {
    private String name;
    private LocalDate date;
    private String descripcion;
    private ArrayList<ShoppingItem> list;

    public ShoppingList(){}

    public ShoppingList(String n, LocalDate f, String d){
        this.name=n;
        this.date= f;
        this.descripcion=d;
        this.list= new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    public ArrayList<ShoppingItem> getList() {
        return list;
    }
}
