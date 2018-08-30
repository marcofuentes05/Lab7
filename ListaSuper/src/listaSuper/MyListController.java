package listaSuper;

import clases.ShoppingItem;
import clases.ShoppingList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

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
    TableView <ShoppingItem> itemsTable;
    @FXML
    TableColumn articleColumn;
    @FXML
    TableColumn amountColumn;
    @FXML
    TableColumn perUnitColumn;
    @FXML
    TableColumn totalColumn;
    @FXML
    TableColumn stateColumn;
    @FXML
    Label totalPendingLabel;

    ShoppingList selectedList;



    @FXML
    public void setTitle(String a){
        nameLabel.setText("Mi lista de "+a);
    }

    @FXML
    public ObservableList<ShoppingItem> algo(){
        ObservableList<ShoppingItem> data = FXCollections.observableArrayList(selectedList.getList());
        return data;
    }

    public void setSelectedList(ShoppingList a){
        this.selectedList = a;
    }
    @FXML
    public  void initialize (){
        try{
            ObservableList<ShoppingItem> data = FXCollections.observableArrayList(selectedList.getList());

            articleColumn.setCellValueFactory  (new PropertyValueFactory<ShoppingItem,String>("name"));
            amountColumn. setCellValueFactory  (new PropertyValueFactory<ShoppingItem,String>("amount"));
            perUnitColumn.setCellValueFactory  (new PropertyValueFactory<ShoppingItem,String>("prizeU"));
            totalColumn.  setCellValueFactory  (new PropertyValueFactory<ShoppingItem,String>("prizeT"));
            stateColumn.  setCellValueFactory  (new PropertyValueFactory<ShoppingItem,String>("state"));

            itemsTable.setItems(data);
            totalPendingLabel.setText("Total Pendiente: "+Controller.getSelectedList().getPrize());

        }catch(Exception e){
            //e.printStackTrace();
        }
    }

    @FXML
    public void backButtonActionHandle (Event e){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("principal.fxml"));
            Parent root = loader.load();
            Stage stage0 = new Stage();
            stage0.setTitle("Control de Listas de Compras");
            stage0.setScene(new Scene(root, 600, 400));
            stage0.show();


            // get a handle to the stage
            Stage stage = (Stage) backButton.getScene().getWindow();
            // do what you have to do
            stage.close();
        }catch(Exception e1){}
    }

    @FXML
    public void setPendingButtonAction(){
        if (itemsTable.getSelectionModel().getSelectedItem() != null){
            itemsTable.getSelectionModel().getSelectedItem().setState(false);
        }
        itemsTable.getColumns().get(0).setVisible(false);
        itemsTable.getColumns().get(0).setVisible(true);
    }

    @FXML
    public void setBoughtButtonAction(){
        if (itemsTable.getSelectionModel().getSelectedItem() != null){
            itemsTable.getSelectionModel().getSelectedItem().setState(true);
        }

        itemsTable.getColumns().get(0).setVisible(false);
        itemsTable.getColumns().get(0).setVisible(true);
    }

    @FXML
    public void addButtonAction(){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("newItem.fxml"));
            Parent root = loader.load();
            Stage stage0 = new Stage();
            stage0.setTitle("Nuevo Item");
            stage0.setScene(new Scene(root, 600, 400));
            stage0.show();

            // get a handle to the stage
            Stage stage = (Stage) addButton.getScene().getWindow();
            // do what you have to do
            stage.close();
        }catch(Exception i){}

    }
}
