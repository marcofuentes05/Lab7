package listaSuper;

import clases.ShoppingList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.time.LocalDate;
import javafx.stage.StageStyle;

import java.util.ArrayList;

public class Controller {

    @FXML
    TableView<ShoppingList> listTable;
    @FXML
    Button newListButton;
    @FXML
    Button editButton;
    @FXML
    Button deleteButton;
    @FXML
    TableColumn nameColumn;
    @FXML
    TableColumn dateColumn;
    @FXML
    TableColumn prizeColumn;
    @FXML
    TableColumn amountColumn;

    LocalDate date =java.time.LocalDate.now();
    @FXML
    public void initialize(){

        ObservableList<ShoppingList> list = FXCollections.observableArrayList(
                new ShoppingList("Mercado",date,""),
                new ShoppingList("Walmart",date,""),
                new ShoppingList("Utiles",date,"")
        );
        nameColumn.setCellValueFactory(new PropertyValueFactory<ShoppingList,String>("name"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<ShoppingList,String>("date"));
        prizeColumn.setCellValueFactory(new PropertyValueFactory<ShoppingList,String>("name"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<ShoppingList,String>("name"));

        listTable.setItems(list);
    }

    @FXML
    public void handleNewListButtonAction (ActionEvent event){
        System.out.println("JAJAJA SLU2");
        Parent root;
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("newList.fxml"));
            root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Nueva Lista");
            stage.setScene(new Scene(root, 450, 450));
            stage.show();
            System.out.println("no error :D");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void createActionHandler (ActionEvent e){

    }
}
