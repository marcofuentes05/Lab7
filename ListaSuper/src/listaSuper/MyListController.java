package listaSuper;

import clases.ShoppingItem;
import clases.ShoppingList;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class MyListController {
    @FXML
    Label nameLabel;
    @FXML
    Button backButton;
    @FXML
    Button addButton;
    @FXML
    Button pendingButton;
    @FXML
    Button boughtButton;
    @FXML
    static TableView <ShoppingItem> itemsTable;
    @FXML
    static TableColumn articleColumn;
    @FXML
    static TableColumn amountColumn;
    @FXML
    static TableColumn perUnitColumn;
    @FXML
    static TableColumn totalColumn;
    @FXML
    static TableColumn stateColumn;



    @FXML
    public void setTitle(String a){
        nameLabel.setText("Mi lista de "+a);
    }

    @FXML
    public static void initTable (ShoppingList lista){
        ObservableList<ShoppingItem> list = FXCollections.observableArrayList(lista.getList());

        try{
            articleColumn.setCellValueFactory(new PropertyValueFactory<ShoppingList,String>("name"));
            amountColumn.setCellValueFactory(new PropertyValueFactory<ShoppingList,SimpleIntegerProperty>("amount"));
            perUnitColumn.setCellValueFactory(new PropertyValueFactory<ShoppingList,SimpleDoubleProperty>("prizeU"));
            totalColumn.setCellValueFactory(new PropertyValueFactory<ShoppingList,SimpleDoubleProperty>("totalPrize"));
            stateColumn.setCellValueFactory(new PropertyValueFactory<ShoppingList,Boolean>("state"));
            itemsTable.setItems(list);
        }catch (Exception e){
            System.out.println(e.getCause());
        }



    }
}
