package listaSuper;

import clases.ShoppingItem;
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

    @FXML
    public void editActionHandler (ActionEvent e){
        Parent root;
        try{
            if (listTable.getSelectionModel().getSelectedItem() != null){
                ShoppingList selectedList = listTable.getSelectionModel().getSelectedItem();

                String name = this.listTable.getSelectionModel().getSelectedItem().getName();
                System.out.println(name);
                FXMLLoader loader = new FXMLLoader(getClass().getResource("myList.fxml"));
                root = loader.load();
                Stage stage = new Stage();
                stage.setTitle("Editor");
                stage.setScene(new Scene(root, 600, 400));

                MyListController myListController = loader.getController();

                myListController.setTitle(selectedList.getName());

                MyListController.initTable(selectedList);

                stage.show();

            }else{
                System.out.println("Mano! No seleccionaste nada");
            }
        }catch(Exception e0){e0.printStackTrace();}
    }

    @FXML
    public void deleteActionHandler (ActionEvent e){
        try{
            System.out.println("Eliminando...");
            System.out.println(this.listTable.getSelectionModel().getSelectedItem().getName());
            int index = this.listTable.getSelectionModel().getSelectedIndex();
            Main.lista.remove(index);
            System.out.println("Eliminado!");
            for(int a =0;a<Main.lista.size();a++){
                System.out.println(Main.lista.get(a).getName());
            }
            //TODO Ver el metodo eliminar...
        }catch(Exception e4){
            System.out.println("Algo salió mal... \nPuede ser que no hayas seleccoinado nada...");
            //e4.printStackTrace();
        }

    }
}
