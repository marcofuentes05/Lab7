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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.time.LocalDate;

import static listaSuper.Main.lista;

public class NewListController {
    @FXML
    Button backButton;
    @FXML
    TextField nameField;
    @FXML
    TextArea description;
    @FXML
    Button newListButton;
    public void backButtonActionHandle (Event e){
        try{

        }catch(Exception e1){}
    }
    public void createButtonActionHandle(ActionEvent e){
        try{
            if(nameField.getText()!=null){
                if(description.getText()!=null){
                    String name = nameField.getText();
                    String des = description.getText();
                    LocalDate date = java.time.LocalDate.now();
                    lista.add(new ShoppingList(name,date,des));
                }
            }
        }catch(Exception e2){}
    }
}
