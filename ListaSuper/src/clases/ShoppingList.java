package clases;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ShoppingList {
    private String name;
    private LocalDate date;
    private String descripcion;
    private ObservableList<ShoppingItem> list;

    public ShoppingList(String n, LocalDate f, String d){
        this.name=n;
        this.date= f;
        this.descripcion=d;
        this.list= FXCollections.observableArrayList();
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
}
