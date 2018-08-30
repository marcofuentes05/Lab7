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
import java.util.Date;

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
    static ShoppingList selectedList;


    public  TableView <ShoppingList> getListTable(){
        return listTable;
    }


    void refreshTableView(){
        getListTable().getColumns().get(0).setVisible(false);
        getListTable().getColumns().get(0).setVisible(true);
    }
    @FXML
    public void initialize(){
        for (int i = 0;i<Main.getMainList().size();i++){
            Main.getMainList().get(i).refresh();
        }

        nameColumn.setCellValueFactory(new PropertyValueFactory<ShoppingList,String>("name"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<ShoppingList,Date>("date"));
        prizeColumn.setCellValueFactory(new PropertyValueFactory<ShoppingList,Double>("prize"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<ShoppingList,Integer>("pendingItems"));

        refreshTableView();

        listTable.setItems(Main.getMainList());
    }

    @FXML
    public void handleNewListButtonAction (ActionEvent event){
        Parent root;
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("newList.fxml"));
            root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Nueva Lista");
            stage.setScene(new Scene(root, 600, 400));
            stage.show();


            // get a handle to the stage
            Stage stage0 = (Stage) newListButton.getScene().getWindow();
            // do what you have to do
            stage0.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    public void editActionHandler (ActionEvent e){
        Parent root;
        try{
            if (listTable.getSelectionModel().getSelectedItem() != null){
                selectedList = listTable.getSelectionModel().getSelectedItem();

                FXMLLoader loader = new FXMLLoader(getClass().getResource("myList.fxml"));
                root = loader.load();
                Stage stage = new Stage();
                stage.setTitle("Editor");
                stage.setScene(new Scene(root, 600, 400));
                MyListController myListController = loader.getController();
                myListController.setSelectedList(selectedList);
                myListController.setTitle(selectedList.getName());
                stage.show();

                // get a handle to the stage
                Stage stage0 = (Stage) editButton.getScene().getWindow();
                // do what you have to do
                stage0.close();
            }else{
                System.out.println("Mano! No seleccionaste nada");
            }
        }catch(Exception e0){e0.getCause();}
    }

    public static ShoppingList getSelectedList(){
        return selectedList;
    }



    @FXML
    public void deleteActionHandler (ActionEvent e){
        try{

            System.out.println("Eliminando...");
            System.out.println(this.listTable.getSelectionModel().getSelectedItem().getName());

            int index = this.listTable.getSelectionModel().getSelectedIndex();
            Main.getMainList().remove(index);
            System.out.println("Eliminado!");
            for(int a =0;a<Main.getMainList().size();a++){
                System.out.println(Main.getMainList().get(a).getName());
            }
            //TODO Ver el metodo eliminar...
        }catch(Exception e4){
            System.out.println("Algo salió mal... \nPuede ser que no hayas seleccoinado nada...");
            //e4.printStackTrace();
        }

    }

    @FXML
    public ShoppingList getSelectedItem(){
        ShoppingList item;
        if (listTable.getSelectionModel().getSelectedItem() != null){
            item = listTable.getSelectionModel().getSelectedItem();
        }else{
            item = null;
        }
        return item;
    }
}
