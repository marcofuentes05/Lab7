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
import javafx.stage.StageStyle;

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

    @FXML
    public void initialize(){
        ObservableList<ShoppingList> list = FXCollections.observableArrayList(
                new ShoppingList("Mercado","14-5-14"),
                new ShoppingList("Walmart","22-8-2018"),
                new ShoppingList("Utiles","1-1-18")
        );
        nameColumn.setCellValueFactory(new PropertyValueFactory<ShoppingList,String>("name"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<ShoppingList,String>("date"));
        prizeColumn.setCellValueFactory(new PropertyValueFactory<ShoppingList,String>("name"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<ShoppingList,String>("name"));

        listTable.setItems(list);

    }

    @FXML
    void handleNewListButtonAction (ActionEvent event){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("newList.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.DECORATED); // o puede ser UNDECORATED
            stage.setTitle("Nueva Lista");
            stage.setScene(new Scene(root1));
            stage.show();
        }catch(Exception e){}
    }
}
