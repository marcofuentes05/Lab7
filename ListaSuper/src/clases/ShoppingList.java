package clases;

import java.util.ArrayList;
import java.util.List;

public class ShoppingList {
    private String name;
    private String date;
    private ArrayList<ShoppingItem> list;

    public ShoppingList(){}

    public ShoppingList(String n, String f){
        this.name=n;
        this.date= f;
        this.list= new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public ArrayList<ShoppingItem> getList() {
        return list;
    }
}
