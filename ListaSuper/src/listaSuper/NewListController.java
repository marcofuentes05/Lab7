package listaSuper;

import clases.ShoppingList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.time.LocalDate;

public class NewListController {
    @FXML
    Label nameLabel;
    @FXML
    Button backButton;
    @FXML
    TextField nameField;
    @FXML
    TextField description;
    @FXML
    Button newListButton;
    @FXML
    public void backButtonActionHandle (Event e){
        try{
            // get a handle to the stage
            Stage stage = (Stage) backButton.getScene().getWindow();
            // do what you have to do
            stage.close();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("principal.fxml"));
            Parent root = loader.load();
            Stage stage0 = new Stage();
            stage0.setTitle("Control de Listas de Compras");
            stage0.setScene(new Scene(root, 600, 400));

            stage0.show();

        }catch(Exception e1){}
    }

    public static ShoppingList getSelectedList(){
        int index = Main.getMainList().size()-1;
        ShoppingList selectedONE = Main.getMainList().get(index);
        return selectedONE;
    }

    @FXML
    public void createButtonActionHandle(Event e){

        try{
            if(nameField.getText()!= ""){
                /*if(description.getText()!= ""){*/
                String name = nameField.getText();
                String des = "asdf";
                LocalDate date = java.time.LocalDate.now();
                Main.getMainList().add(new ShoppingList(name,date,des));
                int ultimo = Main.getMainList().size();

                Main.getMainList().get(ultimo-1).refresh();
                /*}else{
                    System.out.println("Has dejado campos en blanco...");
                }*/

                try{
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("myList.fxml"));
                    Parent root = loader.load();
                    Stage stage = new Stage();
                    stage.setTitle("Editor");
                    stage.setScene(new Scene(root, 600, 400));
                    MyListController myListController = loader.getController();
                    ShoppingList selectedList = Main.getMainList().get(ultimo-1);
                    myListController.setSelectedList(selectedList);

                    myListController.setTitle(selectedList.getName());
                    stage.show();
                }catch(Exception z){}


                // get a handle to the stage
                Stage stage0 = (Stage) newListButton.getScene().getWindow();
                // do what you have to do
                stage0.close();

            }else{
                System.out.println("Has dejado campos en blanco...");
            }
        }catch(Exception e2){
            System.out.println(e2.getCause());
        }
    }
}
